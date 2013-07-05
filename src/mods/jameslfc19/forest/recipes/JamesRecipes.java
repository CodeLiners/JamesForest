package mods.jameslfc19.forest.recipes;

import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.registry.JamesItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class JamesRecipes {

	public static void init(){
		GameRegistry.addSmelting(JamesBlock.thickwood.blockID, new ItemStack(Item.coal, 1, 1), 1.0F);
		GameRegistry.addRecipe(new ItemStack(Block.planks, 4, 1), new Object[]{"X", 'X', JamesBlock.thickwood});
		GameRegistry.addRecipe(new ItemStack(JamesBlock.materials, 4, 2), new Object[]{"XX ", "XX ", 'X', new ItemStack(JamesBlock.materials, 4, 0)});
		GameRegistry.addRecipe(new ItemStack(JamesBlock.materials, 4, 3), new Object[]{"XX ", "XX ", 'X', new ItemStack(JamesBlock.materials, 4, 2)});
		GameRegistry.addRecipe(new ItemStack(JamesBlock.materials, 4, 4), new Object[]{"XX ", "XX ", 'X', new ItemStack(JamesBlock.materials, 4, 1)});
		
		if (Loader.isModLoaded("IC2")){
		GameRegistry.addRecipe(new ItemStack(Item.netherQuartz, 4), new Object[]{"GNG", "NGN", "GNG", 'G', new ItemStack(JamesItem.dustGranite, 4, 1), 'N', Block.netherrack});
		}
		if (Loader.isModLoaded("ThermalExpansion")){
			GameRegistry.addRecipe(new ItemStack(Item.netherQuartz, 4), new Object[]{"GNG", "NGN", "GNG", 'G', new ItemStack(JamesItem.dustGranite, 4, 0), 'N', Block.netherrack});
		}
	}
}
