package mods.jameslfc19.forest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class FoodWolfMeat extends ItemFood {

	public FoodWolfMeat(int par1) {
		super(par1, 4, 2.0F, true);
		this.setUnlocalizedName("wolfMeat");
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
    	this.itemIcon = register.registerIcon("jamesworld:wolfMeat");
    }

}
