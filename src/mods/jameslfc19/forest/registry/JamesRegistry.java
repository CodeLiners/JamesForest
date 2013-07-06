package mods.jameslfc19.forest.registry;

import net.minecraft.creativetab.CreativeTabs;
import mods.jameslfc19.forest.WorldTab;
import mods.jameslfc19.forest.biomes.BiomeGenDenseForest;
<<<<<<< HEAD
import mods.jameslfc19.forest.biomes.BiomeSavanna;
=======
>>>>>>> fcc7b27ab2a9402f31c0637b512ed9e3ebd48407
import mods.jameslfc19.forest.world.WorldGenLimestone;
import mods.jameslfc19.forest.world.WorldGenOre;
import mods.jameslfc19.forest.world.WorldGenRareOak;
import mods.jameslfc19.forest.world.WorldGenShrine;
import mods.jameslfc19.forest.world.WorldGenThickwood;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class JamesRegistry {
	public static CreativeTabs tab;
	
	public static void CreativeTabInit(){
		tab = new WorldTab();
		JamesBlock.thickwood.setCreativeTab(tab);
		JamesBlock.leaves.setCreativeTab(tab);
		JamesBlock.materials.setCreativeTab(tab);
		
<<<<<<< HEAD
		//JamesItem.dustGranite.setCreativeTab(tab);
=======
		JamesItem.dustGranite.setCreativeTab(tab);
>>>>>>> fcc7b27ab2a9402f31c0637b512ed9e3ebd48407
	}
	
	public static void BiomeInit(){
		//GameRegistry.addBiome(new BiomeGenDenseForest(70));
		GameRegistry.addBiome(new BiomeSavanna(70));
	}
	
	public static void WorldGenInit(){
		GameRegistry.registerWorldGenerator(new WorldGenOre()); 
		GameRegistry.registerWorldGenerator(new WorldGenThickwood()); 
		GameRegistry.registerWorldGenerator(new WorldGenRareOak()); 
		GameRegistry.registerWorldGenerator(new WorldGenShrine()); 
		GameRegistry.registerWorldGenerator(new WorldGenLimestone()); 
	}
	
}
