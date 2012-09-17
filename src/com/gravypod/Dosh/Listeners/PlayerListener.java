package com.gravypod.Dosh.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.gravypod.Dosh.CreateAccount;

public class PlayerListener implements Listener {
	
	@EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
	public static void loginEvent(PlayerLoginEvent event) {
	
		CreateAccount.createAccount(event.getPlayer().getName());
		
	}
	
}
