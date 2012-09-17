package com.gravypod.Dosh;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigLoad {
	
	static Dosh plugin;
	
	static FileConfiguration cheapConfig;
	
	static File configFile;
	
	static File moneyStoreFile;

	static Settings settings;
	
	public ConfigLoad(Dosh _plugin, Settings _settings, File _configFile, File _moneyStore) {
		
		settings = _settings;
		plugin = _plugin;
		configFile = _configFile;
		moneyStoreFile = _moneyStore;
		loadData();
		
	}
	
	public static void loadData() {
	
		FileConfiguration cheapConfig = plugin.getConfig();
		
		try {
			
			cheapConfig.load(configFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			settings.moneyName = cheapConfig.getString("Dosh.MoneyName");
			settings.moneySymbol = cheapConfig.getString("Dosh.MoneySymbol");
			settings.startingBal = Float.parseFloat(cheapConfig.getString("Dosh.StartingBal"));
			
			try {
				cheapConfig.save(configFile);
			} catch (IOException e) {
			}
			
			
		}
		
		FileConfiguration moneyStore = new YamlConfiguration();
				
		try {
			
			moneyStore.load(moneyStoreFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			settings.moneyStoreFile = moneyStoreFile;
			settings.moneyStore = moneyStore;
			
		}
		
	}
	
}
