package com.FishingLife.fishinglife.block.entity.renderer;

import com.FishingLife.fishinglife.block.entity.ChoppingBoardBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.Level;
import com.mojang.math.Axis;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChoppingBoardBlockEntityRenderer implements BlockEntityRenderer<ChoppingBoardBlockEntity> {
    private static final Logger LOGGER = LogManager.getLogger();

    public ChoppingBoardBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        // Constructor can be used for initialization if needed
    }

    @Override
    public void render(ChoppingBoardBlockEntity blockEntity, float partialTicks, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = blockEntity.getRenderStack();
        //LOGGER.info("CHOPPING BOARD RANDER");
        if (!itemStack.isEmpty()) {

            poseStack.pushPose();

            Direction itemFacing = blockEntity.getItemFacing();

            // Adjust the position and rotation based on the item's facing direction
            poseStack.translate(0.5f, 0.8f, 0.5f); // Position the item above the block
            switch (itemFacing) {
                case NORTH:
                    poseStack.mulPose(Axis.YP.rotationDegrees(0));
                    break;
                case SOUTH:
                    poseStack.mulPose(Axis.YP.rotationDegrees(180));
                    break;
                case WEST:
                    poseStack.mulPose(Axis.YP.rotationDegrees(90));
                    break;
                case EAST:
                    poseStack.mulPose(Axis.YP.rotationDegrees(270));
                    break;
            }
            poseStack.scale(1f, 1f, 1f); // Scale the item
            poseStack.mulPose(Axis.XP.rotationDegrees(90)); // Rotate the item to lay flat
            int lightLevel = getLightLevel(blockEntity.getLevel(), blockEntity.getBlockPos());
            itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, lightLevel,
                    OverlayTexture.NO_OVERLAY, poseStack, bufferSource, blockEntity.getLevel(), 1);

            poseStack.popPose();
        }
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int blockLight = level.getBrightness(LightLayer.BLOCK, pos);
        int skyLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(blockLight, skyLight);
    }
}
