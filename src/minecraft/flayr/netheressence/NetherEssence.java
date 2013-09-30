package flayr.netheressence;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = NetherEssence.MOD_ID, name = NetherEssence.MOD_NAME, version = NetherEssence.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class NetherEssence
{
    public static final String MOD_ID = "NetherEssence";
    static final String MOD_NAME = "NetherEssence";
    static final String MOD_VERSION = "1.0.1";
    static final String SOURCE_PATH = "flayr.netheressence.";
    private static int netherDustBlockID;
    private static int netherDustID;
    public static Item netherDust;
    public static Block netherDustBlock;
    
        @Mod.Instance("MOD_ID")
        public static NetherEssence instance;

        @SidedProxy(clientSide="flayr.netheressence.client.ClientProxy",
                        serverSide="flayr.netheressence.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
            Configuration config = new Configuration(event.getSuggestedConfigurationFile());

            config.load();
            netherDustBlockID = config.getBlock("netherDustBlock", 671).getInt();
            netherDustID = config.getItem("netherDust", 2526).getInt();
            config.save();
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) {
            netherDust = new NetherDust(netherDustID);
            
            netherDustBlock = new NetherDustBlock(netherDustBlockID, Material.rock)
            .setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setLightValue(0.8f)
            .setUnlocalizedName("netherDustBlock").setCreativeTab(CreativeTabs.tabBlock);
            
        	ItemStack dustStack = new ItemStack(netherDust);
        	ItemStack waterStack = new ItemStack(Item.bucketWater);
        	ItemStack soulStack = new ItemStack(Block.slowSand);
        	ItemStack netherrackStack = new ItemStack(Block.netherrack);
        	ItemStack coalStack = new ItemStack(Item.coal);
        	ItemStack redStack = new ItemStack(Item.redstone);
        	ItemStack potionStack = new ItemStack(Item.potion);
        	
        	GameRegistry.addRecipe(new ItemStack(netherDust, 3), "xxx", "yzy", "xxx",
        	        'x', netherrackStack, 'y', soulStack, 'z', waterStack);
        	GameRegistry.addRecipe(new ItemStack(netherDust, 3), "xyx", "xzx", "xyx",
        	        'x', netherrackStack, 'y', soulStack, 'z', potionStack);
        	GameRegistry.addRecipe(new ItemStack(netherDust, 3), "xyx", "xzx", "xyx",
        	        'x', netherrackStack, 'y', soulStack, 'z', waterStack);
        	GameRegistry.addRecipe(new ItemStack(netherDust, 3), "xxx", "yzy", "xxx",
        	        'x', netherrackStack, 'y', soulStack, 'z', potionStack);
        	GameRegistry.addRecipe(new ItemStack(Item.gunpowder), "drd", "rcr", "drd",
        	        'd', dustStack, 'r', redStack, 'c', coalStack);
        	GameRegistry.addRecipe(new ItemStack(Item.gunpowder), "rdr", "dcd", "rdr",
        	        'd', dustStack, 'r', redStack, 'c', coalStack);
        	GameRegistry.addRecipe(new ItemStack(netherDustBlock), "xxx", "x x", "xxx",
        	        'x', dustStack);
        	GameRegistry.addShapelessRecipe(new ItemStack(netherDust, 8), new ItemStack(netherDustBlock));
        	    
                LanguageRegistry.addName(netherDust, "Nether Essence");
                LanguageRegistry.addName(netherDustBlock, "Nether Essence Block");
                MinecraftForge.setBlockHarvestLevel(netherDustBlock, "pick", 0);
                GameRegistry.registerBlock(netherDustBlock, "netherDustBlock");
                GameRegistry.registerFuelHandler(new NetherEssenceFuelHandler());
        }
        
        @Mod.EventHandler
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}