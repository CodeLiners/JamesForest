package mods.jameslfc19.forest;

import net.minecraftforge.common.Configuration;
import mods.jameslfc19.forest.recipes.IC2Recipes;
import mods.jameslfc19.forest.recipes.JamesRecipes;
import mods.jameslfc19.forest.recipes.ThermalExpansionRecipes;
import mods.jameslfc19.forest.registry.JamesRegistry;
import cpw.mods.fml.common.Mod;
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
@Mod(modid = "JamesForest", name = "James' Forest", version = "0.0.1", dependencies = "after:ThermalExpansion;after:IC2")
public class JamesForest {
	
	@Instance("JamesForest")
	public static JamesForest instance;
		
	@PreInit
	public void preLoad(FMLPreInitializationEvent event) {
		LanguageRegistry.instance().loadLocalization("/mods/jamesforest/lang/en_US.xml", "en_US", true);
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		ForestConfiguration.init(config);
	}

	@Init
	public void load(FMLInitializationEvent event) {
		JamesRegistry.BlockInit();
		JamesRegistry.ItemInit();
		JamesRegistry.CreativeTabInit();
		JamesRegistry.BiomeInit();
		JamesRegistry.WorldGenInit();
	}
	
	@PostInit
	public void postLoad(FMLPostInitializationEvent event){
		JamesRecipes.init();
		ThermalExpansionRecipes.init();
		IC2Recipes.init();
		//MinecraftForge.EVENT_BUS.register(new SoundHandler());
	}
	
}
