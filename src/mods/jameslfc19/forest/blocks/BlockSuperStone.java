package mods.jameslfc19.forest.blocks;

import mods.jameslfc19.forest.JamesForest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockSuperStone extends BlockStone {

	public Icon face = null;
	
	public BlockSuperStone(int par1) {
		super(par1);
		this.setBlockUnbreakable();
	}
	
	@Override
    public void registerIcons(IconRegister register) {
        this.face = register.registerIcon("stone");
	}
	
	@Override
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return face;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par4, float par5, float par6, float par7) {
		if(!world.isRemote && !player.isSneaking() && player.inventory.getCurrentItem().getItem() == Item.diamond) {
			player.playSound("mods.jamesforest.sounds.stoneChange.ogg", 1.0F, 1.0F);
		}
		if(!world.isRemote && !player.isSneaking() && player.inventory.getCurrentItem().getItem() == Item.diamond) {
					x = x-10;
					y = y-10;
					z = z-10;
				for(int xchunk=x; xchunk<x+20; xchunk++){
					for(int ychunk=y; ychunk<y+20; ychunk++){
						for(int zchunk=z; zchunk<z+20; zchunk++){
							if(world.getBlockId(xchunk, ychunk, zchunk) == JamesForest.superStone.blockID){
								world.setBlock(xchunk, ychunk, zchunk, Block.stone.blockID);
							}
						}
					}
				}
				player.inventory.consumeInventoryItem(Item.diamond.itemID);
				player.addChatMessage("The surrounding blocks were made destructible!");
				return true;
				} 
		else if(!player.isSneaking()) {
				if(!world.isRemote) {
				player.addChatMessage("You need a Sacrifice to pass through here!");
				player.addChatMessage("Sacrifice a Diamond!");
				}
				return true;
				}
			return false;
			}
}
