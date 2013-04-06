package mods.jameslfc19.forest;


import mods.jameslfc19.forest.biomes.BiomeGenDenseForest;
import mods.jameslfc19.forest.world.WorldGenThickwood;
import mods.jameslfc19.forest.world.WorldGenRareOak;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "JamesForest", name = "James' Forest", version = "0.0.1")
public class JamesForest {

	@Instance("JamesForest")
	public static JamesForest instance;
	
	//World Gen
	public static WorldGenThickwood worldGenDenseForest = new WorldGenThickwood();
	public static WorldGenRareOak worldGenRareOak = new WorldGenRareOak();
	
	//Biomes
	public static BiomeGenDenseForest genDenseForest = new BiomeGenDenseForest(70);

	@Init
	public void load(FMLInitializationEvent evt) {
		GameRegistry.addBiome(genDenseForest);
		GameRegistry.registerWorldGenerator(worldGenDenseForest); 
		GameRegistry.registerWorldGenerator(worldGenRareOak); 
		
	}
	
}
