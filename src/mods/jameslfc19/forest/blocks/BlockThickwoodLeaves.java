package mods.jameslfc19.forest.blocks;

import java.util.List;
import java.util.Random;

import mods.jameslfc19.forest.JamesForest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;


public class BlockThickwoodLeaves extends BlockLeaves {
	
	public Icon normal = null;
	public Icon rare = null;
	
	public BlockThickwoodLeaves(int par1) {
		super(par1);
		this.setCreativeTab(JamesForest.tab);
		this.setUnlocalizedName("leavesThickwood");
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setStepSound(soundGrassFootstep);
	}
	
	@Override
	public boolean isOpaqueCube()
    {
        return !this.graphicsLevel;
    }
	
	@Override
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		if(par2 == 0) {
			return normal;
		} else {
			return rare;
		}
	}

	@Override
    public void registerIcons(IconRegister register) {
		if (this.graphicsLevel == true){
			this.normal = register.registerIcon("jamesforest:denseForestNormalLeavesOpaque");
	        this.rare = register.registerIcon("jamesforest:denseForestRareLeavesOpaque");
		} else {
			this.normal = register.registerIcon("jamesforest:denseForestNormalLeaves");
	        this.rare = register.registerIcon("jamesforest:denseForestRareLeaves");
		}
        
    }
	
	@Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
	}
	
	@Override
    public int damageDropped(int par1) {
        return 0;
    }
	
	@Override
    public int idDropped(int par1, Random random, int par3) {
        return Block.sapling.blockID;
    }

}
