package io.github.mothmothmoth.cartographymaps.mixin;

import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.CartographyTableScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CartographyTableScreenHandler.class)
public abstract class CartographyTableScreenHandlerMixin extends ScreenHandler {

	@Final @Shadow
	private CraftingResultInventory resultInventory;

	@Final @Shadow
	private ScreenHandlerContext context;

	protected CartographyTableScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId) {
		super(type, syncId);
	}

	@Inject(method = "updateResult", at = @At("HEAD"), cancellable = true)
	void mapMakingUpdateResult(ItemStack topItem, ItemStack bottomItem, ItemStack unUsed, CallbackInfo info) {
		if (topItem.getItem() == Items.PAPER && (bottomItem.getItem() == Items.INK_SAC || bottomItem.getItem() == Items.GLOW_INK_SAC)) {
			ItemStack mapItem = Items.MAP.getDefaultStack();
			if (bottomItem.getItem() == Items.GLOW_INK_SAC) {
				mapItem.setCount(2);
			}
			this.context.run((world, blockPos) -> {
				this.resultInventory.setStack(CartographyTableScreenHandler.RESULT_SLOT_INDEX, mapItem);
			});
			this.sendContentUpdates();

			info.cancel();
		}
	}
}
