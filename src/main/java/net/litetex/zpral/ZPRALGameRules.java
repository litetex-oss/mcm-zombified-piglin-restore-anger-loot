package net.litetex.zpral;

import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRules;


public final class ZPRALGameRules
{
	public static final GameRule<Boolean> SPAWN_ZOMBIFIED_PIGLIN_ALWAYS_WITH_SWORD_ON_MAGMA_BLOCK =
		GameRules.registerBoolean(
			"spawn_zombified_piglin_always_with_sword_on_magma_block",
			GameRuleCategory.MOBS,
			false
		);
	
	public static void init()
	{
		// Just load the class and register the gamerule
	}
	
	private ZPRALGameRules()
	{
	}
}
