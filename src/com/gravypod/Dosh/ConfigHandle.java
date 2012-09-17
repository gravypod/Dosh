package com.gravypod.Dosh;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class ConfigHandle {

	
	private final File configFile;
	private final File moneyStore;

	public ConfigHandle(Dosh plugin, Settings settings) {
		
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdirs();
		}
		
		configFile = new File(plugin.getDataFolder(), "config.yml");
		
		moneyStore = new File(plugin.getDataFolder(), "moneystore.yml");

		if (!configFile.exists()) {
			try {
				copy(plugin.getResourceAsStream("config.yml"), configFile);
				copy(plugin.getResourceAsStream("moneystore.yml"), moneyStore);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		new ConfigLoad(plugin, settings, configFile, moneyStore);
		
	}
	
	/**
	 * Taken from groupmanager
	 * @param src
	 * @param dst
	 * @throws IOException
	 */
	public static void copy(InputStream src, File dst) throws IOException {

		InputStream in = src;
		OutputStream out = new FileOutputStream(dst);

		// Transfer bytes from in to out
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		out.close();
		try {
			in.close();
		} catch (Exception e) {
		}
	}
	
	
}
