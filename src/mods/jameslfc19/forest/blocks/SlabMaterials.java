package mods.jameslfc19.forest.blocks;

import mods.jameslfc19.forest.registry.JamesRegistry;
import net.minecraft.block.material.Material;
import themike.core.block.SlabBase;

public class SlabMaterials extends SlabBase {

	public SlabMaterials(int par1, boolean single, Material mat, String prefix,
			String name) {
		super(par1, false, Material.rock, "jamesworld", "materials");
		this.setCreativeTab(JamesRegistry.tab);
	}

}
