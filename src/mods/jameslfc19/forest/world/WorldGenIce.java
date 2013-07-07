package mods.jameslfc19.forest.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;

import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.registry.JamesRegistry;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGenIce implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {	
		int chunkX1 = chunkX * 16 + random.nextInt(16);
		int chunkZ1 = chunkZ * 16 + random.nextInt(16);
		
		if(world.provider.dimensionId != 1 && world.provider.dimensionId != -1 && world.getBiomeGenForCoords(chunkX1, chunkZ1) == JamesRegistry.ICY_MOUNTAIN) {
			generateIce(world, random, chunkX, chunkZ);
		}
	}
	
	private void generateIce(World world, Random rand, int chunkX, int chunkZ) {
		for(int a=0; a< 6; a++) {
			int XCoord = chunkX * 16 + rand.nextInt(16);
			int YCoord = rand.nextInt(200);
			int ZCoord = chunkZ * 16 + rand.nextInt(16);
		        	
			(new WorldGenMinable(Block.ice.blockID, 0, 60, Block.stone.blockID)).generate(world, rand, XCoord, YCoord, ZCoord);
		}
	}
			
			
			
}
