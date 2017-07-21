package com.elonxxiii.durability;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomDurability extends JavaPlugin {
	
	
	/**
	 * void onEnable(void)
	 * Registers the Listeners
	 */
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new DamageListener(), this);
		//getServer().getPluginManager().registerEvents(new RepairListener(), this);
		getLogger().info("CustomDurability enabled");
	}
	@Override
	public void onDisable() {
		getLogger().info("CustomDurability disabled");
	}
	

	
}
