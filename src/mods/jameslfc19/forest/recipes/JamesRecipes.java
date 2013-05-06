package mods.jameslfc19.forest.recipes;

import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.registry.JamesItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class JamesRecipes {

	public static void init(){
		GameRegistry.addSmelting(JamesBlock.thickwood.blockID, new ItemStack(Item.coal, 1, 1), 1.0F);
		GameRegistry.addRecipe(new ItemStack(Block.planks, 4, 1), new Object[]{"X", 'X', JamesBlock.thickwood});
		GameRegistry.addRecipe(new ItemStack(JamesBlock.brickGranite, 4), new Object[]{"XX ", "XX ", 'X', JamesBlock.stoneGranite});
		GameRegistry.addRecipe(new ItemStack(JamesBlock.brickLimestone, 4), new Object[]{"XX ", "XX ", 'X', JamesBlock.brickLimestone});
		GameRegistry.addRecipe(new ItemStack(JamesBlock.stairsGranite, 4), new Object[]{"X  ", "XX ","XXX", 'X', JamesBlock.brickGranite});
		GameRegistry.addRecipe(new ItemStack(JamesBlock.stairsLimestone, 4), new Object[]{"X  ", "XX ","XXX", 'X', JamesBlock.stoneLimestone});
		GameRegistry.addRecipe(new ItemStack(Item.netherQuartz, 4), new Object[]{"GNG", "NGN", "GNG", 'G', JamesBlock.stoneGranite, 'N', Block.netherrack});
		GameRegistry.addRecipe(new ItemStack(Item.netherQuartz, 4), new Object[]{"GNG", "NGN", "GNG", 'G', JamesItem.dustGranite, 'N', Block.netherrack});
	}
}
