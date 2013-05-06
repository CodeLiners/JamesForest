package mods.jameslfc19.forest.blocks;

import java.util.List;
import java.util.Random;

import mods.jameslfc19.forest.registry.JamesRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;


public class BlockThickwoodLeaves extends BlockLeaves {

	public BlockThickwoodLeaves(int par1) {
		super(par1);
		this.setCreativeTab(JamesRegistry.tab);
		this.setUnlocalizedName("leavesThickwood");
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setStepSound(soundGrassFootstep);
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return this.blockIcon;
	}

	@Override
    public void registerIcons(IconRegister register) {
        this.blockIcon = register.registerIcon("jamesforest:denseForestNormalLeaves");
    }

	@Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
	}
	
	@Override
    public boolean isOpaqueCube() {
		return false;
	}

	@Override
    public int damageDropped(int par1) {
        return 0;
    }
	
	@Override
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		return true;
	}

	@Override
    public int idDropped(int par1, Random random, int par3) {
        return Block.sapling.blockID;
    }

}