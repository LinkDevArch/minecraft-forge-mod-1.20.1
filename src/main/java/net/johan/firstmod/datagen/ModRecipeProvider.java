package net.johan.firstmod.datagen;

import net.johan.firstmod.block.ModBlocks;
import net.johan.firstmod.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GODBOW.get())
                .pattern(" D ")
                .pattern("GDG")
                .pattern(" B ")
                .define('D', ModItems.DIAMANTIUS.get())
                .define('G', Items.GOLD_INGOT)
                .define('B', Items.BONE)
                .unlockedBy(getHasName(ModItems.GODWEAPON.get()), has(ModItems.DIAMANTIUS.get()))
                .save(pWriter);
    }
}
