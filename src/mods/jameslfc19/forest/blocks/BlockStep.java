package mods.jameslfc19.forest.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.utils.MultiBlockUtils;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockStep extends BlockHalfSlab
{
    
    @SideOnly(Side.CLIENT)
    private Icon theIcon;
	public int metaData;
	public Icon[] icon;
	public String[] iconName;
	public String Name;
	public int slabID;

    public BlockStep(int par1, boolean par2)
    {
        super(par1, par2, Material.rock);
        if (par2){
        	slabID = par1 + 1;
        } else {
        	slabID = par1;
        }
    }

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		if (par2 < MultiBlockUtils.getSlabArray().length){
				iconName[par2] = MultiBlockUtils.getSlabArray()[par2];
				Name = iconName[par2];
				return icon[par2];
		}
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		int MetaLength = MultiBlockUtils.getSlabArray().length;
		icon = new Icon[MetaLength];
		iconName = new String[MetaLength];
		for (int a=0; a < MetaLength; a++){
			icon[a] = reg.registerIcon("jamesforest:"+MultiBlockUtils.getSlabArray()[a]);
		}
	}

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return JamesBlock.slabsSingle.blockID;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(JamesBlock.slabsSingle.blockID, 2, par1 & 7);
    }

	@Override
	public String getFullSlabName(int i) {
		return MultiBlockUtils.getSlabArray()[i];
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) //Adds the metadata blocks to the creative inventory
	{
		int MetaLength = MultiBlockUtils.getSlabArray().length;
	         for (int var4 = 0; var4 < MetaLength; ++var4)
	         {
	                 par3List.add(new ItemStack(par1, 1, var4));
	         }
	}
}
