package mods.jameslfc19.forest.handler;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoundHandler {

	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void onSoundLoad(SoundLoadEvent event) {
		try {
			event.manager.soundPoolSounds.addSound("mods/jamesforest/sounds/stoneChange.ogg", 
					this.getClass().getResource("mods/jamesforest/sounds/stoneChange.ogg"));
			System.out.println("[JamesMod] Loaded sounds!");
		} catch(Exception e) {
			System.out.println("[JamesMod] Failed to load sounds!");
		}
	}
}
