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
<<<<<<< HEAD:src/mods/jameslfc19/forest/WorldTab.java
		return new ItemStack(JamesBlock.materials, 1, 2);
=======
		return new ItemStack(JamesItem.dustGranite, 1, 0);
>>>>>>> fcc7b27ab2a9402f31c0637b512ed9e3ebd48407:src/mods/jameslfc19/forest/WorldTab.java
	}

}
