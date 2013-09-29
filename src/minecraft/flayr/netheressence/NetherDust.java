package flayr.netheressence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class NetherDust extends Item {

        public NetherDust(int id) {
                super(id);
                
                // Constructor Configuration
                maxStackSize = 64;
                setCreativeTab(CreativeTabs.tabMaterials);
                setUnlocalizedName("netherDust");
        }
        

        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister iconRegister) {
            this.itemIcon = iconRegister.registerIcon("netheressence:netherDust");
        }
}