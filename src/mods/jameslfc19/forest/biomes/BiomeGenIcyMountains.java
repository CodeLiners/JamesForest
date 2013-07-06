package mods.jameslfc19.forest.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenIcyMountains extends BiomeGenBase {

	public BiomeGenIcyMountains(int par1) {
		super(par1);
        temperature = BiomeGenBase.taigaHills.temperature;
		
        spawnableCreatureList.clear();
        this.setEnableSnow();
        
		this.topBlock = (byte)Block.snow.blockID;
        this.fillerBlock = (byte)Block.stone.blockID;
        this.setBiomeName("Icy Mountains");
        this.setMinMaxHeight(1.1F, 2.0F);
	}

}
