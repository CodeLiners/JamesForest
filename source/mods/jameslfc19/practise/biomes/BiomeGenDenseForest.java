package mods.jameslfc19.practise.biomes;

import mods.jameslfc19.practise.world.gen.WorldGenCoolTree;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
public class BiomeGenDenseForest extends BiomeGenBase {
	
	//815067184190702762
	
	/** The tree generator. */
    protected WorldGenCoolTree worldGeneratorCoolTrees;

	public BiomeGenDenseForest(int par1) {
		super(par1);
		this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.setBiomeName("StoneHenge");
        this.setMinMaxHeight(0.1F, 0.2F);
        this.worldGeneratorCoolTrees = new WorldGenCoolTree();
	}

}
