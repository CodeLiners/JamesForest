package mods.jameslfc19.forest.blocks;

import java.util.ArrayList;
import java.util.Arrays;

import themike.core.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockCoral extends BlockBase {

	public BlockCoral(int par1) {
		super(par1, Material.coral, "jamesworld", "coral", 
				new ArrayList<String>(Arrays.asList("0", "1", "2", "3", "4", "5")));
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
    public int getRenderType() {
        return 1;
    }


}
