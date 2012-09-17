package com.gravypod.Dosh.commands;

import org.apache.commons.lang.WordUtils;

import com.gravypod.Dosh.CommandHandler;
import com.gravypod.Dosh.Dosh;
import com.gravypod.Dosh.MoneyUtils;

public class Bal extends MoneyUtils {
	
	public Bal() {
	
		if (CommandHandler.args.length == 2) {
			CommandHandler.sender.sendMessage(WordUtils.capitalize(CommandHandler.args[1]) + " currently has " + Dosh.getSettings().moneySymbol + Float.toString(getUserBal(CommandHandler.args[1])) + " " + Dosh.getSettings().moneyName);
			return;
		}
		
		CommandHandler.sender.sendMessage("You currently have " + Dosh.getSettings().moneySymbol + Float.toString(getUserBal(CommandHandler.sender.getName())) + " " + Dosh.getSettings().moneyName);
		
	}
	
}
