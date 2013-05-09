package mods.jameslfc19.forest.item;

import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.utils.MultiBlockUtils;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDoubleSlab extends ItemBlock
{
	public ItemDoubleSlab(int par1)
	{
		super(par1);
		this.setMaxDamage(0); //Stops bad things from happening
		this.setHasSubtypes(true); //Tells it that it has metadata versions
	}	
	
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) //Gets the texture
	{
         return JamesBlock.slabsDouble.getBlockTextureFromSide(par1);
	}
	
	public int getMetadata(int par1) //Returns the metadata value
	{
         return par1;
	}
	
	public String getItemNameIS(ItemStack is) //Get's the item incode name from an itemstack
	{
         return MultiBlockUtils.getSlabArray()[is.getItemDamage()]+ " Double Slab";
	}
}