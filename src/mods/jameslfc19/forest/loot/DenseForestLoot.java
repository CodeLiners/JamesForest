package mods.jameslfc19.forest.loot;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class DenseForestLoot {
	
	public int numberOfItems = 1; //Number of Items that are available.
	public int itemNumber = numberOfItems++;
	
	public ItemStack generateLoot(Random random, int Item){
		int itemID = getItemID(random, Item);
		int itemChance = getItemChance(Item);
		int itemMaxStack = getItemMaxStack(Item);
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
		int[] itemChance = new int[itemNumber];
		
			//Register Item Chance Of Spawning. (Out of 100.)
			itemChance[0] = 10; 
			itemChance[1] = 100; 
			
			return itemChance[itemID];
	}
	
	public int getItemMaxStack(int itemID){
		int[] itemMaxStack = new int[itemNumber];
		
			//Register Item Chance Of Spawning. (Out of 100.)
			itemMaxStack[0] = 5; 
			itemMaxStack[1] = 5;
			
			return itemMaxStack[itemID];
	}

}
