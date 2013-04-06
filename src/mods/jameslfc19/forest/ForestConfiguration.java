package mods.jameslfc19.forest;

import mods.jameslfc19.forest.blocks.BlockThickwood;
import mods.jameslfc19.forest.blocks.BlockThickwoodLeaves;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;

public class ForestConfiguration {
	
	public static void init(Configuration config) {
		
		JamesForest.thickwood = new BlockThickwood(config.getBlock("Thickwood Log", 2004).getInt(2004));
		JamesForest.leaves = new BlockThickwoodLeaves(config.getBlock("Thickwood Leaves", 2005).getInt(2005));
		
		OreDictionary.registerOre("logThickwood", JamesForest.thickwood);
		
	}

}
