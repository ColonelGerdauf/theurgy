/*
 * SPDX-FileCopyrightText: 2022 klikli-dev
 *
 * SPDX-License-Identifier: MIT
 */

package com.klikli_dev.theurgy.datagen.book;

import com.klikli_dev.modonomicon.api.datagen.CategoryProvider;
import com.klikli_dev.modonomicon.api.datagen.book.BookCategoryModel;
import com.klikli_dev.modonomicon.api.datagen.book.BookEntryModel;
import com.klikli_dev.modonomicon.api.datagen.book.page.BookCraftingRecipePageModel;
import com.klikli_dev.modonomicon.api.datagen.book.page.BookSpotlightPageModel;
import com.klikli_dev.modonomicon.api.datagen.book.page.BookTextPageModel;
import com.klikli_dev.theurgy.Theurgy;
import com.klikli_dev.theurgy.registry.BlockRegistry;
import com.klikli_dev.theurgy.registry.ItemRegistry;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class GettingStartedCategoryProvider extends CategoryProvider {

    public static final String CATEGORY_ID = "getting_started";

    public GettingStartedCategoryProvider(TheurgyBookProvider parent) {
        super(parent, CATEGORY_ID);
    }

    public TheurgyBookProvider parent() {
        return (TheurgyBookProvider) this.parent;
    }

    @Override
    protected String[] generateEntryMap() {

        return new String[]{
                "__________________________________",
                "__________________ḍ___ď_ḑ_ḓ_______",
                "__________________________________",
                "________________d___ḋ_____________",
                "______________________ɖ_ᶑ_________",
                "__________________đ_______________",
                "__________________________________",
                "__________i_a_________ö___________",
                "__________________________________",
                "______________s_š_o_ó___ô_õ_______",
                "__________________________________",
                "______________u_______ò___________"
        };
    }

    @Override
    protected BookCategoryModel generateCategory() {
        this.add(this.context().categoryName(), "Getting Started");

        var rods = new DivinationRodEntryProvider(this.parent(), this.entryMap());
        var ore = new OreRefiningEntryProvider(this.parent(), this.entryMap());

        var introEntry = this.makeIntroEntry('i');
        var aboutModEntry = this.makeAboutModEntry('a');

        var aboutDivinationRods = rods.makeAboutDivinationRodsEntry('d');
        var t1DivinationRod = rods.makeT1DivinationRodEntry('ḍ');
        var abundantAndCommonSulfurAttunedDivinationRod = rods.makeAbundantAndCommonSulfurAttunedDivinationRodEntry('đ');
        var amethystDivinationRod = rods.makeAmethystDivinationRodEntry('ḋ');
        var t2DivinationRod = rods.makeT2DivinationRodEntry('ď');
        var t3DivinationRod = rods.makeT3DivinationRodEntry('ḑ');
        var t4DivinationRod = rods.makeT4DivinationRodEntry('ḓ');
        var rareSulfurAttunedDivinationRod = rods.makeRareSulfurAttunedDivinationRodEntry('ɖ');
        var preciousSulfurAttunedDivinationRod = rods.makePreciousSulfurAttunedDivinationRodEntry('ᶑ');

        var spagyricsEntry = this.makeSpagyricsEntry('s');
        var apparatusHowToEntry = this.makeApparatusHowToEntry('u');
        var spagyricsLinkEntry = this.makeSpagyricsLinkEntry('š');

        var aboutOreRefining = ore.makeAboutOreRefiningEntry('o');
        //ó -> machines to build (spotlight entries with links)?
        //ö -> obtain sulfur -> explain that here the duplication happens
        //ô -> obtain salt -> explain that here we use other ore as source
        //ò -> obtain mercury -> explain that here we use any material as source
        //õ -> incubation -> maybe different bg?

        //links and conditions
        aboutModEntry.withParent(introEntry);

        aboutDivinationRods.withParent(aboutModEntry);

        t1DivinationRod.withParent(aboutDivinationRods);

        abundantAndCommonSulfurAttunedDivinationRod.withParent(aboutDivinationRods);
        abundantAndCommonSulfurAttunedDivinationRod.withParent(spagyricsLinkEntry);
//        abundantAndCommonSulfurAttunedDivinationRod.withCondition(
//                this.parent().and(
//                        this.parent().entryReadCondition(aboutDivinationRods),
//                        this.parent().advancementCondition(this.modLoc("has_liquefaction_cauldron"))
//                )
//        );

        amethystDivinationRod.withParent(t1DivinationRod);
        amethystDivinationRod.withParent(abundantAndCommonSulfurAttunedDivinationRod);
//        amethystDivinationRod.withCondition(
//                this.parent().and(
//                        this.parent().or(
//                                this.parent().entryReadCondition(t1DivinationRod),
//                                this.parent().entryReadCondition(abundantAndCommonSulfurAttunedDivinationRod)
//                        ),
//                        this.parent().advancementCondition(this.modLoc("has_basic_rod")
//                        )
//                )
//        );

        t2DivinationRod.withParent(amethystDivinationRod);
//        t2DivinationRod.withCondition(
//                this.parent().and(
//                        this.parent().entryReadCondition(amethystDivinationRod),
//                        this.parent().advancementCondition(this.modLoc("has_amethyst_rod"))
//                )
//        );

        t3DivinationRod.withParent(t2DivinationRod);
//        t3DivinationRod.withCondition(
//                this.parent().and(
//                        this.parent().entryReadCondition(t2DivinationRod),
//                        this.parent().advancementCondition(this.modLoc("has_t2_rod"))
//                )
//        );

        t4DivinationRod.withParent(t3DivinationRod);
//        t4DivinationRod.withCondition(
//                this.parent().and(
//                        this.parent().entryReadCondition(t3DivinationRod),
//                        this.parent().advancementCondition(this.modLoc("has_t3_rod"))
//                )
//        );

        rareSulfurAttunedDivinationRod.withParent(amethystDivinationRod);
//        rareSulfurAttunedDivinationRod.withCondition(
//                this.parent().and(
//                        this.parent().entryReadCondition(amethystDivinationRod),
//                        this.parent().advancementCondition(this.modLoc("has_amethyst_rod"))
//                )
//        );

        preciousSulfurAttunedDivinationRod.withParent(rareSulfurAttunedDivinationRod);
//        preciousSulfurAttunedDivinationRod.withCondition(
//                this.parent().and(
//                        this.parent().entryReadCondition(rareSulfurAttunedDivinationRod),
//                        this.parent().advancementCondition(this.modLoc("has_rare_rod"))
//                )
//        );

        spagyricsEntry.withParent(aboutModEntry);
        apparatusHowToEntry.withParent(spagyricsEntry);
        spagyricsLinkEntry.withParent(spagyricsEntry);

        aboutOreRefining.withParent(spagyricsLinkEntry);

        //TODO: Conditions
        //  amethyst entry should NOT depend on spagyrics -> hence not on abundant sulfur rod


        return BookCategoryModel.create(
                        Theurgy.loc((this.context().categoryId())),
                        this.context().categoryName()
                )
                .withIcon(ItemRegistry.THE_HERMETICA_ICON.get())
                .withBackground(Theurgy.loc("textures/gui/book/bg_nightsky.png"))
                .withEntries(
                        introEntry.build(),
                        aboutModEntry.build(),
                        aboutDivinationRods.build(),
                        t1DivinationRod.build(),
                        abundantAndCommonSulfurAttunedDivinationRod.build(),
                        amethystDivinationRod.build(),
                        t2DivinationRod.build(),
                        t3DivinationRod.build(),
                        t4DivinationRod.build(),
                        rareSulfurAttunedDivinationRod.build(),
                        preciousSulfurAttunedDivinationRod.build(),
                        apparatusHowToEntry.build(),
                        spagyricsEntry.build(),
                        spagyricsLinkEntry.build(),
                        aboutOreRefining.build()
                );
    }

    private BookEntryModel.Builder makeIntroEntry(char icon) {
        this.context().entry("intro");
        this.add(this.context().entryName(), "About this Work");
        this.add(this.context().entryDescription(), "About using The Hermetica");

        this.context().page("intro");
        var intro = BookTextPageModel.builder()
                .withTitle(this.context().pageTitle())
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageTitle(), "About this Work");
        this.add(this.context().pageText(),
                """
                        The following pages will lead the novice alchemist on their journey through the noble art of the transformation of matter and mind. This humble author will share their experiences, thoughts and research notes to guide the valued reader in as safe a manner as the subject matter allows.
                        """);

        this.context().page("help");
        var help = BookTextPageModel.builder()
                .withTitle(this.context().pageTitle())
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageTitle(), "Seeking Counsel");
        this.add(this.context().pageText(),
                """
                        If the reader finds themselves in trouble of any kind, prompt assistance will be provided at the Council of Alchemists, known also as Kli Kli's Discord Server.
                        \\
                        \\
                        [To get help, join us at https://invite.gg/klikli](https://invite.gg/klikli)
                        """);


        return BookEntryModel.builder()
                .withId(Theurgy.loc(this.context().categoryId() + "/" + this.context().entryId()))
                .withName(this.context().entryName())
                .withDescription(this.context().entryDescription())
                .withIcon(ItemRegistry.THE_HERMETICA_ICON.get())
                .withLocation(this.entryMap().get(icon))
                .withEntryBackground(EntryBackground.CATEGORY_START)
                .withPages(
                        intro,
                        help
                );
    }

    private BookEntryModel.Builder makeAboutModEntry(char icon) {
        this.context().entry("about_mod");
        this.add(this.context().entryName(), "The Art of Alchemy");
        this.add(this.context().entryDescription(), "About this Mod");

        this.context().page("about");
        var about = BookTextPageModel.builder()
                .withTitle(this.context().pageTitle())
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageTitle(), "The Art of Alchemy");
        this.add(this.context().pageText(),
                """
                        Welcome, dear reader, to Theurgy, a mod that explores the ancient and revered art of classical alchemy. As you embark on your journey through the noble art of transformation, you will be equipped with divination rods to make finding resources in the world easier.
                        """);
        this.context().page("about2");
        var about2 = BookTextPageModel.builder()
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageText(),
                """
                        Through diligent study and practice, you will then learn to use alchemical devices to refine, replicate, and transform resources into new and useful materials. Along the way, you will have the opportunity to craft alchemical devices and equipment to aid you in your endeavors.
                        """);

        this.context().page("about3");
        var about3 = BookTextPageModel.builder()
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageText(),
                """
                        As a final note, alchemists are guided by reason and logic, not superstition or magic. Our experiments are based on careful observation, meticulous record-keeping, and rigorous testing. We do not claim to possess supernatural powers, but rather seek to harness the natural forces of the world around us to achieve our goals.
                        """);

        this.context().page("features");
        var features = BookTextPageModel.builder()
                .withTitle(this.context().pageTitle())
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageTitle(), "Features");
        this.add(this.context().pageText(),
                """
                        - Divination rods to find ores
                        - Future: Ore refining (= more ingots per ore)
                        - Future: Item replication (create duplicates of items you have)
                        - Future: Item transformation (create new items from other items)
                        """);

        this.context().page("features2");
        var features2 = BookTextPageModel.builder()
                .withTitle(this.context().pageTitle())
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageTitle(), "More Features");
        this.add(this.context().pageText(),
                """
                        - Future: Weapons and Equipment
                        - Future: Devices to assist in common tasks
                        """);


        return BookEntryModel.builder()
                .withId(Theurgy.loc(this.context().categoryId() + "/" + this.context().entryId()))
                .withName(this.context().entryName())
                .withDescription(this.context().entryDescription())
                .withIcon(Items.NETHER_STAR)
                .withLocation(this.entryMap().get(icon))
                .withEntryBackground(EntryBackground.DEFAULT)
                .withPages(
                        about,
                        about2,
                        about3,
                        features,
                        features2
                );
    }


    private BookEntryModel.Builder makeApparatusHowToEntry(char icon) {
        this.context().entry("apparatus_how_to");
        this.add(this.context().entryName(), "Alchemical Apparatus");
        this.add(this.context().entryDescription(), "How to interact with the tools of the trade");

        this.context().page("intro");
        var intro = BookTextPageModel.builder()
                .withTitle(this.context().pageTitle())
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageTitle(), "Alchemical Apparatus");
        this.add(this.context().pageText(),
                """
                        Alchemist use a variety of tools and devices to aid them in their work. These devices are collectively referred to as apparatus.
                        \\
                        \\
                        It is important to understand that each apparatus should only have one specific function, such as generating heat or melting items.
                                 """);

        this.context().page("intro2");
        var intro2 = BookTextPageModel.builder()
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageText(),
                """
                        By adhering to this principle, we can create a modular system that allows for greater flexibility and efficiency in our work.
                        \\
                        \\
                        Further, all apparatus follow a standardized interaction pattern that makes it easier to use them both for manual interactions and for automation.
                                 """);

        this.context().page("manual_interaction");
        var manualInteraction = BookTextPageModel.builder()
                .withTitle(this.context().pageTitle())
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageTitle(), "Manual Interaction");
        this.add(this.context().pageText(),
                """
                        To interact with an apparatus, approach it and right-click on it.
                        \\
                        \\
                        **Taking Output Items**\\
                        If you have an empty hand, the machine will first try to take the contents of its output slot and place them in your inventory.
                                    """);

        this.context().page("manual_interaction2");
        var manualInteraction2 = BookTextPageModel.builder()
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageText(),
                """
                        **Taking Input Items**\\
                        If there are no output items, it will instead try to place the contents of its input slot into your inventory, effectively emptying it.
                        \\
                        \\
                        **Inserting Items**\\
                        If you have an item in your hand, the apparatus will automatically try to insert it into the input slot.
                                    """);

        this.context().page("fluid_interaction");
        var fluidInteraction = BookTextPageModel.builder()
                .withTitle(this.context().pageTitle())
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageTitle(), "Fluids");
        this.add(this.context().pageText(),
                """
                        If you click on an apparatus with a filled fluid container in your hand, it will try to empty the container into the device.
                        \\
                        \\
                        If you click on an apparatus with an empty fluid container in your hand, it will instead try to fill the container from the device.
                                    """);

        this.context().page("automatic_interaction");
        var automaticInteraction = BookTextPageModel.builder()
                .withTitle(this.context().pageTitle())
                .withText(this.context().pageText())
                .build();

        this.add(this.context().pageTitle(), "Automatic Interaction");
        this.add(this.context().pageText(),
                """
                        Automatic interactions also use a standardized pattern.
                        \\
                        \\
                        **Input** slots can be accessed from the **top**, while **output** slots are available at the **bottom**.\\
                        \\
                        A **combined inventory** can be found at the horizontal **sides**.
                                  """);


        return BookEntryModel.builder()
                .withId(Theurgy.loc(this.context().categoryId() + "/" + this.context().entryId()))
                .withName(this.context().entryName())
                .withDescription(this.context().entryDescription())
                .withIcon(BlockRegistry.PYROMANTIC_BRAZIER.get())
                .withLocation(this.entryMap().get(icon))
                .withEntryBackground(EntryBackground.DEFAULT)
                .withPages(
                        intro,
                        intro2,
                        manualInteraction,
                        manualInteraction2,
                        fluidInteraction,
                        automaticInteraction
                );
    }

    private BookEntryModel.Builder makeSpagyricsEntry(char icon) {
        this.context().entry("spagyrics");
        this.add(this.context().entryName(), "Spagyrics");
        this.add(this.context().entryDescription(), "Mastery over Matter");

        this.context().page("intro");
        var intro = BookTextPageModel.builder()
                .withTitle(this.context().pageTitle())
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageTitle(), "Spagyrics");
        this.add(this.context().pageText(),
                """
                        While divination rods are a useful tool to obtain *more* materials, they rely on the natural abundance of such materials.
                        \\
                        \\
                        Spagyrics pursue the goal of *creating* materials out of other, possibly more abundant, materials.""");

        this.context().page("intro2");
        var intro2 = BookTextPageModel.builder()
                .withTitle(this.context().pageTitle())
                .withText(this.context().pageText())
                .build();
        this.add(this.context().pageTitle(), "Learn More");
        this.add(this.context().pageText(),
                """
                        Open the Spagyrics Category to learn more about the various required alchemical processes.
                        """);

        return BookEntryModel.builder()
                .withId(Theurgy.loc(this.context().categoryId() + "/" + this.context().entryId()))
                .withName(this.context().entryName())
                .withDescription(this.context().entryDescription())
                .withIcon(BlockRegistry.CALCINATION_OVEN.get())
                .withLocation(this.entryMap().get(icon))
                .withEntryBackground(EntryBackground.DEFAULT)
                .withPages(
                        intro,
                        intro2
                );
    }

    private BookEntryModel.Builder makeSpagyricsLinkEntry(char icon) {
        this.context().entry("spagyrics_link");
        this.add(this.context().entryName(), "Spagyrics");
        this.add(this.context().entryDescription(), "View the Spagyrics Category");

        return BookEntryModel.builder()
                .withId(Theurgy.loc(this.context().categoryId() + "/" + this.context().entryId()))
                .withName(this.context().entryName())
                .withDescription(this.context().entryDescription())
                .withIcon(BlockRegistry.CALCINATION_OVEN.get())
                .withLocation(this.entryMap().get(icon))
                .withCategoryToOpen(Theurgy.loc(SpagyricsCategoryProvider.CATEGORY_ID))
                .withEntryBackground(EntryBackground.LINK_TO_CATEGORY);
    }


}
