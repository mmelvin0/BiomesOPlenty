package biomesoplenty.common.biomes.overworld;

import biomesoplenty.api.BOPBlockHelper;
import biomesoplenty.common.biomes.BOPBiome;
import biomesoplenty.common.configuration.BOPConfigurationMisc;
import biomesoplenty.common.world.features.WorldGenBOPTallGrass;
import biomesoplenty.common.world.features.trees.WorldGenBogTree1;
import biomesoplenty.common.world.features.trees.WorldGenBogTree2;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenSludgepit extends BOPBiome
{
    private static final Height biomeHeight = new Height(0.0F, 0.1F);

    public BiomeGenSludgepit(int id)
    {
        super(id);
        
        //TODO: setHeight()
        this.setHeight(biomeHeight);
        //TODO: setColor()
        this.setColor(7627817);
        this.setTemperatureRainfall(0.8F, 0.9F);

        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();

        this.spawnableCreatureList.add(new SpawnListEntry(EntitySlime.class, 1, 1, 1));

        this.waterColorMultiplier = 11506176;

        this.theBiomeDecorator.treesPerChunk = 30;
        this.theBiomeDecorator.grassPerChunk = 30;
        this.theBiomeDecorator.mushroomsPerChunk = 8;
        this.theBiomeDecorator.flowersPerChunk = -999;
        this.theBiomeDecorator.sandPerChunk = -999;
        this.theBiomeDecorator.sandPerChunk2 = -999;
        this.theBiomeDecorator.deadBushPerChunk = 5;

        this.bopWorldFeatures.setFeature("mudPerChunk", 5);
        this.bopWorldFeatures.setFeature("algaePerChunk", 2);
        //TODO: FEATURE customBiomeDecorator.poisonWaterPerChunk = 5;
        this.bopWorldFeatures.setFeature("waterReedsPerChunk", 6);
        this.bopWorldFeatures.setFeature("koruPerChunk", 1);
        this.bopWorldFeatures.setFeature("leafPilesPerChunk", 5);
        this.bopWorldFeatures.setFeature("deadLeafPilesPerChunk", 5);

        this.bopWorldFeatures.setFeature("bopGrassPerChunk", 30);

        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(BOPBlockHelper.get("foliage"), 10), 0.5D);
        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(BOPBlockHelper.get("foliage"), 11), 0.5D);
        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(Blocks.tallgrass, 0), 0.5D);
        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(Blocks.tallgrass, 1), 1D);
    }
    
    @Override
    //TODO:                     getRandomWorldGenForTrees()
    public WorldGenAbstractTree func_150567_a(Random random)
    {
        return random.nextInt(3) == 0 ? new WorldGenBogTree2(Blocks.log2, Blocks.leaves2, 1, 1, false, 7, 4) : 
        new WorldGenBogTree1(Blocks.log2, Blocks.leaves2, 1, 1, false, 7, 5);
    }

    @Override
    public void decorate(World world, Random random, int chunkX, int chunkZ)
    {
        super.decorate(world, random, chunkX, chunkZ);
        int var5 = 12 + random.nextInt(6);

        for (int var6 = 0; var6 < var5; ++var6)
        {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(28) + 4;
            int z = chunkZ + random.nextInt(16);

            Block block = world.getBlock(x, y, z);

            if (block != null && block.isReplaceableOreGen(world, x, y, z, Blocks.stone))
            {
                world.setBlock(x, y, z, BOPBlockHelper.get("gemOre"), 10, 2);
            }
        }
    }

	@Override
    public int getBiomeGrassColor(int x, int y, int z)
    {
		return 7627817;
	}

	@Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
		return 9539892;
	}
	
    @Override
    public int getSkyColorByTemp(float par1)
    {
        if (BOPConfigurationMisc.skyColors) return 7039816;
        else return super.getSkyColorByTemp(par1);

    }

	/*@Override
	public int getFogColour()
	{
		return 10463856;
	}

	@Override
	public float getFogCloseness()
	{
	    // TODO Auto-generated method stub
	    return 0.6F;
	}
     */
}