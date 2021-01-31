package main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	//Welcome to my first tutorial! In this, I will be showing you how to create a simple Join & Leave
	//for Minecraft if you are a newbie at coding. First, we have to setup our onEnable() and onDisable() 
	//for when the server starts/stops
	
	@Override
	public void onEnable() {
		getLogger().info("[Join & Leave] has been enabled!"); //Outputs to the console when the plugin has started up on server startup
	}
	
	@Override
	public void onDisable() {
		getLogger().info("[Join & Leave] has been disabled!"); //Outputs to the console when the plugin has stopped when server stops
	}
	
	//Now, we want to register a new event handler called a PlayerJoinEvent which is an event handled when a player joins the server
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer(); //This gets the player who joins the server
		
		e.setJoinMessage("" + ChatColor.BOLD + "> " + ChatColor.RESET + ChatColor.YELLOW + player.getName() + 
				ChatColor.AQUA + "has joined!"); //This sets the join message for when a player joins
		
		//If you want a bit more, you can set a MOTD for when the player joins with the following:
		
		player.sendMessage("" + ChatColor.DARK_GREEN + "Welcome to your server!");
		player.sendMessage("" + ChatColor.DARK_GREEN + "Configure this message in this plugin!");
	}
	
	//Now with the PlayerJoinEvent out of the way, lets now do the exact same thing for the PlayerQuitEvent
	
	@EventHandler
	public void PlayerQuit(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		
		e.setQuitMessage("" + ChatColor.BOLD + "> " + ChatColor.RESET + ChatColor.YELLOW + player.getName() + 
				ChatColor.AQUA + "has left!"); //This sets the leave message for when a player leaves
	}
	
	
}
