package com.gravypod.Dosh;

import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.*;

public class CommandHandler implements CommandExecutor {
	
	static Dosh plugin;
	
	public static CommandSender sender;
	public static Command command;
	public static String cmd;
	public static String[] args;
	
	public CommandHandler(Dosh _plugin) {
	
		plugin = _plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
	
		if (args.length < 1) {
			help(sender);
			return true;
		}
		
		String argument = WordUtils.capitalize(args[0].toLowerCase());
		
		if (!(sender.hasPermission("Dosh.commands." + argument) || sender.hasPermission("Dosh.admin") || sender.hasPermission("Dosh.user"))) {
			sender.sendMessage(ChatColor.RED + "You cannot use that command!");
			return true;
		}
		
		if (plugin.getCommands().contains(Dosh.classPath + argument + ".class")) {
			
			try {
				
				CommandHandler.sender = sender;
				CommandHandler.command = command;
				CommandHandler.cmd = cmd;
				CommandHandler.args = args;
				
				Class.forName(Dosh.classPath + argument).newInstance();
					
				return true;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			sender.sendMessage(ChatColor.RED + "");
			
			return true;
			
		}
		
		help(sender);
		
		return true;
		
	}
	
	public static void help(CommandSender sender) {
		
		sender.sendMessage(ChatColor.AQUA + "/money help - This :P");
		
		if (sender.hasPermission("Dosh.user")) {
			sender.sendMessage(ChatColor.AQUA + "/money pay {username} {amount} - Pay a user.");
			sender.sendMessage(ChatColor.AQUA + "/money bal - Get your own balance");
			sender.sendMessage(ChatColor.AQUA + "/money bal {username} - Get another players balance");
		}
		
		if (sender.hasPermission("Dosh.admin")) {
			sender.sendMessage(ChatColor.AQUA + "/money save - Save the money");
			sender.sendMessage(ChatColor.AQUA + "/money set {username} {amount} - Set money");
		}
		
	}
	
}