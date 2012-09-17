package com.gravypod.Dosh.commands;

import java.io.IOException;

import com.gravypod.Dosh.CommandHandler;
import com.gravypod.Dosh.Settings;

public class Save {
	
	public Save() {
	
		try {
			Settings.moneyStore.save(Settings.moneyStoreFile);
		} catch (IOException e) {
			CommandHandler.sender.sendMessage("There was an error: " + e.toString());
		}
		
	}
	
}
