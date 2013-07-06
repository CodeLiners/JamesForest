package mods.jameslfc19.forest.item;

import java.util.ArrayList;
import java.util.Arrays;

import themike.core.item.ItemBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class ItemDust extends ItemBase {
	
	private Icon dust;
	private Icon pulverized;
		
	public ItemDust(int par1) {
        super(par1, "jamesworld", "dust", new ArrayList<String>(Arrays.asList("pulverizedGranite", "dustGranite")));
    }
	
    @Override
    public Icon getIcon(int meta) {
    	if(meta == 0)
    		return this.pulverized;
    	else
    		return this.dust;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
    	this.pulverized = register.registerIcon("jamesworld:pulverizedGranite");
    	this.dust = register.registerIcon("jamesworld:dustGranite");
    }
	
}
