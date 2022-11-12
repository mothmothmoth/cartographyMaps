/**
 * This class was forked from:
 * https://github.com/AntiqueAtlasTeam/AntiqueAtlas/blob/37038a399ecac1d58bcc7164ef3d309e8636a2cb/src/main/java
 *      /hunternif/mc/impl/atlas/mixin/prod/CartographyTableHandlerSlotMixin.java
 * Under the GPL-3 license.
 */
package io.github.mothmothmoth.cartographymaps.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.screen.CartographyTableScreenHandler$3")
class CartographyTableScreenHandlerFirstSlotMixin {

	@Inject(method = "canInsert", at = @At("RETURN"), cancellable = true)
	void canInsertPaper(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
		info.setReturnValue(
				stack.getItem() == Items.PAPER ||
				info.getReturnValueZ());
	}
}

@Mixin(targets = "net.minecraft.screen.CartographyTableScreenHandler$4")
class CartographyTableScreenHandlerSecondSlotMixin {

	@Inject(method = "canInsert", at = @At("RETURN"), cancellable = true)
	void canInsertInk(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
		info.setReturnValue(
				stack.getItem() == Items.INK_SAC ||
				stack.getItem() ==  Items.GLOW_INK_SAC ||
				info.getReturnValueZ());
	}
}
