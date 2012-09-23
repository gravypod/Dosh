package com.gravypod.Dosh;

import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public abstract class MoneyUtils {
	
	public static boolean payMoney(String sender, String receiver, Double amount) {
	
		if (!subtractMoney(sender, amount))
			return false;
		
		addUserBal(receiver, amount);
		return true;
		
	}
	
	public static boolean subtractMoney(String name, Double amount) {
	
		Double currentBal = getUserBal(name);
		Double afterSubtract = currentBal - amount;
		
		if (afterSubtract < 0F) {
			return false;
		}
		
		setUserBal(name, afterSubtract);
		
		return true;
		
	}
	
	public static void setUserBal(String name, Double amount) {
	
		Dosh.getSettings().moneyStore.set("users." + name, amount);
	}
	
	public static void addUserBal(String name, Double amount) {
	
		Dosh.getSettings().moneyStore.set("users." + name, Dosh.getSettings().moneyStore.getString("users." + name) + amount);
	}
	
	public static Double getUserBal(String name) {
	
		return Dosh.getSettings().moneyStore.getDouble("users." + name);
		
	}
	
	public static void makeAccount(String name) {
	
		if (!Dosh.getSettings().moneyStore.contains("user." + name))
			setUserBal(name, Dosh.getSettings().startingBal);
		
	}
	
	/**
	 * Match a player with a player name you give
	 * 
	 * @param name
	 * @return String of the Players name online or off-line
	 * 
	 */
	public static String matchPlayer(String name) {
	
		List<Player> players = Dosh.dosh.getServer().matchPlayer(name);
		
		switch (players.size()) {
		
			case 0:
				return matchOfflinePlayer(name);
			case 1:
				return ((Player) players.get(0)).getName();
				
			default:
				return null;
		}
		
	}
	
	public static Player matchName(String name) {
	
		return Dosh.dosh.getServer().getPlayer(name);
	}
	
	/**
	 * Matches an String to an off-line player
	 * 
	 * @param name
	 * @return player name or null if there is no player
	 * 
	 */
	public static String matchOfflinePlayer(String name) {
	
		for (OfflinePlayer player : Dosh.dosh.getServer().getOfflinePlayers())
			if (player.getName().equals(name))
				return player.getName();
		
		return null;
	}
	
}
