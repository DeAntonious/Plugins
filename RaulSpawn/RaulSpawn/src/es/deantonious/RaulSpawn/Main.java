package es.deantonious.RaulSpawn;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
	public static Plugin BoSpawns;
   
  public void onEnable()
  {	
    getServer().getPluginManager().registerEvents(this, this); 
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onMobSpawn(CreatureSpawnEvent event)
  {
	    if (event.getEntityType() != EntityType.COW && event.getEntityType() != EntityType.ZOMBIE) {
	        event.setCancelled(true);
	      }
  }
}
