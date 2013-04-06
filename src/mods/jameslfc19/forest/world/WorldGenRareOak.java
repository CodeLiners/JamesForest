package mods.jameslfc19.forest.world;

import java.util.Random;

import mods.jameslfc19.forest.JamesForest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenRareOak implements IWorldGenerator{
	
	/**Set the Tree properties here.**/
	public static final WeightedRandomChestContent[] rareOakChestContents = new WeightedRandomChestContent[] {new WeightedRandomChestContent(Item.enderPearl.itemID, 0, 1, 1, 10), new WeightedRandomChestContent(Item.diamond.itemID, 0, 1, 3, 3), new WeightedRandomChestContent(Item.ingotIron.itemID, 0, 1, 5, 10), new WeightedRandomChestContent(Item.ingotGold.itemID, 0, 1, 3, 5), new WeightedRandomChestContent(Item.redstone.itemID, 0, 4, 9, 5), new WeightedRandomChestContent(Item.bread.itemID, 0, 1, 3, 15), new WeightedRandomChestContent(Item.appleRed.itemID, 0, 1, 3, 15), new WeightedRandomChestContent(Item.pickaxeSteel.itemID, 0, 1, 1, 5), new WeightedRandomChestContent(Item.swordSteel.itemID, 0, 1, 1, 5), new WeightedRandomChestContent(Item.plateSteel.itemID, 0, 1, 1, 5), new WeightedRandomChestContent(Item.helmetSteel.itemID, 0, 1, 1, 5), new WeightedRandomChestContent(Item.legsSteel.itemID, 0, 1, 1, 5), new WeightedRandomChestContent(Item.bootsSteel.itemID, 0, 1, 1, 5), new WeightedRandomChestContent(Item.appleGold.itemID, 0, 1, 1, 1)};
	public Random random = new Random();
	public int treeLogId = JamesForest.thickwood.blockID;
	public int leavesId = JamesForest.leaves.blockID;
	public int treeBaseHeight = 9;
	public int treeVarianceHeight = 3;
	public int rarityNumerator = 1;
	public int rarityDenominator = 20;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		/**Set the Tree spawn properties here.**/
		int treeDensity = 1; //Amount of tries to plant tree per chunk
		int chunkYMin = 63; //Y = 60
		int chunkYMax = 100; //Y = 100
		
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
		world.setBlockMetadataWithNotify(chunkX, chunkY + blockHeight, chunkZ, 1, 3);
    	world.setBlock(chunkX+1, chunkY + blockHeight, chunkZ, leavesId);
		world.setBlockMetadataWithNotify(chunkX+1, chunkY + blockHeight, chunkZ, 1, 3);
    	world.setBlock(chunkX-1, chunkY + blockHeight, chunkZ, leavesId);
		world.setBlockMetadataWithNotify(chunkX-1, chunkY + blockHeight, chunkZ, 1, 3);
    	world.setBlock(chunkX, chunkY + blockHeight, chunkZ-1, leavesId);
		world.setBlockMetadataWithNotify(chunkX, chunkY + blockHeight, chunkZ-1, 1, 3);
    	world.setBlock(chunkX, chunkY + blockHeight, chunkZ+1, leavesId);
		world.setBlockMetadataWithNotify(chunkX, chunkY + blockHeight, chunkZ+1, 1, 3);
    	
    	//Second Triangle
    	world.setBlock(chunkX+1, chunkY + blockHeight-1, chunkZ, leavesId);
		world.setBlockMetadataWithNotify(chunkX+1, chunkY + blockHeight-1, chunkZ, 1, 3);
    	world.setBlock(chunkX-1, chunkY + blockHeight-1, chunkZ, leavesId);
		world.setBlockMetadataWithNotify(chunkX-1, chunkY + blockHeight-1, chunkZ, 1, 3);
    	world.setBlock(chunkX, chunkY + blockHeight-1, chunkZ-1, leavesId);
		world.setBlockMetadataWithNotify(chunkX, chunkY + blockHeight-1, chunkZ-1, 1, 3);
    	world.setBlock(chunkX, chunkY + blockHeight-1, chunkZ+1, leavesId);
		world.setBlockMetadataWithNotify(chunkX, chunkY + blockHeight-1, chunkZ+1, 1, 3);
    	
    	//Random Corners
    	for (int a=1; a<=4; a++){
    		int randomSelect = random.nextInt(2);
    		switch (a) {
    		case 1: 
    			if (randomSelect == 1){
    			world.setBlock(chunkX+1, chunkY + blockHeight-1, chunkZ+1, leavesId);
    			world.setBlockMetadataWithNotify(chunkX-1, chunkY + blockHeight-1, chunkZ+1, 1, 3);
    			}
    		case 2: 
    			if (randomSelect == 1){
    			world.setBlock(chunkX+1, chunkY + blockHeight-1, chunkZ-1, leavesId);
    			world.setBlockMetadataWithNotify(chunkX-1, chunkY + blockHeight-1, chunkZ+1, 1, 3);
    			}
    		case 3: 
    			if (randomSelect == 1){
    			world.setBlock(chunkX-1, chunkY + blockHeight-1, chunkZ-1, leavesId);
    			world.setBlockMetadataWithNotify(chunkX-1, chunkY + blockHeight-1, chunkZ+1, 1, 3);
    			}
    		case 4: 
    			if (randomSelect == 1){
    			world.setBlock(chunkX-1, chunkY + blockHeight-1, chunkZ+1, leavesId);
    			world.setBlockMetadataWithNotify(chunkX-1, chunkY + blockHeight-1, chunkZ+1, 1, 3);
    			}
    		}
    	}
    	
    	//Bottom Two Layers.
    	for (int z = 1; z<=5; z++){
    		for (int x = 0; x<=4; x++){
    			if (world.getBlockId(treeLeavesX -x, chunkY + blockHeight-2, treeLeavesZ-z) != treeLogId){
    			world.setBlock(treeLeavesX -x, chunkY + blockHeight-2, treeLeavesZ-z, leavesId);
    			world.setBlockMetadataWithNotify(treeLeavesX -x, chunkY + blockHeight-3, treeLeavesZ-z, 1, 3);
    			}
    		} for (int x = 0; x<=4; x++){
    			if (world.getBlockId(treeLeavesX -x, chunkY + blockHeight-3, treeLeavesZ-z) != treeLogId){
    			world.setBlock(treeLeavesX -x, chunkY + blockHeight-3, treeLeavesZ-z, leavesId);
    			world.setBlockMetadataWithNotify(treeLeavesX -x, chunkY + blockHeight-3, treeLeavesZ-z, 1, 3);
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
        if(tile != null)
        {
        tile.setInventorySlotContents(1, new ItemStack(Block.blockDiamond, 1));
        }
        
        
        
	}
	
}