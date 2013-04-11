package mods.jameslfc19.forest.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;

import mods.jameslfc19.forest.JamesForest;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGenOre implements IWorldGenerator{
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {	
<<<<<<< HEAD
		if(world.provider.dimensionId == 0){
			generateSurfaceMarble(world, random, chunkX, chunkZ);
=======
		if(world.provider.dimensionId != 1 && world.provider.dimensionId != -1){
			generateSurface(world, random, chunkX, chunkZ);
>>>>>>> 143b8d52d1bdd3f212620371fceca1f4ecce520f
		}
	}
			private void generateSurfaceMarble(World world, Random rand, int chunkX, int chunkZ) {
		        for(int a=0; a<4; a++){
		        	int XCoord = chunkX + rand.nextInt(16);
		        	int YCoord = rand.nextInt(40);
		        	int ZCoord = chunkZ + rand.nextInt(16);
		        	
		        	(new WorldGenMinable(JamesForest.stoneGranite.blockID, 20)).generate(world, rand, XCoord, YCoord, ZCoord);
		        	//System.out.println("New Granite at "+ XCoord+" "+YCoord+" "+ZCoord);
		        }
			}
			
			
			
}
