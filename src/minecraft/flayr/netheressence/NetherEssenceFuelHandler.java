package flayr.netheressence;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;


public class NetherEssenceFuelHandler implements IFuelHandler {
    @Override
	public int getBurnTime(ItemStack fuel) {
        if(fuel.itemID == NetherEssence.netherDust.itemID){
            return 800;}
        if(fuel.itemID == NetherEssence.netherDustBlock.blockID){
            return 6400;}
        else 
        {
        return 0;
        }
        }
}
        