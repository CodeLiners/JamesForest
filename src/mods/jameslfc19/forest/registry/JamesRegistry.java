package mods.jameslfc19.forest.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import mods.jameslfc19.forest.JamesWorld;
import net.minecraft.world.biome.BiomeGenBase;
import mods.jameslfc19.forest.WorldTab;
import mods.jameslfc19.forest.biomes.BiomeGenDenseForest;
import mods.jameslfc19.forest.biomes.BiomeGenIcyMountains;
import mods.jameslfc19.forest.biomes.BiomeSavanna;
import mods.jameslfc19.forest.entity.mob.EntityIceGolem;
import mods.jameslfc19.forest.world.WorldGenCoral;
import mods.jameslfc19.forest.world.WorldGenIce;
import mods.jameslfc19.forest.world.WorldGenLimestone;
import mods.jameslfc19.forest.world.WorldGenOre;
import mods.jameslfc19.forest.world.WorldGenRareOak;
import mods.jameslfc19.forest.world.WorldGenShrine;
import mods.jameslfc19.forest.world.WorldGenThickwood;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class JamesRegistry {
	
	public static BiomeGenBase SAVANNA = new BiomeSavanna(70);
	public static BiomeGenBase ICY_MOUNTAIN = new BiomeGenIcyMountains(71);
	
	public static CreativeTabs tab;
	
	public static void CreativeTabInit(){
		tab = new WorldTab();
		JamesBlock.thickwood.setCreativeTab(tab);
		JamesBlock.leaves.setCreativeTab(tab);
		JamesBlock.materials.setCreativeTab(tab);
		JamesBlock.coral.setCreativeTab(tab);
		
		//JamesItem.dustGranite.setCreativeTab(tab);
	}
	
	public static void BiomeInit(){
		//GameRegistry.addBiome(new BiomeGenDenseForest(70));
		GameRegistry.addBiome(SAVANNA);
		GameRegistry.addBiome(ICY_MOUNTAIN);
	}
	
	public static void WorldGenInit(){
		GameRegistry.registerWorldGenerator(new WorldGenOre()); 
		GameRegistry.registerWorldGenerator(new WorldGenIce()); 
		GameRegistry.registerWorldGenerator(new WorldGenCoral()); 
		GameRegistry.registerWorldGenerator(new WorldGenThickwood()); 
		GameRegistry.registerWorldGenerator(new WorldGenRareOak()); 
		GameRegistry.registerWorldGenerator(new WorldGenShrine()); 
		GameRegistry.registerWorldGenerator(new WorldGenLimestone()); 
	}
	
	public static void EntityInit(){
		//IceGolem
		EntityRegistry.registerModEntity(EntityIceGolem.class, "IceGolem", 1, JamesWorld.class, 80, 3, true);
		EntityRegistry.addSpawn(EntityIceGolem.class, 10, 2, 4, EnumCreatureType.creature, BiomeGenBase.beach, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.swampland);
	}
	
}
