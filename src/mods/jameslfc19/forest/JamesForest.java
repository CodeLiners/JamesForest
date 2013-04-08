package mods.jameslfc19.forest;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import mods.jameslfc19.forest.biomes.BiomeGenDenseForest;
import mods.jameslfc19.forest.handler.SoundHandler;
import mods.jameslfc19.forest.world.WorldGenMysticalDungeon;
import mods.jameslfc19.forest.world.WorldGenOre;
import mods.jameslfc19.forest.world.WorldGenShrine;
import mods.jameslfc19.forest.world.WorldGenThickwood;
import mods.jameslfc19.forest.world.WorldGenRareOak;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "JamesForest", name = "James' Forest", version = "0.0.1")
public class JamesForest {
	
	@Instance("JamesForest")
	public static JamesForest instance;
	
	public static Block thickwood;
	public static Block leaves;
	public static Block stoneGranite;
	public static Block brickGranite;
	public static Block superStone;
	
	public static CreativeTabs tab;
		
	@PreInit
	public void preLoad(FMLPreInitializationEvent event) {
		
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
		LanguageRegistry.instance().loadLocalization("/mods/jameslfc19/forest/lang/en_US.xml", "en_US", true);
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		ForestConfiguration.init(config);
				
	}

	@Init
	public void load(FMLInitializationEvent event) {
		
		tab = new ForestTab();
		
		GameRegistry.registerBlock(thickwood, "Thickwood Log");
		GameRegistry.registerBlock(leaves, "Thickwood Leaves");
		GameRegistry.registerBlock(stoneGranite, "Granite");
		GameRegistry.registerBlock(brickGranite, "Granite Bricks");
		GameRegistry.registerBlock(superStone, "Super Stone[Dungeon Block]");
		
		thickwood.setCreativeTab(tab);
		leaves.setCreativeTab(tab);
		stoneGranite.setCreativeTab(tab);
		brickGranite.setCreativeTab(tab);
		superStone.setCreativeTab(tab);
				
		GameRegistry.addBiome(new BiomeGenDenseForest(70));
		GameRegistry.registerWorldGenerator(new WorldGenOre()); 
		GameRegistry.registerWorldGenerator(new WorldGenThickwood()); 
		GameRegistry.registerWorldGenerator(new WorldGenRareOak()); 
		GameRegistry.registerWorldGenerator(new WorldGenShrine()); 
		GameRegistry.registerWorldGenerator(new WorldGenMysticalDungeon()); 

						
	}
	
}
