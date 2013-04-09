package mods.jameslfc19.forest.blocks;

import mods.jameslfc19.forest.JamesForest;
import mods.jameslfc19.forest.utils.ColorUtils;
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
		if(!world.isRemote && !player.isSneaking()) {
			if (player.inventory.getCurrentItem() != null){
				if(player.inventory.getCurrentItem().getItem() == Item.diamond){
					x = x-11;
					y = y-11;
					z = z-11;
				for(int xchunk=x; xchunk<x+21; xchunk++){
					for(int ychunk=y; ychunk<y+21; ychunk++){
						for(int zchunk=z; zchunk<z+21; zchunk++){
							if(world.getBlockId(xchunk, ychunk, zchunk) == JamesForest.superStone.blockID){
								world.setBlock(xchunk, ychunk, zchunk, Block.stone.blockID);
							}
						}
					}
				}
				player.inventory.consumeInventoryItem(Item.diamond.itemID);
				player.addChatMessage("The surrounding blocks were made destructible!");
				return true;
				} else {
					player.addChatMessage(ColorUtils.applyColor(12) + "You need a Sacrifice to pass through here!");
					player.addChatMessage(ColorUtils.applyColor(10) + "Sacrifice a " + ColorUtils.applyColor(11) + "Diamond!");
				}
			} else {
				player.addChatMessage(ColorUtils.applyColor(12) + "You need a Sacrifice to pass through here!");
				player.addChatMessage(ColorUtils.applyColor(10) + "Sacrifice a " + ColorUtils.applyColor(11) + "Diamond!");
			}
		} 
		
		return false;
	}
	
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		if(!world.isRemote){
		player.addChatMessage(ColorUtils.applyColor(12) + "You need a Sacrifice to pass through here!");
		player.addChatMessage(ColorUtils.applyColor(10) + "Sacrifice a " + ColorUtils.applyColor(11) + "Diamond!");
		}
	}
}
