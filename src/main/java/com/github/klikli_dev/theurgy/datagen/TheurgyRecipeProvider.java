/*
 * MIT License
 *
 * Copyright 2021 klikli-dev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT
 * OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.klikli_dev.theurgy.datagen;

import com.github.klikli_dev.theurgy.Theurgy;
import com.github.klikli_dev.theurgy.datagen.recipe.CrucibleRecipeBuilder;
import com.github.klikli_dev.theurgy.datagen.recipe.EssentiaRecipeBuilder;
import com.github.klikli_dev.theurgy.registry.BlockRegistry;
import com.github.klikli_dev.theurgy.registry.ItemRegistry;
import com.github.klikli_dev.theurgy.registry.TagRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.NotCondition;
import net.minecraftforge.common.crafting.conditions.TagEmptyCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class TheurgyRecipeProvider extends RecipeProvider {

    //region Fields
    public static final ITag.INamedTag<Item> COPPER_INGOT = TagRegistry.makeForgeItemTag("ingots/copper");
    public static final ITag.INamedTag<Item> TIN_INGOT = TagRegistry.makeForgeItemTag("ingots/tin");
    public static final ITag.INamedTag<Item> SILVER_INGOT = TagRegistry.makeForgeItemTag("ingots/silver");
    //endregion Fields

    //region Initialization
    public TheurgyRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }
    //endregion Initialization

    //region Overrides
    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        Item aer = ItemRegistry.AER_ESSENTIA.get();
        Item aqua = ItemRegistry.AQUA_ESSENTIA.get();
        Item ignis = ItemRegistry.IGNIS_ESSENTIA.get();
        Item terra = ItemRegistry.TERRA_ESSENTIA.get();

        //Modded Ingots
        EssentiaRecipeBuilder copperEssentia = EssentiaRecipeBuilder.create()
                                                       .setRecipeName("copper_ingot")
                                                       .ingredient(COPPER_INGOT)
                                                       .essentia(ignis, 100)
                                                       .essentia(terra, 100);
        this.registerTagExistsCondition(copperEssentia, COPPER_INGOT, consumer);

        EssentiaRecipeBuilder tinEssentia = EssentiaRecipeBuilder.create()
                                                       .setRecipeName("tin_ingot")
                                                       .ingredient(TIN_INGOT)
                                                       .essentia(ignis, 100)
                                                       .essentia(terra, 100);
        this.registerTagExistsCondition(tinEssentia, TIN_INGOT, consumer);

        EssentiaRecipeBuilder silverEssentia = EssentiaRecipeBuilder.create()
                                                    .setRecipeName("silver_ingot")
                                                    .ingredient(SILVER_INGOT)
                                                    .essentia(ignis, 150)
                                                    .essentia(terra, 150);
        this.registerTagExistsCondition(silverEssentia, SILVER_INGOT, consumer);

        //Vanilla ingots
        EssentiaRecipeBuilder ironIngotEssentia = EssentiaRecipeBuilder.create()
                                                     .setRecipeName("iron_ingot")
                                                     .ingredient(Tags.Items.INGOTS_IRON)
                                                     .essentia(ignis, 100)
                                                     .essentia(terra, 100)
                                                     .build(consumer);
        EssentiaRecipeBuilder goldIngotEssentia = EssentiaRecipeBuilder.create()
                                                     .setRecipeName("gold_ingot")
                                                     .ingredient(Tags.Items.INGOTS_GOLD)
                                                     .essentia(aer, 50)
                                                     .essentia(ignis, 200)
                                                     .essentia(terra, 200)
                                                     .build(consumer);
        EssentiaRecipeBuilder netheriteIngotEssentia = EssentiaRecipeBuilder.create()
                                                          .setRecipeName("netherite_ingot")
                                                          .ingredient(Tags.Items.INGOTS_NETHERITE)
                                                          .essentia(aer, 2000)
                                                          .essentia(ignis, 2000)
                                                          .build(consumer);

        //Vanilla Ores
        EssentiaRecipeBuilder netheriteScrapEssentia = EssentiaRecipeBuilder.create()
                                                               .setRecipeName("netherite_scrap")
                                                               .ingredient(Tags.Items.ORES_NETHERITE_SCRAP)
                                                               .essentia(aer, 500)
                                                               .essentia(ignis, 500)
                                                               .build(consumer);

        //Vanilla Gems
        EssentiaRecipeBuilder quartzEssentia = EssentiaRecipeBuilder.create()
                                                     .setRecipeName("quartz")
                                                     .ingredient(Tags.Items.GEMS_QUARTZ)
                                                     .essentia(aer, 20)
                                                     .essentia(ignis, 20)
                                                     .build(consumer);
        EssentiaRecipeBuilder lapisEssentia = EssentiaRecipeBuilder.create()
                                                       .setRecipeName("lapis")
                                                       .ingredient(Tags.Items.GEMS_LAPIS)
                                                       .essentia(aqua, 10)
                                                       .essentia(terra, 10)
                                                       .build(consumer);
        EssentiaRecipeBuilder diamondEssentia = EssentiaRecipeBuilder.create()
                                                      .setRecipeName("diamond")
                                                      .ingredient(Tags.Items.GEMS_DIAMOND)
                                                      .essentia(ignis, 1500)
                                                      .essentia(terra, 1000)
                                                      .build(consumer);
        EssentiaRecipeBuilder emeraldEssentia = EssentiaRecipeBuilder.create()
                                                        .setRecipeName("emerald")
                                                        .ingredient(Tags.Items.GEMS_EMERALD)
                                                        .essentia(aqua, 1000)
                                                        .essentia(ignis, 1500)
                                                        .essentia(terra, 1500)
                                                        .build(consumer);
        EssentiaRecipeBuilder prismarineCrystalEssentia = EssentiaRecipeBuilder.create()
                                                        .setRecipeName("prismarine_crystal")
                                                        .ingredient(Tags.Items.GEMS_PRISMARINE)
                                                        .essentia(aqua, 500)
                                                        .essentia(terra, 500)
                                                        .build(consumer);

        //Vanilla Dusts
        EssentiaRecipeBuilder prismarineShardEssentia = EssentiaRecipeBuilder.create()
                                                                  .setRecipeName("prismarine_shard")
                                                                  .ingredient(Tags.Items.DUSTS_PRISMARINE)
                                                                  .essentia(aqua, 500)
                                                                  .essentia(terra, 500)
                                                                  .build(consumer);
        EssentiaRecipeBuilder glowstoneDustEssentia = EssentiaRecipeBuilder.create()
                                                                .setRecipeName("glowstone_dust")
                                                                .ingredient(Tags.Items.DUSTS_GLOWSTONE)
                                                                .essentia(aer, 10)
                                                                .essentia(ignis, 10)
                                                                .build(consumer);
        EssentiaRecipeBuilder redstoneDustEssentia = EssentiaRecipeBuilder.create()
                                                              .setRecipeName("redstone_dust")
                                                              .ingredient(Tags.Items.DUSTS_REDSTONE)
                                                              .essentia(ignis, 10)
                                                              .essentia(terra, 10)
                                                              .build(consumer);

        //Coal
        EssentiaRecipeBuilder coalEssentia = EssentiaRecipeBuilder.create()
                                                     .setRecipeName("coal")
                                                     .ingredient(Items.COAL)
                                                     .essentia(ignis, 10)
                                                     .build(consumer);
        EssentiaRecipeBuilder charCoalEssentia = EssentiaRecipeBuilder.create()
                                                     .setRecipeName("charcoal")
                                                     .ingredient(Items.CHARCOAL)
                                                     .essentia(ignis, 10)
                                                     .build(consumer);
        //Vanilla Blocks
        EssentiaRecipeBuilder stoneEssentia = EssentiaRecipeBuilder.create()
                                                                .setRecipeName("stone")
                                                                .ingredient(Tags.Items.STONE)
                                                                .essentia(terra, 1)
                                                                .build(consumer);
        EssentiaRecipeBuilder obsidianEssentia = EssentiaRecipeBuilder.create()
                                                      .setRecipeName("obsidian")
                                                      .ingredient(Tags.Items.OBSIDIAN)
                                                      .essentia(terra, 10)
                                                      .build(consumer);

        //Vanilla Loot
        EssentiaRecipeBuilder boneEssentia = EssentiaRecipeBuilder.create()
                                                      .setRecipeName("bone")
                                                      .ingredient(Items.BONE)
                                                      .essentia(aer, 10)
                                                      .essentia(terra, 10)
                                                      .build(consumer);
        //Theurgy Items
        EssentiaRecipeBuilder aerCrystalEssentia = EssentiaRecipeBuilder.create()
                                                      .setRecipeName("aer_crystal")
                                                      .ingredient(BlockRegistry.AER_CRYSTAL.get())
                                                      .essentia(aer, 1500)
                                                      .build(consumer);
        EssentiaRecipeBuilder aquaCrystalEssentia = EssentiaRecipeBuilder.create()
                                                           .setRecipeName("aqua_crystal")
                                                           .ingredient(BlockRegistry.AQUA_CRYSTAL.get())
                                                           .essentia(aqua, 1500)
                                                           .build(consumer);
        EssentiaRecipeBuilder ignisCrystalEssentia = EssentiaRecipeBuilder.create()
                                                            .setRecipeName("ignis_crystal")
                                                            .ingredient(BlockRegistry.IGNIS_CRYSTAL.get())
                                                            .essentia(ignis, 1500)
                                                            .build(consumer);
        EssentiaRecipeBuilder terraCrystalEssentia = EssentiaRecipeBuilder.create()
                                                            .setRecipeName("terra_crystal")
                                                            .ingredient(BlockRegistry.TERRA_CRYSTAL.get())
                                                            .essentia(terra, 1500)
                                                            .build(consumer);
        //Transmutation recipes
        CrucibleRecipeBuilder.transmutation(Tags.Items.INGOTS_GOLD, 1)
                .setRecipeName("gold_ingot")
                .ingredient(Tags.Items.INGOTS_IRON)
                .essentia(this.essentiaDifference(ironIngotEssentia.essentia, goldIngotEssentia.essentia))
                .build(consumer);
    }
    //endregion Overrides

    //region Methods
    protected void registerTagExistsCondition(EssentiaRecipeBuilder builder, ITag.INamedTag<Item> tag,
                                              Consumer<IFinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(new NotCondition(new TagEmptyCondition(tag.getName())))
                .addRecipe(builder::build)
                .build(consumer, Theurgy.MODID, "essentia/" + builder.recipeName);
    }

    /**
     * Gets the remaining required essentia for an item
     *
     * @param inputEssentia the essentia contained in the input item.
     * @param inputEssentia the essentia contained in the desired output item.
     */
    protected List<ItemStack> essentiaDifference(List<ItemStack> inputEssentia, List<ItemStack> outputEssentia) {
        return essentiaDifference(inputEssentia, outputEssentia, 1.0f);
    }

    /**
     * Gets the remaining required essentia for an item
     *
     * @param inputEssentia            the essentia contained in the input item.
     * @param inputEssentia            the essentia contained in the desired output item.
     * @param outputEssentiaMultiplier a multiplier for the output essentia, usually to simulate loss / additional cost
     */
    protected List<ItemStack> essentiaDifference(List<ItemStack> inputEssentia, List<ItemStack> outputEssentia,
                                                 float outputEssentiaMultiplier) {
        List<ItemStack> result = new ArrayList<>();
        for (ItemStack essentia : outputEssentia) {
            Optional<ItemStack> other = inputEssentia.stream()
                                                .filter(stack -> stack.getItem() == essentia.getItem())
                                                .findFirst();
            if (other.isPresent()) {
                //if input has matching essentia, subtract it from requirement
                ItemStack output = essentia.copy();
                int difference = Math.max(0, essentia.getCount() - other.get().getCount());
                output.setCount((int) (difference * outputEssentiaMultiplier));
                result.add(output);
            }
            else {
                //if no matching input essentia, just return the output essentia * outputEssentiaMultiplier
                ItemStack output = essentia.copy();
                output.setCount((int) (essentia.getCount() * outputEssentiaMultiplier));
                result.add(output);
            }
        }
        return result;
    }
    //endregion Methods
}
