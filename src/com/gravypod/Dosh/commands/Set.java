package com.gravypod.Dosh.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.gravypod.Dosh.CommandHandler;
import com.gravypod.Dosh.MoneyUtils;

public class Set extends MoneyUtils {
	
	
	public Set() {
		
		Player setee = matchName(matchPlayer(CommandHandler.args[1]));
		setUserBal(setee.getName(), Float.parseFloat(CommandHandler.args[2]));
		CommandHandler.sender.sendMessage(ChatColor.AQUA + "Your have set " + CommandHandler.args[1] + " to " + Float.parseFloat(CommandHandler.args[2]) + "!");
		setee.sendMessage(CommandHandler.sender.getName() + " has set your balance to " + Float.parseFloat(CommandHandler.args[2]) + "!");

	}
	
}
