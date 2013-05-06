package mods.jameslfc19.forest.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;

import mods.jameslfc19.forest.registry.JamesBlock;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGenOre implements IWorldGenerator{
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {	
		if(world.provider.dimensionId != 1 && world.provider.dimensionId != -1){
			generateSurfaceGranite(world, random, chunkX, chunkZ);
		}
	}
			private void generateSurfaceGranite(World world, Random rand, int chunkX, int chunkZ) {
		        for(int a=0; a<6; a++){
		        	int XCoord = chunkX*16 + rand.nextInt(16);
		        	int YCoord = rand.nextInt(50);
		        	int ZCoord = chunkZ*16 + rand.nextInt(16);
		        	
		        	(new WorldGenMinable(JamesBlock.stoneGranite.blockID, 60)).generate(world, rand, XCoord, YCoord, ZCoord);
		        	//System.out.println("New Granite at "+ XCoord+" "+YCoord+" "+ZCoord);
		        }
			}
			
			
			
}
