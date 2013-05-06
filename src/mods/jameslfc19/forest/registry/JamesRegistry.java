package mods.jameslfc19.forest.registry;

import net.minecraft.creativetab.CreativeTabs;
import mods.jameslfc19.forest.ForestTab;
import mods.jameslfc19.forest.biomes.BiomeGenDenseForest;
import mods.jameslfc19.forest.item.ItemSlab;
import mods.jameslfc19.forest.world.WorldGenLimestone;
import mods.jameslfc19.forest.world.WorldGenMysticalDungeon;
import mods.jameslfc19.forest.world.WorldGenOre;
import mods.jameslfc19.forest.world.WorldGenRareOak;
import mods.jameslfc19.forest.world.WorldGenShrine;
import mods.jameslfc19.forest.world.WorldGenThickwood;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class JamesRegistry {
	public static CreativeTabs tab;
	
	public static void BlockInit(){
		GameRegistry.registerBlock(JamesBlock.thickwood, "Thickwood Log");
		GameRegistry.registerBlock(JamesBlock.leaves, "Thickwood Leaves");
		GameRegistry.registerBlock(JamesBlock.stoneGranite, "Granite");
		GameRegistry.registerBlock(JamesBlock.brickGranite, "Granite Bricks");
		GameRegistry.registerBlock(JamesBlock.superStone, "Super Stone[Dungeon Block]");
		GameRegistry.registerBlock(JamesBlock.stoneLimestone, "Limestone");
		GameRegistry.registerBlock(JamesBlock.brickLimestone, "Limestone Brick");
		GameRegistry.registerBlock(JamesBlock.slabs, ItemSlab.class, "Stone Slab");
		GameRegistry.registerBlock(JamesBlock.stairsGranite, "Granite Stairs");
		GameRegistry.registerBlock(JamesBlock.stairsLimestone, "Limestone Stairs");
	}
	
	public static void ItemInit(){
		if (Loader.isModLoaded("IC2")){
		GameRegistry.registerItem(JamesItem.dustGranite, "Granite Quartz Dust");
		} 
		if (Loader.isModLoaded("ThermalExpansion")){
		GameRegistry.registerItem(JamesItem.pulverizedGranite, "Pulverized Granite");
		}
	}
	
	public static void CreativeTabInit(){
		tab = new ForestTab();
		JamesBlock.thickwood.setCreativeTab(tab);
		JamesBlock.leaves.setCreativeTab(tab);
		JamesBlock.stoneGranite.setCreativeTab(tab);
		JamesBlock.brickGranite.setCreativeTab(tab);
		JamesBlock.stoneLimestone.setCreativeTab(tab);
		JamesBlock.brickLimestone.setCreativeTab(tab);
		//JamesBlock.superStone.setCreativeTab(tab);
		JamesBlock.slabs.setCreativeTab(tab);
		JamesBlock.stairsGranite.setCreativeTab(tab);
		JamesBlock.stairsLimestone.setCreativeTab(tab);
		
		if (Loader.isModLoaded("IC2")){
		JamesItem.dustGranite.setCreativeTab(tab);
		} 
		if (Loader.isModLoaded("ThermalExpansion")){
		JamesItem.pulverizedGranite.setCreativeTab(tab);
		}
	}
	
	public static void BiomeInit(){
		GameRegistry.addBiome(new BiomeGenDenseForest(70));
	}
	
	public static void WorldGenInit(){
		GameRegistry.registerWorldGenerator(new WorldGenOre()); 
		GameRegistry.registerWorldGenerator(new WorldGenThickwood()); 
		GameRegistry.registerWorldGenerator(new WorldGenRareOak()); 
		GameRegistry.registerWorldGenerator(new WorldGenShrine()); 
		GameRegistry.registerWorldGenerator(new WorldGenMysticalDungeon()); 
		GameRegistry.registerWorldGenerator(new WorldGenLimestone()); 
	}
	
}
