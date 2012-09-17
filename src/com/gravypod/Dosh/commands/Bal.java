package com.gravypod.Dosh.commands;

import org.apache.commons.lang.WordUtils;

import com.gravypod.Dosh.CommandHandler;
import com.gravypod.Dosh.MoneyUtils;
import com.gravypod.Dosh.Settings;

public class Bal extends MoneyUtils {
	
	public Bal() {
	
		if (CommandHandler.args.length == 2) {
			CommandHandler.sender.sendMessage(WordUtils.capitalize(CommandHandler.args[1]) + " currently has " + Settings.moneySymbol + Float.toString(getUserBal(CommandHandler.args[1])) + " " + Settings.moneyName);
			return;
		}
		
		CommandHandler.sender.sendMessage("You currently have " + Settings.moneySymbol + Float.toString(getUserBal(CommandHandler.sender.getName())) + " " + Settings.moneyName);
		
	}
	
}
