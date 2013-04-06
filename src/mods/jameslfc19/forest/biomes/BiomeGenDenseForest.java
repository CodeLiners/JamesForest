package mods.jameslfc19.forest.biomes;

import mods.jameslfc19.forest.world.WorldGenThickwood;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenDenseForest extends BiomeGenBase {
		
	/** The tree generator. */
    protected WorldGenThickwood worldGenerator;

	public BiomeGenDenseForest(int par1) {
		super(par1);
		this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.setBiomeName("denceForest");
        this.setMinMaxHeight(0.1F, 0.2F);
        this.worldGenerator = new WorldGenThickwood();
	}

}
