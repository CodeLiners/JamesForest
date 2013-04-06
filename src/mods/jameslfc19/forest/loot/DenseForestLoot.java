package mods.jameslfc19.forest.loot;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class DenseForestLoot {
	
	public int itemNumber = 0; //Number of Items that are available.
	
	public ItemStack generateLoot(Random random, int Item){
		int itemID = getItemID(random, Item);
		int itemChance = getItemChance(itemID);
		int itemMaxStack = getItemMaxStack(itemID);
		int itemStack = random.nextInt(itemMaxStack);
		int denominator = 100;
		int spawnDecision = random.nextInt(denominator);
		Block item = Block.blocksList[itemID];
		
		if (spawnDecision <= itemChance) {
			return new ItemStack(item, itemStack);
		}
		return null;
		
	}
	
	public int getItemID(Random random, int Item){
		int[] item = new int[itemNumber];
			
			//Register Items For DenseForest Loot.
			item[0] = Block.blockDiamond.blockID;
			item[1] = Block.blockGold.blockID;
			
		return item[Item];
	}
	
	public int getItemChance(int itemID){
		int[] itemChance = new int[itemID];
		
			//Register Item Chance Of Spawning. (Out of 100.)
			itemChance[Block.blockDiamond.blockID] = 10; 
			itemChance[Block.blockGold.blockID] = 10; 
			
			return itemChance[itemID];
	}
	
	public int getItemMaxStack(int itemID){
		int[] itemMaxStack = new int[itemID];
		
			//Register Item Chance Of Spawning. (Out of 100.)
			itemMaxStack[Block.blockDiamond.blockID] = 5; 
			itemMaxStack[Block.blockGold.blockID] = 5;
			
			return itemMaxStack[itemID];
	}

}
