package com.gmail.realtadukoo.TCh;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.realtadukoo.TCh.listeners.ChatPlayerListener;
import com.gmail.realtadukoo.TP.TP;

public class TCh extends JavaPlugin {
	public static TCh plugin;
	PluginDescriptionFile pdfFile = this.getDescription();
	public static FileConfiguration config;
	public boolean TPerms;
	public static TP TadukooPerms = null;
	
	@Override
	public void onDisable () {
		config = null;
	}
	@Override
	public void onEnable () {
		config = getConfig();
		this.getServer().getPluginManager().registerEvents(new ChatPlayerListener(this), this);
		
		if(this.getServer().getPluginManager().getPlugin("Tadukoo_Perms") != null){
			TPerms = true;
			TadukooPerms = (TP) this.getServer().getPluginManager().getPlugin("Tadukoo_Perms");
		}else{
			TPerms = false;
		}
	}
}
