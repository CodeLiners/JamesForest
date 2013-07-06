package mods.jameslfc19.forest;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import mods.jameslfc19.forest.event.JamesWorldHandler;
import mods.jameslfc19.forest.recipes.EE3Recipes;
import mods.jameslfc19.forest.recipes.IC2Recipes;
import mods.jameslfc19.forest.recipes.JamesRecipes;
import mods.jameslfc19.forest.recipes.ThermalExpansionRecipes;
import mods.jameslfc19.forest.registry.JamesRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "JamesWorld", name = "James' World", version = "0.1.0", dependencies = "after:ThermalExpansion;after:IC2;after:EE3")
public class JamesWorld {
	
	@Instance("JamesWorld")
	public static JamesWorld instance;
		
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		WorldConfiguration.init(config);
		MinecraftForge.EVENT_BUS.register(new JamesWorldHandler());
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		JamesRegistry.CreativeTabInit();
		JamesRegistry.BiomeInit();
		JamesRegistry.WorldGenInit();
	}
	
	@EventHandler
	public void postLoad(FMLPostInitializationEvent event){
		JamesRecipes.init();
		ThermalExpansionRecipes.init();
		IC2Recipes.init();
		EE3Recipes.init();
	}
	
}
