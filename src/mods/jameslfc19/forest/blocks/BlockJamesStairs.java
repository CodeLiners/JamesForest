package mods.jameslfc19.forest.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockJamesStairs extends BlockStairs {

	public BlockJamesStairs(int par1, Block par2Block, int par3, String StairName) {
		super(par1, par2Block, par3);
		this.setUnlocalizedName("stairs"+StairName);
	}

}
