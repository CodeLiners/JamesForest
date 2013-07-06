package mods.jameslfc19.forest.recipes;

// import com.pahimar.ee3.core.helper.RecipeHelper;
// import com.pahimar.ee3.recipe.RecipesTransmutationStone;

import cpw.mods.fml.common.Loader;

import mods.jameslfc19.forest.registry.JamesBlock;
import net.minecraft.item.ItemStack;

public class EE3Recipes {

	public static void init(){
		if (Loader.isModLoaded("EE3")){
		// for (ItemStack stone : RecipesTransmutationStone.transmutationStones) {
			// initJamesTransmutation(stone);
        // }
		System.out.println("[JamesForest] EE3 Recipes Activated");
		}
	}
	
	public static void initJamesTransmutation(ItemStack transmutationStone){
		if (Loader.isModLoaded("EE3")){
			// RecipeHelper.addRecipe(JamesBlock.brickLimestone, transmutationStone, JamesBlock.brickGranite, JamesBlock.brickGranite, JamesBlock.brickGranite, JamesBlock.brickGranite);
			// RecipeHelper.addRecipe(new ItemStack(JamesBlock.brickGranite, 4), transmutationStone, JamesBlock.brickLimestone);
		}
	}
}
