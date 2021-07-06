package com.nerds.spigot;

import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotPlugin extends JavaPlugin implements CommandExecutor, Listener {

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}

	@Override
	public void onEnable() {
		getCommand("diamondz").setExecutor(this);
		getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
		if (sender instanceof Player) {
            Player player = (Player) sender;

            // Create a new ItemStack (type: diamond)
            ItemStack diamond = new ItemStack(Material.DIAMOND);

            // Set the amount of the ItemStack
            diamond.setAmount(64);

            // Give the player our items (comma-seperated list of all ItemStack)
            player.getInventory().addItem(diamond);
		}
		return true;
	}
	
	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent blockPlaceEvent) {
		blockPlaceEvent.getItemInHand().setAmount(64);
	}
}
