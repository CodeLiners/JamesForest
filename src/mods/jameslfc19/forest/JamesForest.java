package mods.jameslfc19.forest;

import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;
import mods.jameslfc19.forest.biomes.BiomeGenDenseForest;
import mods.jameslfc19.forest.world.WorldGenThickwood;
import mods.jameslfc19.forest.world.WorldGenRareOak;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "JamesForest", name = "James' Forest", version = "0.0.1")
public class JamesForest {

	@Instance("JamesForest")
	public static JamesForest instance;
	
	public static Block thickwood;
	public static Block leaves;
		
	@PreInit
	public void preLoad(FMLPreInitializationEvent event) {
		
		LanguageRegistry.instance().loadLocalization("/mods/jameslfc19/forest/lang/en_US.xml", "en_US", true);
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		ForestConfiguration.init(config);
				
	}

	@Init
	public void load(FMLInitializationEvent event) {
		
		GameRegistry.registerBlock(thickwood, "Thickwood Log");
		GameRegistry.registerBlock(leaves, "Thickwood Leaves");
		
		GameRegistry.addBiome(new BiomeGenDenseForest(70));
		GameRegistry.registerWorldGenerator(new WorldGenThickwood()); 
		GameRegistry.registerWorldGenerator(new WorldGenRareOak()); 
		
	}
	
}
