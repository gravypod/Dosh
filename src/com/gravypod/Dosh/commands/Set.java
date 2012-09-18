package com.gravypod.Dosh.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.gravypod.Dosh.CommandHandler;
import com.gravypod.Dosh.MoneyUtils;

public class Set extends MoneyUtils {
	
	public Set() {
	
		Player setee = matchName(matchPlayer(CommandHandler.args[1]));
		
		if (setee == null) {
			CommandHandler.sender.sendMessage(ChatColor.RED + "There is not a player on with that name");
			return;
		}
		
		Float amount = Float.parseFloat(CommandHandler.args[2]);
		
		if (amount == null) {
			CommandHandler.sender.sendMessage(ChatColor.RED + "There is not a real money amount.");
			return;
		}
		
		setUserBal(setee.getName(), Float.parseFloat(CommandHandler.args[2]));
		CommandHandler.sender.sendMessage(ChatColor.AQUA + "Your have set " + setee.getName() + "'s balance to " + amount + "!");
		setee.sendMessage(ChatColor.AQUA + CommandHandler.sender.getName() + " has set your balance to " + amount + "!");
		
	}
	
}
