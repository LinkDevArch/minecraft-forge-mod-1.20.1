package net.johan.firstmod.block;

import net.johan.firstmod.FirstMod;
import net.johan.firstmod.items.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);

    public static final RegistryObject<Block> DIAMANTIUS_ORE = registerBlock("diamantius_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.3f).requiresCorrectToolForDrops()
                    , UniformInt.of(3, 6)));

    public static final RegistryObject<Block> DEEPSLATE_DIAMANTIUS_ORE = registerBlock("deepslate_diamantius_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.3f).requiresCorrectToolForDrops()
                    , UniformInt.of(3, 6)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
