package mods.jameslfc19.forest.blocks;

import java.util.List;
import java.util.Random;

import mods.jameslfc19.forest.JamesForest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.oredict.OreDictionary;

public class BlockThickwood extends BlockLog {
	
	public Icon top = null;
	public Icon side = null;

	public BlockThickwood(int par1) {
		super(par1);
		this.setUnlocalizedName("logThickwood");
		this.setHardness(2.0F);
		this.setStepSound(soundWoodFootstep);
	}

	@Override
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		if(par1 < 2) {
			return top;
		}
		return side;
	}

	@Override
    public void registerIcons(IconRegister register) {
        this.top = register.registerIcon("jamesforest:denseForestTreeTop");
        this.side = register.registerIcon("jamesforest:denseForestTreeSide");
    }
	
	@Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
	}
	
	@Override
    public int idDropped(int par1, Random random, int par3) {
        return JamesForest.thickwood.blockID;
    }

}