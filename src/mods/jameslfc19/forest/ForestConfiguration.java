package mods.jameslfc19.forest;

import mods.jameslfc19.forest.blocks.BlockGranite;
import mods.jameslfc19.forest.blocks.BlockGraniteBrick;
import mods.jameslfc19.forest.blocks.BlockJamesStairs;
import mods.jameslfc19.forest.blocks.BlockLimestone;
import mods.jameslfc19.forest.blocks.BlockLimestoneBrick;
import mods.jameslfc19.forest.blocks.BlockSlab;
import mods.jameslfc19.forest.blocks.BlockStep;
import mods.jameslfc19.forest.blocks.BlockSuperStone;
import mods.jameslfc19.forest.blocks.BlockThickwood;
import mods.jameslfc19.forest.blocks.BlockThickwoodLeaves;
import mods.jameslfc19.forest.item.ItemDust;
import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.registry.JamesItem;
import net.minecraft.block.BlockHalfSlab;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;

public class ForestConfiguration {
	
	public static void init(Configuration config) {
		
		JamesBlock.thickwood = new BlockThickwood(config.getBlock("Thickwood Log", 2004).getInt(2004));
		JamesBlock.leaves = new BlockThickwoodLeaves(config.getBlock("Thickwood Leaves", 2005).getInt(2005));
		JamesBlock.stoneGranite = new BlockGranite(config.getBlock("Granite", 2006).getInt(2006));
		JamesBlock.brickGranite = new BlockGraniteBrick(config.getBlock("Granite Brick", 2007).getInt(2007));
		JamesBlock.superStone = new BlockSuperStone(config.getBlock("Super Stone[Dungeon Block]", 2008).getInt(2008));
		JamesBlock.stoneLimestone = new BlockLimestone(config.getBlock("Limestone", 2009).getInt(2009));
		JamesBlock.brickLimestone = new BlockLimestoneBrick(config.getBlock("Limestone Brick", 2010).getInt(2010));
		JamesItem.dustGranite =  new ItemDust(config.getItem("Granite Quartz Dust", 2011).getInt(2011), "Granite", true);
		JamesItem.pulverizedGranite =  new ItemDust(config.getItem("Pulverized Granite", 2012).getInt(2012), "Granite", false);
		
		JamesBlock.slabsDouble = (BlockHalfSlab)(new BlockStep(config.getBlock("Slab Double", 2013).getInt(2013), true));
		JamesBlock.slabsSingle = (BlockHalfSlab)(new BlockStep(config.getBlock("Slab Single", 2014).getInt(2014), false));
		
		JamesBlock.stairsGranite = new BlockJamesStairs(config.getBlock("Granite Stairs", 2015).getInt(2015), JamesBlock.brickGranite, 0, "Granite");
		JamesBlock.stairsLimestone = new BlockJamesStairs(config.getBlock("Limestone Stairs", 2016).getInt(2016), JamesBlock.brickLimestone, 0, "Limestone");
		
		OreDictionary.registerOre("logThickwood", JamesBlock.thickwood);
		OreDictionary.registerOre("stoneGranite", JamesBlock.stoneGranite);
		OreDictionary.registerOre("stoneLimestone", JamesBlock.stoneLimestone);
		OreDictionary.registerOre("dustGranite", JamesItem.dustGranite);
		
		config.save();
	}



}
