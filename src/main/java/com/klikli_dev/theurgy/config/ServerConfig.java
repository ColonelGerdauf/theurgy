/*
 * SPDX-FileCopyrightText: 2022 klikli-dev
 *
 * SPDX-License-Identifier: MIT
 */

package com.klikli_dev.theurgy.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.util.Lazy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServerConfig {

    private static final ServerConfig instance = new ServerConfig();
    public final Recipes recipes;
    public final ForgeConfigSpec spec;

    private ServerConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        this.recipes = new Recipes(builder);
        this.spec = builder.build();
    }

    public static ServerConfig get() {
        return instance;
    }

    public static class Recipes {

        protected ForgeConfigSpec.ConfigValue<List<? extends String>> sulfurSourceToBlockMappingList;

        public final Lazy<Map<String, String>> sulfurSourceToBlockMapping = Lazy.of(() -> this.sulfurSourceToBlockMappingList.get().stream()
                .map(s -> s.split(":"))
                .collect(Collectors.toMap(s -> s[0], s -> s[1])));

        public Recipes(ForgeConfigSpec.Builder builder) {
            builder.comment("Recipe Settings").push("recipes");

            this.sulfurSourceToBlockMappingList = builder
                    .comment(
                            "A mapping of sulfur source to origin block. The key is the sulfur source, the value is the block.",
                            "This is used by divination rod recipes to determine which (ore-)block to scan for, if e.g. a raw metal or ingot is used to craft the sulfur used in the rod.",
                            "Format is: [\"source=block\", \"source=block\", ...]"
                    )
                    .defineList("sulfurSourceToBlockMapping", List.of(), e -> ((String) e).contains("="));

            builder.pop();
        }
    }
}
