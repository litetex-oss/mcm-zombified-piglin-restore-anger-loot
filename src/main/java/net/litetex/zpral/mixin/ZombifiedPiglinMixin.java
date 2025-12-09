package net.litetex.zpral.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;


@Mixin(ZombifiedPiglin.class)
@SuppressWarnings("javabugs:S6320")
public abstract class ZombifiedPiglinMixin
{
	@Inject(method = "customServerAiStep",
		at = @At(value = "INVOKE",
			target = "Lnet/minecraft/world/entity/monster/Zombie;customServerAiStep"
				+ "(Lnet/minecraft/server/level/ServerLevel;)V"))
	protected void mobTick(final ServerLevel world, final CallbackInfo ci)
	{
		final ZombifiedPiglin current = (ZombifiedPiglin)(Object)this;
		if(current.isAngry())
		{
			current.lastHurtByPlayerMemoryTime = current.tickCount;
		}
	}
	
	@Inject(method = "setTarget",
		at = @At(value = "INVOKE",
			target = "Lnet/minecraft/world/entity/monster/Zombie;setTarget(Lnet/minecraft/world/entity/LivingEntity;)"
				+ "V"))
	public void setTarget(final LivingEntity target, final CallbackInfo ci)
	{
		if(target instanceof final Player targetPlayer)
		{
			final ZombifiedPiglin current = (ZombifiedPiglin)(Object)this;
			current.setLastHurtByPlayer(targetPlayer, current.tickCount);
		}
	}
}
