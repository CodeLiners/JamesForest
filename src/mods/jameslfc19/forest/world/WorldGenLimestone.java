package mods.jameslfc19.forest.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;

import mods.jameslfc19.forest.JamesForest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldGenLimestone implements IWorldGenerator
{
	
    /** The block ID for clay. */
    private int clayBlockId;

    /** The number of blocks to generate. */
    private int numberOfBlocks;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		int z = chunkZ + random.nextInt(16);
		int x = chunkX + random.nextInt(16);
		int y;
    	for (y=46; y<=64; y++){
			int blockidnumber = world.getBlockId(x, y, z);
			if (blockidnumber == Block.waterStill.blockID){
				break;
			}
		}
    	y++;
    	this.numberOfBlocks = 20 + random.nextInt(5);	
    	generate(world, random, x,y,z);
	}

    public WorldGenLimestone()
    {
        this.clayBlockId = JamesForest.stoneLimestone.blockID;
    }
    
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        if (par1World.getBlockMaterial(par3, par4, par5) != Material.water)
        {
            return false;
        }
        else
        {
            int l = par2Random.nextInt(this.numberOfBlocks - 2) + 2;
            byte b0 = 1;

            for (int i1 = par3 - l; i1 <= par3 + l; ++i1)
            {
                for (int j1 = par5 - l; j1 <= par5 + l; ++j1)
                {
                    int k1 = i1 - par3;
                    int l1 = j1 - par5;

                    if (k1 * k1 + l1 * l1 <= l * l)
                    {
                        for (int i2 = par4 - b0; i2 <= par4 + b0; ++i2)
                        {
                            int j2 = par1World.getBlockId(i1, i2, j1);

                            if (j2 == Block.dirt.blockID || j2 == JamesForest.stoneLimestone.blockID)
                            {
                                par1World.setBlock(i1, i2, j1, JamesForest.stoneLimestone.blockID);
                                //System.out.println("New Limestone at "+ i1+" "+i2+" "+j1);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
