package mods.jameslfc19.forest.blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.material.Material;
import themike.core.block.BlockBase;

// Sit back and watch MCore do magic.
public class BlockMaterials extends BlockBase {

	public BlockMaterials(int id) {
		super(id, Material.rock, "jamesworld", "materials", new ArrayList<String>(Arrays.asList("stoneGranite", "stoneLimestone", "brickGranite", "carvedGranite", "brickLimestone")));
	}

}
