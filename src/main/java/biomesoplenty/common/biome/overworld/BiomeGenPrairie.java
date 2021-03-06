package biomesoplenty.common.biome.overworld;

import biomesoplenty.api.biome.BOPBiome;
import biomesoplenty.api.biome.generation.GeneratorStage;
import biomesoplenty.api.biome.generation.GeneratorWeighted;
import biomesoplenty.common.block.BlockBOPDoublePlant;
import biomesoplenty.common.block.BlockBOPMushroom;
import biomesoplenty.common.enums.BOPClimates;
import biomesoplenty.common.enums.BOPFlowers;
import biomesoplenty.common.enums.BOPGems;
import biomesoplenty.common.enums.BOPPlants;
import biomesoplenty.common.world.BOPWorldSettings;
import biomesoplenty.common.world.feature.GeneratorDoubleFlora;
import biomesoplenty.common.world.feature.GeneratorFlora;
import biomesoplenty.common.world.feature.GeneratorGrass;
import biomesoplenty.common.world.feature.GeneratorOreSingle;
import biomesoplenty.common.world.feature.tree.GeneratorTaigaTree;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.BlockPos;

public class BiomeGenPrairie extends BOPBiome
{
    public BiomeGenPrairie()
    {
        // terrain
        this.terrainSettings.avgHeight(64).heightVariation(4, 15);
        
        this.setColor(0xC8E580);
        this.setTemperatureRainfall(0.8F, 0.3F);
        
        this.addWeight(BOPClimates.WARM_TEMPERATE, 10);
        
        this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 1, 2, 6));
        
        // trees
        this.addGenerator("trees", GeneratorStage.TREE, (new GeneratorTaigaTree.Builder()).amountPerChunk(1).minHeight(6).maxHeight(8).log(EnumType.OAK).leaves(EnumType.OAK).create()); // TODO: implement pine cones
        
        // grasses
        GeneratorWeighted grassGenerator = new GeneratorWeighted(100);
        this.addGenerator("grass", GeneratorStage.GRASS, grassGenerator);
        grassGenerator.add("shortgrass", 2, (new GeneratorGrass.Builder()).with(BOPPlants.SHORTGRASS).create());
        grassGenerator.add("mediumgrass", 3, (new GeneratorGrass.Builder()).with(BOPPlants.MEDIUMGRASS).create());        
        grassGenerator.add("wheatgrass", 1, (new GeneratorGrass.Builder()).with(BOPPlants.WHEATGRASS).create());
        grassGenerator.add("dampgrass", 2, (new GeneratorGrass.Builder()).with(BOPPlants.DAMPGRASS).create());
        grassGenerator.add("tallgrass", 6, (new GeneratorGrass.Builder()).with(BlockTallGrass.EnumType.GRASS).create());
        
        // flowers
        GeneratorWeighted flowerGenerator = new GeneratorWeighted(0.6F);
        this.addGenerator("flowers", GeneratorStage.GRASS, flowerGenerator);
        flowerGenerator.add("white_anemones", 1, (new GeneratorFlora.Builder().with(BOPFlowers.WHITE_ANEMONE).generationAttempts(16).create()));
        flowerGenerator.add("goldenrods", 2, (new GeneratorFlora.Builder().with(BOPFlowers.GOLDENROD).generationAttempts(16).create()));
        
        // other plants
        this.addGenerator("berry_bushes", GeneratorStage.FLOWERS, (new GeneratorFlora.Builder()).amountPerChunk(0.4F).with(BOPPlants.BERRYBUSH).generationAttempts(8).create());
        this.addGenerator("shrubs", GeneratorStage.FLOWERS, (new GeneratorFlora.Builder()).amountPerChunk(0.7F).with(BOPPlants.SHRUB).create());
        this.addGenerator("water_reeds", GeneratorStage.LILYPAD, (new GeneratorFlora.Builder()).amountPerChunk(1).with(BOPPlants.REED).generationAttempts(32).create());
        this.addGenerator("leaf_piles", GeneratorStage.FLOWERS, (new GeneratorFlora.Builder()).amountPerChunk(5).with(BOPPlants.LEAFPILE).generationAttempts(32).create());
        this.addGenerator("flax", GeneratorStage.FLOWERS, (new GeneratorDoubleFlora.Builder()).amountPerChunk(0.2F).with(BlockBOPDoublePlant.DoublePlantType.FLAX).generationAttempts(8).create());
        
        // shrooms
        this.addGenerator("portobellos", GeneratorStage.SHROOM,(new GeneratorFlora.Builder()).amountPerChunk(2).with(BlockBOPMushroom.MushroomType.PORTOBELLO).create());
        
        // gem
        this.addGenerator("tanzanite", GeneratorStage.SAND, (new GeneratorOreSingle.Builder()).amountPerChunk(12).with(BOPGems.TANZANITE).create());
    }
    
    @Override
    public void applySettings(BOPWorldSettings settings)
    {
        if (!settings.generateBopGems) {this.removeGenerator("tanzanite");}
    }
    
    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        return 13165952;
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return 11395195;
    }
}
