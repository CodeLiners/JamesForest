package mods.jameslfc19.forest.event;

import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.terraingen.BiomeEvent.CreateDecorator;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;

public class JamesWorldHandler {
	
	public JamesWorldHandler() {}
	
	@ForgeSubscribe
	public void icyMountainLakes(CreateDecorator event) {
		if(event.biome.biomeID == 72) {
			event.newBiomeDecorator.generateLakes = false;
		}
	}
	
	@ForgeSubscribe
	public void icyMountainDirt(GenerateMinable event) {
		if(event.world.getBlockId(event.worldX, 60, event.worldZ) == 72) {
			if(event.type == GenerateMinable.EventType.DIRT || event.type == GenerateMinable.EventType.GRAVEL) {
				event.setResult(Result.DENY);
			}
		}
	}

}
