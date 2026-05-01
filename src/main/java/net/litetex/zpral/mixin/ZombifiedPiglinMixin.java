package net.litetex.zpral.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;


@Mixin(ZombifiedPiglin.class)
@SuppressWarnings("javabugs:S6320")
public abstract class ZombifiedPiglinMixin extends ZombieMixin
{
	@Inject(
		method = "customServerAiStep",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/entity/monster/zombie/Zombie;customServerAiStep"
				+ "(Lnet/minecraft/server/level/ServerLevel;)V"))
	protected void mobTick(final ServerLevel level, final CallbackInfo ci)
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
		final RandomSource random,
		final DifficultyInstance difficulty,
		final CallbackInfo ci)
	{
		final ZombifiedPiglin current = (ZombifiedPiglin)(Object)this;
		
		// This is the case when finalizeSpawn is called, e.g. when:
		// A) spawning normally
		// B) spawning during world generation (e.g. riding a strider)
		//
		// We need to get the correct ServerLevelAccessor here because when the world is generating (case B above)
		// current.level() is not yet ready to getBlockStates which causes a deadlock; see #170 for details
		final ServerLevelAccessor finalizeSpawnServerLevelAccessor = this.refFinalizeSpawnServerLevelAccessor.get();
		if(finalizeSpawnServerLevelAccessor != null)
		{
			this.maybeSpawnWithGoldSwordOnlyOnMagmaBlock(
				current,
				finalizeSpawnServerLevelAccessor.getLevel(),
				finalizeSpawnServerLevelAccessor,
				ci);
		}
		// In Vanilla this can only happen if a pig is struck by lightning
		else if(current.level() instanceof final ServerLevel currentServerLevel)
		{
			this.maybeSpawnWithGoldSwordOnlyOnMagmaBlock(
				current,
				currentServerLevel,
				currentServerLevel,
				ci);
		}
	}
	
	@Unique
	void maybeSpawnWithGoldSwordOnlyOnMagmaBlock(
		final ZombifiedPiglin current,
		final ServerLevel serverLevel,
		final BlockGetter blockGetter,
		final CallbackInfo ci)
	{
		if(serverLevel.getGameRules().get(ZPRALGameRules.SPAWN_ZOMBIFIED_PIGLIN_ALWAYS_WITH_SWORD_ON_MAGMA_BLOCK)
			&& blockGetter.getBlockState(current.blockPosition().below()).is(Blocks.MAGMA_BLOCK))
		{
			current.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
			ci.cancel();
		}
	}
}
