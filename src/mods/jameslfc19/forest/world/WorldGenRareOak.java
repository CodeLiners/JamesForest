package mods.jameslfc19.forest.world;

import static net.minecraftforge.common.ChestGenHooks.VILLAGE_BLACKSMITH;

import java.util.Random;

import mods.jameslfc19.forest.JamesForest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenRareOak implements IWorldGenerator{
	
	/**Set the Tree properties here.**/
	public static final WeightedRandomChestContent[] rareOakChestContents = new WeightedRandomChestContent[] {new WeightedRandomChestContent(Item.enderPearl.itemID, 0, 1, 1, 10), new WeightedRandomChestContent(Item.diamond.itemID, 0, 1, 3, 3), new WeightedRandomChestContent(Item.ingotIron.itemID, 0, 1, 5, 10), new WeightedRandomChestContent(Item.ingotGold.itemID, 0, 1, 3, 5), new WeightedRandomChestContent(Item.redstone.itemID, 0, 4, 9, 5), new WeightedRandomChestContent(Item.bread.itemID, 0, 1, 3, 15), new WeightedRandomChestContent(Item.appleRed.itemID, 0, 1, 3, 15), new WeightedRandomChestContent(Item.pickaxeIron.itemID, 0, 1, 1, 5), new WeightedRandomChestContent(Item.swordIron.itemID, 0, 1, 1, 5), new WeightedRandomChestContent(Item.plateIron.itemID, 0, 1, 1, 5), new WeightedRandomChestContent(Item.helmetIron.itemID, 0, 1, 1, 5), new WeightedRandomChestContent(Item.legsIron.itemID, 0, 1, 1, 5), new WeightedRandomChestContent(Item.bootsIron.itemID, 0, 1, 1, 5), new WeightedRandomChestContent(Item.appleGold.itemID, 0, 1, 1, 1)};
	public Random random = new Random();
	public int treeLogId = JamesForest.thickwood.blockID;
	public int leavesId = JamesForest.leaves.blockID;
	public int treeBaseHeight = 10;
	public int treeVarianceHeight = 2;
	public int rarityNumerator = 1;
	public int rarityDenominator = 20;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		/**Set the Tree spawn properties here.**/
		int treeDensity = 1; //Amount of tries to plant tree per chunk
		int chunkYMin = 63;
		int chunkYMax = 100;
		
		int rarityDecider = random.nextInt(20);
		
		if (rarityDecider == rarityNumerator){
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
				String biomeName = biome.biomeName;
				boolean isValidBiome = biomeName == "Dense Forest";
				int blockBeneath = world.getBlockId(chunkX1, chunkY - 1, chunkZ1);
				Block soil = Block.blocksList[blockBeneath];
				boolean isValidSoil = soil != null && soil.canSustainPlant(world, chunkX1, chunkY - 1, chunkZ1, ForgeDirection.UP, (BlockSapling)Block.sapling) && blockBeneath == 2;	

				if (isValidSoil && isValidBiome){
						growTree(chunkX1, chunkY, chunkZ1, world);
						generateLoot(chunkX1, chunkY, chunkZ1, world);
						
				}
			}
		}
	}
	
	public boolean growTree(int chunkX, int chunkY, int chunkZ, World world) {
		System.out.println("New rare tree at "+chunkX+" | "+chunkY+" | "+chunkZ);
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
    	
    	//Second Triangle
    	world.setBlock(chunkX+1, chunkY + blockHeight-1, chunkZ, leavesId);
    	world.setBlock(chunkX-1, chunkY + blockHeight-1, chunkZ, leavesId);
    	world.setBlock(chunkX, chunkY + blockHeight-1, chunkZ-1, leavesId);
    	world.setBlock(chunkX, chunkY + blockHeight-1, chunkZ+1, leavesId);
    	
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
    	
    	//Bottom Two Layers.
    	for (int z = 1; z<=5; z++){
    		for (int x = 0; x<=4; x++){
    			if (world.getBlockId(treeLeavesX -x, chunkY + blockHeight-2, treeLeavesZ-z) != treeLogId){
    			world.setBlock(treeLeavesX -x, chunkY + blockHeight-2, treeLeavesZ-z, leavesId);
    			}
    		} for (int x = 0; x<=4; x++){
    			if (world.getBlockId(treeLeavesX -x, chunkY + blockHeight-3, treeLeavesZ-z) != treeLogId){
    			world.setBlock(treeLeavesX -x, chunkY + blockHeight-3, treeLeavesZ-z, leavesId);
    			}
    		}
    	}
    	
    	return true;
	}
	
	public void generateLoot(int x, int y, int z, World world) {
		world.setBlock(x, y-1, z, Block.mobSpawner.blockID);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getBlockTileEntity(x, y-1, z);

        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_98049_a().setMobID("Zombie");
        
        }
        world.setBlock(x, y-2, z, 54);
        TileEntityChest tile = (TileEntityChest)world.getBlockTileEntity(x, y-2, z);
        if(tile != null) {
        	Random rand = new Random();
        	WeightedRandomChestContent.generateChestContents(rand, ChestGenHooks.getItems(ChestGenHooks.VILLAGE_BLACKSMITH, rand), tile, ChestGenHooks.getCount(VILLAGE_BLACKSMITH, rand));
        }
        
        
        
	}
	
}