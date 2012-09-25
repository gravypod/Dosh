package com.gravypod.Dosh.commands;

import java.io.File;
import java.util.Scanner;

import org.bukkit.ChatColor;

import com.gravypod.Dosh.CommandHandler;
import com.gravypod.Dosh.MoneyUtils;

public class Convert extends MoneyUtils {
	
	public Convert() {
	
		if (CommandHandler.sender.isOp()) {
			
			if (CommandHandler.args.length == 2) {
				
				if (CommandHandler.args[1].toLowerCase().startsWith("ico")) {
					
					try {
						
						Scanner s = new Scanner(new File("plugins//iConomy//accounts.mini"));
						
						String reading = s.nextLine();
						String[] data;

						while (reading != null) {
							
							data = reading.split(" ");
							
							if (data.length == 3)
								setUserBal(data[0], Double.parseDouble(data[1].replace("balance:", "")));
							
							if (s.hasNext())
								reading = s.nextLine();
							else 
								break;
							
						}
						
					} catch (Exception e) {
						e.printStackTrace();
						CommandHandler.sender.sendMessage(ChatColor.RED + "There was an error with your command");
					}
					
					return;
					
				}
				
				CommandHandler.sender.sendMessage(ChatColor.RED + "We do not support the economy plugin " + CommandHandler.args[1] + "!");
				
			} else {
				
				CommandHandler.sender.sendMessage(ChatColor.RED + "You did not use that command correctly!");
				
			}
			
			return;
			
		}
		
		CommandHandler.sender.sendMessage(ChatColor.RED + "You do not have permission so use that command!");
		
	}
	
}
