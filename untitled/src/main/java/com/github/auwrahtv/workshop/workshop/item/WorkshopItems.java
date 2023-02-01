package com.github.auwrahtv.workshop.workshop.item;

import net.minecraft.item.Item;

import java.util.ArrayList;

public class WorkshopItems {

    public static final ArrayList<Item> ITEMS = new ArrayList<>();

    public static void special_arrow(Item item, String name) {
        item.setRegistryName(WorkshopItems.MODID,name).setUnlocalizedName(WorkshopItems.MODID + "." + name ) ;
        ITEMS.add(item);
    }
    public static void setItemBlockName (Item item,Block block) {
        item.setRegistryName(block.getRegistryName () ) ;
        ITEMS.add(item);
    }
    @SideOnly (Side.CLIENT) // Forge annotation for Side managing
    @SubscribeEvent // Forge annotation to subscribe to an event
    protected static void registerItemModels (ModelRegistryEvent e) {
        ITEMS.forEach (item -> registerModel (item,0)) ; //A simple forEach to call the method below
    }
    @SideOnly (Side.CLIENT)
    protected static void registerModel (Item item,int metadata) {
        ModelLoader.setCustomModelResourceLocation(item,metadata,new ModelResourceLocation ( item . getRegistryName () , " inventory ") ) ;
    }

}
