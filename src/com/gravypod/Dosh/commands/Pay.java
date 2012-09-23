package com.gravypod.Dosh.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gravypod.Dosh.CommandHandler;
import com.gravypod.Dosh.Dosh;
import com.gravypod.Dosh.MoneyUtils;

public class Pay extends MoneyUtils {
	
	public Pay() {
	
		try {
			if (!(CommandHandler.args.length == 3)) {
				CommandHandler.help(CommandHandler.sender);
				return;
			}
			
			Player toSend = matchName(matchPlayer(CommandHandler.args[1]));
			Double amount = Double.parseDouble(CommandHandler.args[2]);
			CommandSender sender = CommandHandler.sender;
			
			if (toSend == null) {
				CommandHandler.sender.sendMessage(ChatColor.RED + "There is not a player on with that name.");
				return;
			}
			
			if (amount == null) {
				CommandHandler.sender.sendMessage(ChatColor.RED + "There is not a real money amount.");
				return;
			}
			
			if (payMoney(CommandHandler.sender.getName(), toSend.getName(), amount)) {
				
				sender.sendMessage(ChatColor.AQUA + "You have sent " + Dosh.getSettings().moneySymbol + amount + " " + Dosh.getSettings().moneyName + " to " + toSend.getName());
				toSend.sendMessage(ChatColor.AQUA + "You have recived " + Dosh.getSettings().moneySymbol + amount + " " + Dosh.getSettings().moneyName + " from " + sender.getName());
				
			}
			
		} catch (Exception e) {
			CommandHandler.sender.sendMessage(ChatColor.RED + "There was a problem with your command syntax");
		}
	}
	
}
