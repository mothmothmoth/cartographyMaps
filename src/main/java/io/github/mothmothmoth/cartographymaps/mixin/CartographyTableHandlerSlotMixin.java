/**
 * this class was forked from this guy:
 * https://github.com/Pepperoni-Jabroni/MapAtlases/blob/916aede8a631947fdbab250031ebc1486e38e5e3/src/main/java
 *	/pepjebs/mapatlases/mixin/CartographyTableScreenHandlerMixin.java
 * im not sure how licensing works really but if this is illegal since my code is using the MIT license oops ill refactor
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
