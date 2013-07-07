package mods.jameslfc19.forest.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityIceGolem extends EntityMob {

	public EntityIceGolem(World par1World) {
		super(par1World);
	}

	 public int getMaxHealth() 
	 {
	  return 25;
	 }


}
