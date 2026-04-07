package net.litetex.zpral.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.litetex.zpral.ZPRALGameRules;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;


@Mixin(ZombifiedPiglin.class)
@SuppressWarnings("javabugs:S6320")
public abstract class ZombifiedPiglinMixin
{
	@Inject(
		method = "customServerAiStep",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/entity/monster/zombie/Zombie;customServerAiStep"
				+ "(Lnet/minecraft/server/level/ServerLevel;)V"))
	protected void mobTick(final ServerLevel world, final CallbackInfo ci)
	{
		final ZombifiedPiglin current = (ZombifiedPiglin)(Object)this;
		if(current.isAngry())
		{
			current.lastHurtByPlayerMemoryTime = current.tickCount;
		}
	}
	
	@Inject(
		method = "setTarget",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/entity/monster/zombie/Zombie;setTarget"
				+ "(Lnet/minecraft/world/entity/LivingEntity;)V"))
	public void setTarget(final LivingEntity target, final CallbackInfo ci)
	{
		if(target instanceof final Player targetPlayer)
		{
			final ZombifiedPiglin current = (ZombifiedPiglin)(Object)this;
			current.setLastHurtByPlayer(targetPlayer, current.tickCount);
		}
	}
	
	@Inject(
		method = "populateDefaultEquipmentSlots",
		at = @At("HEAD"),
		cancellable = true
	)
	public void populateDefaultEquipmentSlots(
		final RandomSource randomSource,
		final DifficultyInstance difficultyInstance,
		final CallbackInfo ci)
	{
		final ZombifiedPiglin current = (ZombifiedPiglin)(Object)this;
		if(current.level() instanceof final ServerLevel serverLevel
			&& serverLevel.getGameRules().get(ZPRALGameRules.SPAWN_ZOMBIFIED_PIGLIN_ALWAYS_WITH_SWORD_ON_MAGMA_BLOCK)
			&& serverLevel.getBlockState(current.blockPosition().below()).is(Blocks.MAGMA_BLOCK))
		{
			current.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
			ci.cancel();
		}
	}
}
