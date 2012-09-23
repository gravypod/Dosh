package com.gravypod.Dosh.commands;

import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

import com.gravypod.Dosh.CommandHandler;
import com.gravypod.Dosh.Dosh;
import com.gravypod.Dosh.MoneyUtils;

public class Bal extends MoneyUtils {
	
	public Bal() {
	
		try {
	
			if (CommandHandler.args.length == 2) {
				CommandHandler.sender.sendMessage(ChatColor.AQUA + WordUtils.capitalize(CommandHandler.args[1]) + " currently has " + Dosh.getSettings().moneySymbol + Double.toString(getUserBal(CommandHandler.args[1])) + " " + Dosh.getSettings().moneyName);
				return;
			}
			
			CommandHandler.sender.sendMessage(ChatColor.AQUA + "You currently have " + Dosh.getSettings().moneySymbol + getUserBal(CommandHandler.sender.getName()) + " " + Dosh.getSettings().moneyName);

		} catch (Exception e) {
			CommandHandler.sender.sendMessage(ChatColor.RED + "There was a problem with your command syntax");
		}
		
	}
	
}
