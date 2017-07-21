package com.elonxxiii.durability;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;


public class CustomDurability extends JavaPlugin {

	//constants
	//config file for customizing would be nice
	//constants for Lore
	final int LORE_DURABILITY = 1;
	final String STR_DURABILITY = "Durability: ";
	final String STR_DELIMITER = " / ";
	//constants for integer placement here: durability: cur / max
	final int CURRENT_DURABILITY = 0;
	final int MAX_DURABILITY = 1;
	
	
	/**
	 * void onEnable(void)
	 * Registers the Listeners
	 */
	public void onEnable() {//
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
	public String getCustomDurability(ItemStack item) {
			
		//Check if Item even has Meta
		if(item.hasItemMeta()) {
			ItemMeta meta = item.getItemMeta();
			//Check if Item has Lore
			if(meta.hasLore()) {
				List<String> lore = meta.getLore();
				//Check if Item has custom durability
				if(lore.get(LORE_DURABILITY).contains("Durability")) {
					//return the String with durability
					return lore.get(LORE_DURABILITY);
				}
			}
		}
		return null;
	}
	
	
	/**
	 * List<Integer> getDurability(String lore)
	 * returns the current and maximum durability
	 * Lore: Durability: 23/42
	 * dur[0] = 23 = dur[CURRENT_DURABILITY]
	 * dur[1] = 42 = dur[MAX_DURABILITY]
	 */
	public List<Integer> getDurability(String lore) {
		
		List<Integer> dur = new ArrayList<Integer>();
		Matcher m = Pattern.compile("//d+").matcher(lore);
		while(m.find())
			dur.add(Integer.parseInt(m.group()));
		
		return dur;
		
	}
	
	/**
	 * void setNewDurability(ItemStack item, int cur, int max)
	 * updates the durability in the lore
	 * to do:
	 * also breaks the item
	 * also updates the vanilla durability bar
	 */
	public void setNewDurability(ItemStack item, int cur, int max) {
		//check if item broke
		if(cur >= 0) {
			//break the item
			item.setDurability((short) 0);
		}
		else {
			//create String with new values for durability
			String newdur = STR_DURABILITY + Integer.toString(cur) + STR_DELIMITER + Integer.toString(max);	
			ItemMeta meta = item.getItemMeta();
			//get all the lore
			List<String> newlore = meta.getLore();
			//overwrite the durability-row
			newlore.set(LORE_DURABILITY, newdur);
			//set the new lore
			meta.setLore(newlore);
			
			//update the vanilla durability bar
		}
		return;
	}
}
