package mods.jameslfc19.forest.recipes;

import thermalexpansion.api.crafting.CraftingManagers;
import thermalexpansion.api.item.ItemRegistry;
import cpw.mods.fml.common.Loader;
import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.registry.JamesItem;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ThermalExpansionRecipes {
	
	public static void init() {
		if (Loader.isModLoaded("ThermalExpansion")){
			CraftingManagers.pulverizerManager.addRecipe(380, new ItemStack(JamesBlock.stoneGranite), new ItemStack(JamesItem.pulverizedGranite, 2), new ItemStack(Block.cobblestone), 50);
			CraftingManagers.sawmillManager.addRecipe(80, new ItemStack(JamesBlock.thickwood), new ItemStack(Block.planks, 4, 1), ItemRegistry.getItem("sawdust", 1), 100);
			System.out.println("[JamesForest] Thermal Expansion Recipes Activated");
		}
	}
}
