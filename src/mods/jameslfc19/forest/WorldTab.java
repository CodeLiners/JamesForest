package mods.jameslfc19.forest;

import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.registry.JamesItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class WorldTab extends CreativeTabs {

	public WorldTab() {
		super("jamesforest");
	}
	
	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(JamesBlock.materials, 1, 2);
	}

}
