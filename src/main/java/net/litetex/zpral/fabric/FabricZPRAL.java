package net.litetex.zpral.fabric;

import net.fabricmc.api.ModInitializer;
import net.litetex.zpral.ZPRALGameRules;


public class FabricZPRAL implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		ZPRALGameRules.init();
	}
}
