package net.litetex.zpral.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;

import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.ServerLevelAccessor;


@Mixin(Zombie.class)
public abstract class ZombieMixin
{
	@Unique
	protected ScopedValue<ServerLevelAccessor> refFinalizeSpawnServerLevelAccessor = ScopedValue.newInstance();
	
	@WrapMethod(method = "finalizeSpawn")
	public SpawnGroupData finalizeSpawn(
		final ServerLevelAccessor level,
		final DifficultyInstance difficulty,
		final EntitySpawnReason spawnReason,
		final SpawnGroupData groupData,
		final Operation<SpawnGroupData> original)
	{
		return ScopedValue.where(this.refFinalizeSpawnServerLevelAccessor, level)
			.call(() -> original.call(level, difficulty, spawnReason, groupData));
	}
}
