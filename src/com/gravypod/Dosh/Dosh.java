package com.gravypod.Dosh;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import com.gravypod.Dosh.Listeners.PlayerListener;

public class Dosh extends JavaPlugin {
	
	private List<String> commands;
	
	ConfigHandle configHandle;
	
	static Dosh dosh;
	
	private static Settings settings;
	
	public static String classPath = "com.gravypod.Dosh.commands.";
	
	@Override
	public void onEnable() {
		
		dosh = this;
		
		setSettings(new Settings());
		
		setCommands(ListClasses.getClasseNamesInPackage(this.getFile().getAbsolutePath(), "com.gravypod.Dosh.commands."));
		
		configHandle = new ConfigHandle(this, settings);
		
		getCommand("money").setExecutor(new CommandHandler(this));
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		
	}
	
	@Override
	public void onDisable() {
	
		try {
			settings.moneyStore.save(settings.moneyStoreFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Taken from groupmanager
	 * 
	 * @param fileName
	 * @return
	 */
	public InputStream getResourceAsStream(String fileName) {
	
		return this.getClassLoader().getResourceAsStream(fileName);
	}
	
	public List<String> getCommands() {
	
		return commands;
	}
	
	private void setCommands(List<String> commands) {
	
		this.commands = commands;
	}

	/**
	 * @return the settings
	 */
	public static Settings getSettings() {
	
		return settings;
	}

	/**
	 * @param settings the settings to set
	 */
	public void setSettings(Settings settings) {
	
		Dosh.settings = settings;
	}
	
}
