package com.gravypod.Dosh;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BankCommands implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
	
		if (!sender.hasPermission("Dosh.banks")) {
			sender.sendMessage(ChatColor.RED + "You cannot use this command");
			return true;
		}
		
		return false;
	}
	
}
