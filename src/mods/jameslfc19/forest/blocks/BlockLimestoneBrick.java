package mods.jameslfc19.forest.blocks;

import java.util.List;
import java.util.Random;

import mods.jameslfc19.forest.JamesForest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockLimestoneBrick extends Block{
	
	public Icon face = null;

	public BlockLimestoneBrick(int par1) {
		super(par1, Material.rock);
		this.setUnlocalizedName("brickLimestone");
		this.setHardness(1.5F);
		this.setStepSound(soundStoneFootstep);
		this.setResistance(10.0F);
	}
	
	@Override
    public void registerIcons(IconRegister register) {
        this.face = register.registerIcon("jamesforest:brickLimestone");
    }
	
	@Override
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return face;
	}
	
	@Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
	}
	
	@Override
    public int idDropped(int par1, Random random, int par3) {
        return JamesForest.brickLimestone.blockID;
    }
	
	@Override
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		return true;
	}


}
