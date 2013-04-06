package mods.jameslfc19.practise;


import mods.jameslfc19.practise.biomes.BiomeGenHenge;
import mods.jameslfc19.practise.world.gen.WorldGenCoolTree;
import mods.jameslfc19.practise.world.gen.WorldGenRareOak;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "James' Forest!", name = "James' Forest!", version = "0.0.1")
public class Main {

	@Instance("James' Forest!")
	public static Main instance;
	
	//World Gen
	public static WorldGenCoolTree worldGenDenseForest = new WorldGenCoolTree();
	public static WorldGenRareOak worldGenRareOak = new WorldGenRareOak();
	
	//Biomes
	public static BiomeGenHenge genDenseForest = new BiomeGenDenseForest(70);

	@Init
	public void load(FMLInitializationEvent evt) {
		GameRegistry.addBiome(genHenge);
		GameRegistry.registerWorldGenerator(worldGenDenseForest); 
		GameRegistry.registerWorldGenerator(worldGenRareOak); 
		
	}
	
}
