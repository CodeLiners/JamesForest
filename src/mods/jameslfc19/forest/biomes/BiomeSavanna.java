package mods.jameslfc19.forest.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeSavanna extends BiomeGenBase {

	public BiomeSavanna(int par1) {
		super(par1);
		this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.setBiomeName("Savanna");
        this.setMinMaxHeight(0.0F, 0.0F);
        this.setColor(0x5db9c7);
	}
	
	@Override
	public int getBiomeGrassColor()
    {
		return 0xc7ad5d;
    }

}
