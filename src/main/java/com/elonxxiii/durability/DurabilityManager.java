package com.elonxxiii.durability;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class DurabilityManager {
	
	//CONSTANTS
	//constants for Lore
	int LORE_DURABILITY = 1;
    String STR_DURABILITY = "Durability: ";
	String STR_DELIMITER = " / ";
	//constants for integer placement here: durability: cur / max
    int CURRENT_DURABILITY = 0;
    int MAX_DURABILITY = 1;
	
    
	/**
	 * String getCustomDurability(ItemStack item)
	 * returns the String containing the CustomDurability
	 */
	public static String getDurabilityLore(ItemStack item) {
		
		//Check if Item even has Meta
		if(item.hasItemMeta()) {
			ItemMeta meta = item.getItemMeta();
			//Check if Item has Lore
			if(meta.hasLore()) {
				List<String> lore = meta.getLore();
				//Check if Item has custom durability
				
				for(int i = 0; i < lore.size(); i++){
					if(lore.get(i).contains(ChatColor.GRAY + "Durability:")) {
						Bukkit.getServer().getLogger().info("Contains dura lore!");
						//return the String with durability
						return lore.get(i);
					}
				}
				/**/
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
		if(lore == null){
		
		}
		List<Integer> dur = new ArrayList<Integer>();
		Matcher m = Pattern.compile("\\d+").matcher(lore);
		while(m.find())
			dur.add(Integer.parseInt(m.group()));
		
		return dur;
		
	}
	
	/**
	 * void setNewDurability(ItemStack item, int cur, int max)
	 * updates the durability in the lore
	 * item cannot be broken with this method
	 * updates the vanilla durability bar
	 */
	public void setNewDurability(ItemStack item, int cur, int max) {
		//check if item is nearly broken
		if(cur <= 1) {
			//set to last hit
			cur = 1;
			//next hit will break item
			item.setDurability((short) 1600);
		}

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
		int vanillaMax = item.getType().getMaxDurability();
		int vanillaCur = vanillaMax - (vanillaMax * cur / max);
		item.setDurability((short) vanillaCur);
		
		return;
	}
}
