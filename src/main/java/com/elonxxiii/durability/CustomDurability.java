package com.elonxxiii.durability;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;


public class CustomDurability extends JavaPlugin {
	
	
	/**
	 * void onEnable(void)
	 * Registers the Listeners
	 */
	public void onEnable() {
		//getServer().getPluginManager().registerEvents(new DamageListener(), this);
		//getServer().getPluginManager().registerEvents(new RepairListener(), this);
		getLogger().info("CustomDurability enabled");
	}
	
	public void onDisable() {
		getLogger().info("CustomDurability disabled");
	}
	
	/**
	 * String getCustomDurability(ItemStack item)
	 * returns the String containing the CustomDurability
	 */
	
}
