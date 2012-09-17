package com.gravypod.Dosh.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gravypod.Dosh.CommandHandler;
import com.gravypod.Dosh.MoneyUtils;
import com.gravypod.Dosh.Settings;

public class Pay extends MoneyUtils {
	
	public Pay() {
		
		if (!(CommandHandler.args.length == 3)) {
			CommandHandler.help(CommandHandler.sender);
			return;
		}
		
		Player toSend = matchName(CommandHandler.args[1]);
		Float amount = Float.parseFloat(CommandHandler.args[2]);
		CommandSender sender = CommandHandler.sender;
		
		if (payMoney(CommandHandler.sender.getName(), toSend.getName(), amount)) {
			
			sender.sendMessage("You have sent " + Settings.moneySymbol + amount + " " + Settings.moneyName + " to " + toSend.getName());
			toSend.sendMessage("You have recived " + Settings.moneySymbol + amount + " " + Settings.moneyName + " from " + sender.getName());
			
		}
	}
	
}
