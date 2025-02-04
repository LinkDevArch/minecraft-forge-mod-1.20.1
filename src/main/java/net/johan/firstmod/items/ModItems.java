package net.johan.firstmod.items;

import net.johan.firstmod.FirstMod;
import net.johan.firstmod.utils.CustomItemProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    //WEAPONS AND TOOLS BELLOW

    public static final RegistryObject<Item> GODWEAPON =ITEMS.register
            ("godweapon", () -> new SwordItem(Tiers.DIAMOND, 20, -2.4f,
                    new Item.Properties()));

    public static final RegistryObject<Item> GODBOW = ITEMS.register("godbow", () -> new CustomItemProperties(new Item.Properties()
           .stacksTo(1).durability(500).rarity(Rarity.EPIC)));

    //NATURAL INGREDIENTS BELLOW

    public static final RegistryObject<Item> DIAMANTIUS = ITEMS.register("diamantius", () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
