package es.powdergamers.boitems;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemList {
	
	public static void addItems() {
  	  
		ItemStack perlaOscura = new ItemStack(Material.BONE, 1);  	  
		ItemMeta perlaOscuraMeta = perlaOscura.getItemMeta();  	  
		
		perlaOscuraMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_GRAY + "Perla Oscura");  	  
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(" "); 	  
		lore.add(ChatColor.RESET + "Si, los Zombies tienen"); 	  
		lore.add(ChatColor.RESET + "huesos...");  
		
		perlaOscuraMeta.setLore(lore);  
		perlaOscura.setItemMeta(perlaOscuraMeta);
		
	}

}
