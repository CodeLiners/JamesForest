package mods.jameslfc19.forest;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.jameslfc19.forest.blocks.BlockCoral;
import mods.jameslfc19.forest.blocks.BlockMaterials;
import mods.jameslfc19.forest.blocks.BlockThickwood;
import mods.jameslfc19.forest.blocks.BlockThickwoodLeaves;
import mods.jameslfc19.forest.item.FoodWolfMeat;
import mods.jameslfc19.forest.item.ItemDust;
import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.registry.JamesItem;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;

public class WorldConfiguration {
	
	public static void init(Configuration config) {
		
		JamesBlock.thickwood = new BlockThickwood(config.getBlock("Thickwood Log", 2004).getInt(2004));
		JamesBlock.leaves = new BlockThickwoodLeaves(config.getBlock("Thickwood Leaves", 2005).getInt(2005));
		JamesBlock.materials = new BlockMaterials(config.getBlock("Materials", 2006).getInt(2006));	
		JamesBlock.coral = new BlockCoral(config.getBlock("Coral", 2007).getInt(2007));	
		
		GameRegistry.registerBlock(JamesBlock.thickwood, "Thickwood");
		GameRegistry.registerBlock(JamesBlock.leaves, "Thickwood Leaves");

		//JamesItem.dustGranite =  new ItemDust(config.getItem("Granite Quartz Dust", 2011).getInt(2011));
		JamesItem.wolfMeat =  new FoodWolfMeat(config.getItem("Wolf Meat", 2012).getInt(2012));
		
		OreDictionary.registerOre("logThickwood", JamesBlock.thickwood);
		OreDictionary.registerOre("worldMaterials", new ItemStack(JamesBlock.materials));
		
		//OreDictionary.registerOre("dustGranite", JamesItem.dustGranite);
		
		config.save();
	}

}
