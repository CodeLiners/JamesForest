package mods.jameslfc19.forest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ForestTab extends CreativeTabs {

	public ForestTab() {
		super("jamesforest");
	}
	
	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(JamesForest.thickwood, 1, 0);
	}

}
