package com.elonxxiii.durability;

import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;

public class DamageListener extends CustomDurability implements Listener {

	@EventHandler
	public void onItemDamage(PlayerItemDamageEvent event) {
		if(!(event.isCancelled()))
		{
			ItemStack item =  event.getItem();
			String lore = getCustomDurability(item);
			
			if(lore != null) {
				List<Integer> dur = getDurability(lore);
				int cur = dur.get(CURRENT_DURABILITY);
				int max = dur.get(MAX_DURABILITY);
				setNewDurability(item, cur-event.getDamage(), max);
			}
		}
	}
}

