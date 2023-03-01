/*
 * SPDX-FileCopyrightText: 2023 klikli-dev
 *
 * SPDX-License-Identifier: MIT
 */

package com.klikli_dev.theurgy.content.renderer;

import com.klikli_dev.theurgy.content.block.distiller.DistillerBlockEntity;
import com.klikli_dev.theurgy.content.renderer.model.DistillerModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class DistillerRenderer extends GeoBlockRenderer<DistillerBlockEntity> {
    public DistillerRenderer(BlockEntityRendererProvider.Context pContext) {
        super(new DistillerModel());
    }
}
