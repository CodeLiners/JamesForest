package mods.jameslfc19.practise.world.gen;
/**package mods.jameslfc19.practise;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenCoolTree implements IWorldGenerator{

	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	    	
	    	System.out.println("Biome is StoneHenge");
	    	
		//Variables
		int maxTreeVarianceHeight = 2;
		int baseTreeHeight = 4;
		int treeLog = 5;
		double spawnRateRangeMin = 2.0; //40
		double spawnRateRangeMax = 5.0; //100
		double chunkYMin = 3.0; //Y = 60
		double chunkYMax = 5.0; //Y = 100
		final int height = random.nextInt(maxTreeVarianceHeight + 1) + baseTreeHeight;
		

		double spawnRateDouble = spawnRateRangeMin + (spawnRateRangeMax - spawnRateRangeMin) * random.nextDouble();
		spawnRateDouble = spawnRateDouble*20;
		
		int spawnRate = (int)spawnRateDouble; 
		
		for (int i=0; i<=spawnRate; i++){
			double chunkYdouble = chunkYMin + (chunkYMax - chunkYMin) * random.nextDouble();
			chunkYdouble = chunkYdouble*20;
			int chunkY = (int)chunkYdouble;
		
			int chunkX1 = chunkX << 4;
			int chunkZ1 = chunkZ << 4;
			int i1 = world.getBlockId(chunkX1, chunkY - 1, chunkZ1);
			Block soil = Block.blocksList[i1];
			boolean isValidSoil = soil != null && soil.canSustainPlant(world, chunkX1, chunkY - 1, chunkZ1, ForgeDirection.UP, (BlockSapling)Block.sapling) && i1 == 2;	
			
			if (isValidSoil){
				System.out.println("New tree at "+chunkX1+" | "+chunkY+" | "+chunkZ1);
				    	int blockHeight;
				    	for (blockHeight = 0; blockHeight<height; blockHeight++){
				    			world.setBlock(chunkX, chunkY + blockHeight, chunkZ1, treeLog);
				    	}
				    	int treeLeavesX = chunkX + 2;
				    	int treeLeavesZ = chunkZ1 + 3;
				    	int treeLeavesY = blockHeight+1;
				    	
				    	//Top Triangle
				    	world.setBlock(chunkX, chunkY + blockHeight, chunkZ1, 18);
				    	world.setBlock(chunkX+1, chunkY + blockHeight, chunkZ1, 18);
				    	world.setBlock(chunkX-1, chunkY + blockHeight, chunkZ1, 18);
				    	world.setBlock(chunkX, chunkY + blockHeight, chunkZ1-1, 18);
				    	world.setBlock(chunkX, chunkY + blockHeight, chunkZ1+1, 18);
				    	
				    	//Second Triangle
				    	world.setBlock(chunkX+1, chunkY + blockHeight-1, chunkZ1, 18);
				    	world.setBlock(chunkX-1, chunkY + blockHeight-1, chunkZ1, 18);
				    	world.setBlock(chunkX, chunkY + blockHeight-1, chunkZ1-1, 18);
				    	world.setBlock(chunkX, chunkY + blockHeight-1, chunkZ1+1, 18);
				    	for (int a=1; a<=4; a++){
				    		int randomSelect = random.nextInt(2);
				    		switch (a) {
				    		case 1: 
				    			if (randomSelect == 1){
				    			world.setBlock(chunkX+1, chunkY + blockHeight-1, chunkZ1+1, 18);
				    			}
				    		case 2: 
				    			if (randomSelect == 1){
				    			world.setBlock(chunkX+1, chunkY + blockHeight-1, chunkZ1-1, 18);
				    			}
				    		case 3: 
				    			if (randomSelect == 1){
				    			world.setBlock(chunkX-1, chunkY + blockHeight-1, chunkZ1-1, 18);
				    			}
				    		case 4: 
				    			if (randomSelect == 1){
				    			world.setBlock(chunkX-1, chunkY + blockHeight-1, chunkZ1+1, 18);
				    			}
				    		}
				    	}
				    	for (int zCoord = 1; zCoord<=5; zCoord++){
				    		for (int xCoord = 0; xCoord<=4; xCoord++){
				    			if (world.getBlockId(treeLeavesX -xCoord, chunkY + blockHeight-2, treeLeavesZ-zCoord) != treeLog){
				    			world.setBlock(treeLeavesX -xCoord, chunkY + blockHeight-2, treeLeavesZ-zCoord, 18);
				    			}
				    		} for (int xCoord = 0; xCoord<=4; xCoord++){
				    			if (world.getBlockId(treeLeavesX -xCoord, chunkY + blockHeight-3, treeLeavesZ-zCoord) != treeLog){
				    			world.setBlock(treeLeavesX -xCoord, chunkY + blockHeight-3, treeLeavesZ-zCoord, 18);
				    			}
				    		}
				    	}
				    	
				    }

			}
	
	
		}
			
	}

**/
