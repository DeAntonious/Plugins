package es.powdergamers.borunes;
 
import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
 
public final class BoRunes extends JavaPlugin {
	
	ArrayList<String> runeList = new ArrayList<String>();
	
	Location posRune;
	World runeWorld;
	int runeX;
	int runeY;
	int runeZ;
	
	ArrayList<String> runeName;
			
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.runeList.add(this.getConfig().getString("rune-list"));
        
        runeWorld = this.getServer().getWorld(getConfig().getString(runeName + ".world"));
        runeX = this.getConfig().getInt(runeName + ".location.posX");
        runeY = this.getConfig().getInt(runeName + ".location.posY");
        runeZ = this.getConfig().getInt(runeName + ".location.posZ");

        this.posRune = new Location(runeWorld, runeX, runeY, runeZ);
        
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	if (cmd.getName().equalsIgnoreCase("setrune")) {
        	if (sender instanceof Player) {
        		if (args.length > 0) {
        			
        			Player player = (Player) sender;
                    sender.sendMessage(ChatColor.GREEN + BoRunes.this.getConfig().getString("save-message") + " " + args[0]);
                    
                    //Añade la runa a la lista
                    this.runeList.add(args[0]);
                    this.getConfig().set("rune-list", this.runeList);
                    
                    String mundo = player.getWorld().getName();
                    this.getConfig().set(args[0] + ".world", mundo);
                    this.getConfig().set(args[0] + ".location.posX", player.getLocation().getBlockX());
                    this.getConfig().set(args[0] + ".location.posY", player.getLocation().getBlockY());
                    this.getConfig().set(args[0] + ".location.posZ", player.getLocation().getBlockZ());
                    
                    this.saveConfig();
                
                    return true;   
                
        		}
             
                return false;
        	} else {
                sender.sendMessage(ChatColor.RED + "Debes ser un jugador in-game para ejecutar este comando!"); 
 	
        	}		    	
        	return false;
    	}
		return false;

    }
    
    @EventHandler(priority=EventPriority.HIGH)
    public void onPlayerMoveEvent(PlayerMoveEvent event){
    	Player player = event.getPlayer();
    	
    	Location punto = new Location(player.getWorld(), 1, 1, 1);
    	
    	if(player.getLocation() > punto){
    	player.sendMessage("You are at the location.");
    	}
    }
    

}