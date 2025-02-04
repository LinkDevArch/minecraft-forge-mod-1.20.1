package net.johan.firstmod.datagen;

import net.johan.firstmod.FirstMod;
import net.johan.firstmod.block.ModBlocks;
import net.johan.firstmod.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {


    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DIAMANTIUS_ORE.get(), ModBlocks.DEEPSLATE_DIAMANTIUS_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.DIAMANTIUS_ORE.get(), ModBlocks.DEEPSLATE_DIAMANTIUS_ORE.get());
    }
}
