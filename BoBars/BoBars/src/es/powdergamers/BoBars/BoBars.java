package es.powdergamers.BoBars;

import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.nisovin.magicspells.MagicSpells;

public class BoBars extends JavaPlugin {

	int time = 5;

	public void onEnable() {
		Method();
	}

	public void onDisable() {
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("vermana")){ // If the player typed /basic then do the following...
			
			if (sender instanceof Player) {
				
				Player player = (Player) sender;
				
				//Player[] player = Bukkit.getOnlinePlayers();
				MagicSpells.getManaHandler().getMaxMana(player);

			    BarAPI.setMessage(player, ChatColor.BLUE + "Mana: " + MagicSpells.getManaHandler().getMaxMana(player), MagicSpells.getManaHandler().getMaxMana(player));
			
				return true;
			}
		}
		
		return false;
		
		
	}

	public void Method() {

		this.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					@Override
					public void run() {
						Method();
						Bukkit.broadcastMessage("Mensaje");
					}
				}, time * 20L);
	}
}
