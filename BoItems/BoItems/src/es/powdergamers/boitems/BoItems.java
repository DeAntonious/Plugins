package es.powdergamers.boitems;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BoItems extends JavaPlugin implements Listener {

	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		ItemList.addItems();
	}
	
	@EventHandler
	public void onNextLevel(PlayerLevelChangeEvent event) {
		Player player = event.getPlayer();
		int totalXP = event.getNewLevel() - event.getOldLevel();
		if(totalXP > 1) {
			player.sendMessage("Pues has subido de nivel...");
		}
	}
}
