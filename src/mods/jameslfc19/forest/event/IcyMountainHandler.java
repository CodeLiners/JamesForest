package mods.jameslfc19.forest.event;

import java.util.Random;

import mods.jameslfc19.forest.registry.JamesBlock;
import mods.jameslfc19.forest.registry.JamesItem;
import mods.jameslfc19.forest.registry.JamesRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraft.entity.passive.*;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.terraingen.BiomeEvent.CreateDecorator;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate;

public class IcyMountainHandler {
	
	public IcyMountainHandler() {}
		
	@ForgeSubscribe
	public void modDrop(LivingDropsEvent event) {
		Random rand = event.entity.worldObj.rand;
		if(event.entityLiving instanceof EntityWolf) {
			System.out.println("I'm a wolf!");
			int count = rand.nextInt(3);
			if(count != 0) {
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY + 0.5, event.entity.posZ, new ItemStack(JamesItem.wolfMeat, rand.nextInt(3))));
			}
		}
	}
	
	@ForgeSubscribe
	public void icyMountainLakes(CreateDecorator event) {
		if(event.biome == JamesRegistry.ICY_MOUNTAIN) {
			event.newBiomeDecorator.generateLakes = false;
		}
	}
	
	@ForgeSubscribe
	public void randomSnow(Populate event) {
		BiomeGenBase base = event.world.getBiomeGenForCoords((event.chunkX * 16), (event.chunkZ * 16));
		if(base == JamesRegistry.ICY_MOUNTAIN) {
			
			if(event.type == Populate.EventType.ICE) {
				int newX = (event.chunkX * 16) + 8;
				int newZ = (event.chunkZ * 16) + 8;
				
		        for (int count = 0; count < 16; ++count) { 
		            for (int count2 = 0; count2 < 16; ++count2) {
		                int height = event.world.getPrecipitationHeight(newX + count, newZ + count2);
		                if (event.world.canSnowAt(count + newX, height, count2 + newZ)) {
		                    event.world.setBlock(count + newX, height, count2 + newZ, Block.snow.blockID, 0, 2);
		                    event.world.setBlockMetadataWithNotify(count + newX, height, count2 + newZ, event.rand.nextInt(3), 3);
		                }
		            }
		        }
				event.setResult(Result.DENY);
			}
		}
	}
	
	@ForgeSubscribe
	public void icyMountainDirt(GenerateMinable event) {
		BiomeGenBase base = event.world.getBiomeGenForCoords(event.worldX, event.worldZ);
		if(base == JamesRegistry.ICY_MOUNTAIN) {
			if(event.type == EventType.DIRT || event.type == EventType.GRAVEL) {
				event.setResult(Result.DENY);
			}
		}
	}

}
