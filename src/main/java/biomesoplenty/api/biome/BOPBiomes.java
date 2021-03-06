/*******************************************************************************
 * Copyright 2015-2016, the Biomes O' Plenty Team
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package biomesoplenty.api.biome;

import com.google.common.base.Optional;

import net.minecraft.world.biome.BiomeGenBase;

public class BOPBiomes
{
    public static final IBiomeRegistry REG_INSTANCE = createRegistry();
    
    // normal biomes which have weights
    public static Optional<BiomeGenBase> alps = Optional.absent();
    public static Optional<BiomeGenBase> arctic = Optional.absent();
    public static Optional<BiomeGenBase> bamboo_forest = Optional.absent();
    public static Optional<BiomeGenBase> bayou = Optional.absent();
    public static Optional<BiomeGenBase> bog = Optional.absent();
    public static Optional<BiomeGenBase> boreal_forest = Optional.absent();
    public static Optional<BiomeGenBase> brushland = Optional.absent();
    public static Optional<BiomeGenBase> canyon = Optional.absent();
    public static Optional<BiomeGenBase> chaparral = Optional.absent();
    public static Optional<BiomeGenBase> cherry_blossom_grove = Optional.absent();
    public static Optional<BiomeGenBase> cold_desert = Optional.absent();
    public static Optional<BiomeGenBase> coniferous_forest = Optional.absent();
    public static Optional<BiomeGenBase> crag = Optional.absent();
    public static Optional<BiomeGenBase> dead_forest = Optional.absent();
    public static Optional<BiomeGenBase> dead_swamp = Optional.absent();
    public static Optional<BiomeGenBase> deciduous_forest = Optional.absent();
    public static Optional<BiomeGenBase> eucalyptus_forest = Optional.absent();
    public static Optional<BiomeGenBase> fen = Optional.absent();
    public static Optional<BiomeGenBase> dense_forest = Optional.absent();
    public static Optional<BiomeGenBase> flower_field = Optional.absent();
    public static Optional<BiomeGenBase> frost_forest = Optional.absent();
    public static Optional<BiomeGenBase> frozen_desert = Optional.absent();
    public static Optional<BiomeGenBase> fungi_forest = Optional.absent();
    public static Optional<BiomeGenBase> garden = Optional.absent();
    public static Optional<BiomeGenBase> grassland = Optional.absent();    
    public static Optional<BiomeGenBase> grove = Optional.absent();
    public static Optional<BiomeGenBase> heathland = Optional.absent();    
    public static Optional<BiomeGenBase> highland = Optional.absent();
    public static Optional<BiomeGenBase> jade_cliffs = Optional.absent();
    public static Optional<BiomeGenBase> lavender_fields = Optional.absent();
    public static Optional<BiomeGenBase> marsh = Optional.absent();
    public static Optional<BiomeGenBase> moor = Optional.absent();
    public static Optional<BiomeGenBase> mountain = Optional.absent();
    public static Optional<BiomeGenBase> origin_valley = Optional.absent();
    public static Optional<BiomeGenBase> outback = Optional.absent();
    public static Optional<BiomeGenBase> prairie = Optional.absent();
    public static Optional<BiomeGenBase> sacred_springs = Optional.absent();
    public static Optional<BiomeGenBase> shrubland = Optional.absent();
    public static Optional<BiomeGenBase> steppe = Optional.absent();
    public static Optional<BiomeGenBase> thicket = Optional.absent();
    public static Optional<BiomeGenBase> tundra = Optional.absent();
    public static Optional<BiomeGenBase> woodland = Optional.absent();
    public static Optional<BiomeGenBase> xeric_shrubland = Optional.absent();
    
    // edge-biomes, sub-biomes and mutated-biomes
    public static Optional<BiomeGenBase> glacier = Optional.absent();
    public static Optional<BiomeGenBase> mountain_foothills = Optional.absent();
    public static Optional<BiomeGenBase> canyon_ravine = Optional.absent();

    //Biome extensions
    public static IExtendedBiome end_extension;
    
    private static IBiomeRegistry createRegistry()
    {
        IBiomeRegistry instance = null;
        
        try 
        {
            instance = (IBiomeRegistry)Class.forName("biomesoplenty.common.init.ModBiomes").newInstance();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return instance;
    }
    
    public static interface IBiomeRegistry
    {
        public IExtendedBiome registerBiome(IExtendedBiome biome, String idName);
        public IExtendedBiome getExtendedBiome(BiomeGenBase biome);
    }
}
