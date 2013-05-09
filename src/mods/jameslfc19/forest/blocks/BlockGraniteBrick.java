package mods.jameslfc19.forest.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mods.jameslfc19.forest.JamesForest;
import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.utils.MultiBlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGraniteBrick extends Block{
	
	public int metaData;
	public Icon[] icon;
	public String[] name;
	public int metastage;

	public BlockGraniteBrick(int par1) {
		super(par1, Material.rock);
		this.setHardness(1.5F);
		this.setStepSound(soundStoneFootstep);
		this.setResistance(10.0F);
	}
	
	 @Override
	 public Icon getIcon(int side, int metadata) {
		 if (metadata < 0 || metadata >= MultiBlockUtils.getGraniteBrickArray().length) {
			 metadata = 0;
			 }
         //System.out.println("[JAMESFOREST] Texture name "+ this.name[metadata]);
		 return this.icon[metadata];
	    }

	 @Override
	 public int damageDropped(int damage) {
		 return damage;
		 }

	 @SideOnly(Side.CLIENT)
	 @Override
	 public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
	        for (int j = 0; j < MultiBlockUtils.getGraniteBrickArray().length; ++j)
	        {
	            par3List.add(new ItemStack(par1, 1, j));
	        }
	  }

	 @SideOnly(Side.CLIENT)
	 @Override
	 public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.icon = new Icon[MultiBlockUtils.getGraniteBrickArray().length];
	        this.name = new String[MultiBlockUtils.getGraniteBrickArray().length];

	        for (int i = 0; i < this.icon.length; ++i)
	        {
	            this.icon[i] = par1IconRegister.registerIcon("jamesforest:"+MultiBlockUtils.getGraniteBrickArray()[i]);
	            this.name[i] = MultiBlockUtils.getGraniteBrickArray()[i];
	            this.metastage = i;
	            //System.out.println("[JAMESFOREST] Block is at metastage "+ metastage);
	        }
	 }
}
