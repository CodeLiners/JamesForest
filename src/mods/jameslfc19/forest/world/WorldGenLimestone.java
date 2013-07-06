package mods.jameslfc19.forest.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;

import mods.jameslfc19.forest.registry.JamesBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldGenLimestone implements IWorldGenerator
{
	
    /** The block ID for clay. */
	public int clayBlockId;

    /** The number of blocks to generate. */
    private int numberOfBlocks;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for(int a=0; a<=2; a++){
		int z = chunkZ*16 + random.nextInt(16);
		int x = chunkX*16 + random.nextInt(16);
		int y;
    	for (y=40; y<=70; y++){
			int blockidnumber = world.getBlockId(x, y, z);
			if (blockidnumber == Block.waterStill.blockID){
				break;
			}
		}
    	this.numberOfBlocks = 6;	
    	if(world.provider.dimensionId != 1 && world.provider.dimensionId != -1){
    		generate(world, random, x,y,z);
		}
		}
	}

    public WorldGenLimestone()
    {
        this.clayBlockId = JamesBlock.materials.blockID;
    }
    
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        if (par1World.getBlockMaterial(par3, par4, par5) != Material.water)
        {
            return false;
        }
        else
        {
        	//System.out.println("New Limestone at "+par3+" "+par4+" "+par5);
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

                            if (j2 == Block.dirt.blockID || j2 == JamesBlock.materials.blockID)
                            {
                                par1World.setBlock(i1, i2, j1, JamesBlock.materials.blockID);
                            	par1World.setBlockMetadataWithNotify(i1, i2, j1, 1, 3);
                                // System.out.println("New Limestone at "+ i1+" "+i2+" "+j1);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
