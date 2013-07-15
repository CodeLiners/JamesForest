package mods.jameslfc19.forest.world.trees;

import java.util.Random;

import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.registry.JamesRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenAcadiaTrees implements IWorldGenerator {
	
	/**Set the Tree properties here.**/
	public int treeLogId = JamesBlock.thickwood.blockID;
	public int leavesId = JamesBlock.leaves.blockID;
	public int treeBaseHeight = 6;
	public int treeVarianceHeight = 3;
	public Random random = new Random();
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		/**Set the Tree spawn properties here.**/
		int treeDensity = 8; //Amount of tries to plant tree per chunk
		int chunkYMin = 63; //Y = 60
		int chunkYMax = 100; //Y = 100
		
		
		for (int b=1; b<=treeDensity; b++){
			int chunkX1 = chunkX*16 + random.nextInt(16);
			int chunkZ1 = chunkZ*16 + random.nextInt(16);
			int chunkY;
			for (chunkY=chunkYMin; chunkY<=chunkYMax; chunkY++){
				int blockidnumber = world.getBlockId(chunkX1, chunkY, chunkZ1);
				if (blockidnumber == 0){
					break;
				}
			}
			BiomeGenBase biome = world.getBiomeGenForCoords(chunkX1, chunkZ1);
			boolean isValidBiome = biome == JamesRegistry.SAVANNA;
			int blockBeneath = world.getBlockId(chunkX1, chunkY - 1, chunkZ1);
			Block soil = Block.blocksList[blockBeneath];
			boolean isValidSoil = soil != null && soil.canSustainPlant(world, chunkX1, chunkY - 1, chunkZ1, ForgeDirection.UP, (BlockSapling)Block.sapling) && blockBeneath == 2;	

			if (isValidSoil && isValidBiome && random.nextInt(19) == 1) {
				growTree(chunkX1, chunkY, chunkZ1, world);
			}
		}
	}
	
	public boolean growTree(int chunkX, int chunkY, int chunkZ, World world) {
		System.out.println("New tree at "+chunkX+" | "+chunkY+" | "+chunkZ);
		int treeHeight = treeBaseHeight + random.nextInt(treeVarianceHeight);
    	int blockHeight;
    	for (blockHeight = 0; blockHeight<=treeHeight; blockHeight++){
    			world.setBlock(chunkX, chunkY + blockHeight, chunkZ, treeLogId);
    	}
    	int treeLeavesX = chunkX + 2;
    	int treeLeavesZ = chunkZ + 3;
    	//int treeLeavesY = blockHeight+1;
    	
    	//Top Triangle
    	world.setBlock(chunkX, chunkY + blockHeight, chunkZ, leavesId);
    	world.setBlock(chunkX+1, chunkY + blockHeight, chunkZ, leavesId);
    	world.setBlock(chunkX-1, chunkY + blockHeight, chunkZ, leavesId);
    	world.setBlock(chunkX, chunkY + blockHeight, chunkZ-1, leavesId);
    	world.setBlock(chunkX, chunkY + blockHeight, chunkZ+1, leavesId);
    	
    	world.setBlock(chunkX+2, chunkY + blockHeight, chunkZ, leavesId);
    	world.setBlock(chunkX-2, chunkY + blockHeight, chunkZ, leavesId);
    	world.setBlock(chunkX, chunkY + blockHeight, chunkZ-2, leavesId);
    	world.setBlock(chunkX, chunkY + blockHeight, chunkZ+2, leavesId);
    	
    	world.setBlock(chunkX+1, chunkY + blockHeight, chunkZ-1, leavesId);
    	world.setBlock(chunkX-1, chunkY + blockHeight, chunkZ-1, leavesId);
    	world.setBlock(chunkX-1, chunkY + blockHeight, chunkZ+1, leavesId);
    	world.setBlock(chunkX+1, chunkY + blockHeight, chunkZ+1, leavesId);
    	
    	world.setBlock(chunkX+2, chunkY + blockHeight, chunkZ+1, leavesId);
    	world.setBlock(chunkX+2, chunkY + blockHeight, chunkZ-1, leavesId);
    	world.setBlock(chunkX-2, chunkY + blockHeight, chunkZ+1, leavesId);
    	world.setBlock(chunkX-2, chunkY + blockHeight, chunkZ-1, leavesId);
    	
    	world.setBlock(chunkX+1, chunkY + blockHeight, chunkZ+2, leavesId);
    	world.setBlock(chunkX-1, chunkY + blockHeight, chunkZ+2, leavesId);
    	world.setBlock(chunkX+1, chunkY + blockHeight, chunkZ-2, leavesId);
    	world.setBlock(chunkX-1, chunkY + blockHeight, chunkZ-2, leavesId);
    	
    	//Random Corners
    	for (int a=1; a<=4; a++){
    		int randomSelect = random.nextInt(2);
    		switch (a) {
    		case 1: 
    			if (randomSelect == 1){
    			world.setBlock(chunkX+1, chunkY + blockHeight-1, chunkZ+1, leavesId);
    			}
    		case 2: 
    			if (randomSelect == 1){
    			world.setBlock(chunkX+1, chunkY + blockHeight-1, chunkZ-1, leavesId);
    			}
    		case 3: 
    			if (randomSelect == 1){
    			world.setBlock(chunkX-1, chunkY + blockHeight-1, chunkZ-1, leavesId);
    			}
    		case 4: 
    			if (randomSelect == 1){
    			world.setBlock(chunkX-1, chunkY + blockHeight-1, chunkZ+1, leavesId);
    			}
    		}
    	}
    	
    	return true;
	}
	
}