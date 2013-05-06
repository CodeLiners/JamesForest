package mods.jameslfc19.forest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemDust extends Item {
	
	public String name;
	boolean isIC2Dust;
	
	public ItemDust(int par1, String dustName, boolean IC2)
    {
        super(par1);
        name = dustName;
        if(IC2){
        	this.setUnlocalizedName("dust" + name);
        	isIC2Dust = true;
        	} 
        else {
        	this.setUnlocalizedName("pulverized" + name);
        	isIC2Dust = false;
        }
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		if(isIC2Dust){
			this.itemIcon = par1IconRegister.registerIcon("jamesforest:dust" + name );
			} 
		else {
        	this.itemIcon = par1IconRegister.registerIcon("jamesforest:pulverized" + name );
	    	}
	}
}
