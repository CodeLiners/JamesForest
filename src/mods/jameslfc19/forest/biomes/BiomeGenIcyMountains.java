package mods.jameslfc19.forest.biomes;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenIcyMountains extends BiomeGenBase {

	public BiomeGenIcyMountains(int par1) {
		super(par1);
        temperature = BiomeGenBase.taigaHills.temperature;
		
        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 6, 4, 6));
        this.setEnableSnow();
        
		this.topBlock = (byte)Block.blockSnow.blockID;
        this.fillerBlock = (byte)Block.stone.blockID;
        this.setBiomeName("Icy Mountains");
        this.setMinMaxHeight(1.1F, 2.0F);
	}

}
