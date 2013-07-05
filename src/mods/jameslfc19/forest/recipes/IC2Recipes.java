package mods.jameslfc19.forest.recipes;

import cpw.mods.fml.common.Loader;
// import ic2.api.recipe.Recipes;
import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.registry.JamesItem;
import net.minecraft.item.ItemStack;

public class IC2Recipes {
	public static void init() {
		if (Loader.isModLoaded("IC2")){
			// Recipes.macerator.addRecipe(new ItemStack(JamesBlock.stoneGranite), new ItemStack(JamesItem.dustGranite, 2));
			System.out.println("[JamesForest] IC2 Recipes Activated");
		}
	}
}
