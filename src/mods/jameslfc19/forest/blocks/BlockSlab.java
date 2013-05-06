package mods.jameslfc19.forest.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.utils.MultiBlockUtils;
import net.minecraft.block.BlockStep;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockSlab extends BlockStep {

	public int metaData;
	public Icon[] icon;
	public String[] iconName;
	public String Name;

	
	public BlockSlab(int par1) {
		super(par1, false);
		this.setResistance(15.0F);
		this.setHardness(3.0F);
	}
	
	public String getName(){
		int MetaLength = MultiBlockUtils.getArray().length;
		for (int a=0; a <= MetaLength; a++){
			return MultiBlockUtils.getArray()[a];
		}
		return null;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		int MetaLength = MultiBlockUtils.getArray().length;
		icon = new Icon[MetaLength];
		iconName = new String[MetaLength];
		for (int a=0; a < MetaLength; a++){
			icon[a] = reg.registerIcon("jamesforest:"+MultiBlockUtils.getArray()[a]);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		if (par2 > MultiBlockUtils.getArray().length) par2 = par2 - 8;
		if (par2 < MultiBlockUtils.getArray().length){
				iconName[par2] = MultiBlockUtils.getArray()[par2];
				Name = iconName[par2];
				return icon[par2];
		}
		return null;
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName() {
		return "slab.slab"+Name;
	}
	
	@Override
    protected ItemStack createStackedBlock(int par1) {
        return new ItemStack(JamesBlock.slabs.blockID, 2, par1 & 7);
    }

	@Override
	public String getFullSlabName(int i) {
		return MultiBlockUtils.getArray()[i];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) //Adds the metadata blocks to the creative inventory
	{
		int MetaLength = MultiBlockUtils.getArray().length;
	         for (int var4 = 0; var4 < MetaLength; ++var4)
	         {
	                 par3List.add(new ItemStack(par1, 1, var4));
	         }
	}

}
