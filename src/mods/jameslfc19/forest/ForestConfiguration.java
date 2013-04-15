package mods.jameslfc19.forest;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.jameslfc19.forest.blocks.BlockGranite;
import mods.jameslfc19.forest.blocks.BlockGraniteBrick;
import mods.jameslfc19.forest.blocks.BlockLimestone;
import mods.jameslfc19.forest.blocks.BlockLimestoneBrick;
import mods.jameslfc19.forest.blocks.BlockSuperStone;
import mods.jameslfc19.forest.blocks.BlockThickwood;
import mods.jameslfc19.forest.blocks.BlockThickwoodLeaves;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;

public class ForestConfiguration {
	
	public static void init(Configuration config) {
		
		JamesForest.thickwood = new BlockThickwood(config.getBlock("Thickwood Log", 2004).getInt(2004));
		JamesForest.leaves = new BlockThickwoodLeaves(config.getBlock("Thickwood Leaves", 2005).getInt(2005));
		JamesForest.stoneGranite = new BlockGranite(config.getBlock("Granite", 2006).getInt(2006));
		JamesForest.brickGranite = new BlockGraniteBrick(config.getBlock("Granite Brick", 2007).getInt(2007));
		JamesForest.superStone = new BlockSuperStone(config.getBlock("Super Stone[Dungeon Block]", 2008).getInt(2008));
		JamesForest.stoneLimestone = new BlockLimestone(config.getBlock("Limestone", 2009).getInt(2009));
		JamesForest.brickLimestone = new BlockLimestoneBrick(config.getBlock("Limestone Brick", 2010).getInt(2010));
		
		OreDictionary.registerOre("logThickwood", JamesForest.thickwood);
		OreDictionary.registerOre("stoneGranite", JamesForest.stoneGranite);
		OreDictionary.registerOre("stoneLimestone", JamesForest.stoneLimestone);
		
		GameRegistry.addSmelting(JamesForest.thickwood.blockID, new ItemStack(Item.coal, 1, 1), 1.0F);
		GameRegistry.addRecipe(new ItemStack(Block.planks, 4, 1), new Object[]{"X", 'X', JamesForest.thickwood});
		GameRegistry.addRecipe(new ItemStack(JamesForest.brickGranite, 4), new Object[]{"XX ", "XX ", 'X', JamesForest.stoneGranite});
		GameRegistry.addRecipe(new ItemStack(JamesForest.brickLimestone, 4), new Object[]{"XX ", "XX ", 'X', JamesForest.stoneLimestone});
		
		config.save();
	}

}
