package com.gravypod.Dosh.commands;

import java.io.IOException;

import org.bukkit.ChatColor;

import com.gravypod.Dosh.CommandHandler;
import com.gravypod.Dosh.Dosh;

public class Save {
	
	public Save() {
	
		try {
			
			Dosh.getSettings().moneyStore.save(Dosh.getSettings().moneyStoreFile);
			CommandHandler.sender.sendMessage(ChatColor.AQUA + "You have saved the money file");
			
		} catch (IOException e) {
			CommandHandler.sender.sendMessage(ChatColor.AQUA + "There was an error: " + e.toString());
		}
		
	}
	
}
