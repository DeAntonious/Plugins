package es.powdergamers.BoDrinks;
 
import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
 
public final class BoDrinks extends JavaPlugin implements Listener {
 
	ItemStack Aguamiel;
	ItemStack Cerveza;
	ItemStack Grabebida;
	
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(this, this);
		addItems();     
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("aguamiel")) {

			if (sender instanceof Player) {
				Player player = (Player) sender;

					PlayerInventory inventory = player.getInventory();
					ItemStack aguamielBebida = new ItemStack(Aguamiel);
					inventory.addItem(aguamielBebida);		

			} else {

				sender.sendMessage("Este comando solo es ejecutable por un jugador!");

				return false;
			}
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("cerveza")) {

			if (sender instanceof Player) {
				Player player = (Player) sender;

					PlayerInventory inventory = player.getInventory();
					ItemStack cervezaBebida = new ItemStack(Cerveza);
					inventory.addItem(cervezaBebida);		

			} else {

				sender.sendMessage("Este comando solo es ejecutable por un jugador!");

				return false;
			}
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("grabebida")) {

			if (sender instanceof Player) {
				Player player = (Player) sender;

					PlayerInventory inventory = player.getInventory();
					ItemStack grabebidaBebida = new ItemStack(Grabebida);
					inventory.addItem(grabebidaBebida);		

			} else {

				sender.sendMessage("Este comando solo es ejecutable por un jugador!");

				return false;
			}
			return true;
		}
		
		return false;
	}

	@EventHandler
	  public void onDrink(PlayerItemConsumeEvent event)
	  {			
			
	    if (event.getItem().getType() == Material.POTION)
	    {
		    if (event.getItem().hasItemMeta()) {
			    if (event.getItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Aguamiel"))
			    {
				    event.setCancelled(true);

				    ItemStack item = event.getPlayer().getItemInHand();
				    if (item.getAmount() > 1)
				      item.setAmount(item.getAmount() - 1);
				    else {
				      event.getPlayer().setItemInHand(null);
				    }
				    
				    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 500, 2));
				    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 2));
				    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 1));
			    }
			    
			    if (event.getItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Cerveza"))
			    {
				    event.setCancelled(true);

				    ItemStack item = event.getPlayer().getItemInHand();
				    if (item.getAmount() > 1)
				      item.setAmount(item.getAmount() - 1);
				    else {
				      event.getPlayer().setItemInHand(null);
				    }
				    
				    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 2));
				    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 600, 1));
			    }
			    
			    if (event.getItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GRAY + "Grabebida"))
			    {
				    event.setCancelled(true);

				    ItemStack item = event.getPlayer().getItemInHand();
				    if (item.getAmount() > 1)
				      item.setAmount(item.getAmount() - 1);
				    else {
				      event.getPlayer().setItemInHand(null);
				    }
				    
				    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 800, 4));
				    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 800, 100));
			    }
			    
		    }
	    }

	  
	  }
	
	
	private void addItems() {
		
		//Aguamiel-----------------------------------------------------------------------------------------------
		Potion AguamielPotion = new Potion(PotionType.FIRE_RESISTANCE);
		Aguamiel = AguamielPotion.toItemStack(1);
		PotionMeta AguamielMeta = (PotionMeta) Aguamiel.getItemMeta();
		AguamielMeta.setDisplayName(ChatColor.YELLOW + "Aguamiel");
		
		ArrayList<String> AguamielLore = new ArrayList<String>();
		AguamielLore.add(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + ChatColor.BOLD + "==================");
		AguamielLore.add(ChatColor.GRAY + "Bebida alcoholica");
		AguamielLore.add(ChatColor.GRAY + "refrescante que te");
		AguamielLore.add(ChatColor.GRAY + "ayuda a defenderte.");
		
        AguamielMeta.setLore(AguamielLore);		
		Aguamiel.setItemMeta(AguamielMeta);
		
		//Receta Aguamiel
		ShapelessRecipe AguamielReceta = new ShapelessRecipe(new ItemStack(Aguamiel));
        AguamielReceta.addIngredient(Material.GLOWSTONE_DUST);
        AguamielReceta.addIngredient(Material.SUGAR);
        AguamielReceta.addIngredient(Material.POTION);
        
        getServer().addRecipe(AguamielReceta);
        
        
		//Cerveza-------------------------------------------------------------------------------------------------
		Potion CervezaPotion = new Potion(PotionType.STRENGTH);
		Cerveza = CervezaPotion.toItemStack(1);
		PotionMeta CervezaMeta = (PotionMeta) Cerveza.getItemMeta();
		CervezaMeta.setDisplayName(ChatColor.RED + "Cerveza");
		
		ArrayList<String> CervezaLore = new ArrayList<String>();
		CervezaLore.add(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + ChatColor.BOLD + "==================");
		CervezaLore.add(ChatColor.GRAY + "Bebida alcoholica");
		CervezaLore.add(ChatColor.GRAY + "que te da un gran");
		CervezaLore.add(ChatColor.GRAY + "aumento de fuerza.");
		
		CervezaMeta.setLore(CervezaLore);		
        Cerveza.setItemMeta(CervezaMeta);
		
		//Receta Cerveza
		ShapelessRecipe CervezaReceta = new ShapelessRecipe(new ItemStack(Cerveza));
		CervezaReceta.addIngredient(Material.SUGAR);
		CervezaReceta.addIngredient(Material.WHEAT);
		CervezaReceta.addIngredient(Material.POTION);
        
        getServer().addRecipe(CervezaReceta);
        
        
		//Grabebida-------------------------------------------------------------------------------------------------
		Potion GrabebidaPotion = new Potion(PotionType.SPEED);
		Grabebida = GrabebidaPotion.toItemStack(1);
		PotionMeta GrabebidaMeta = (PotionMeta) Grabebida.getItemMeta();
		GrabebidaMeta.setDisplayName(ChatColor.DARK_GRAY + "Grabebida");
		
		ArrayList<String> GrabebidaLore = new ArrayList<String>();
		GrabebidaLore.add(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + ChatColor.BOLD + "==================");
		GrabebidaLore.add(ChatColor.GRAY + "Bebida mágica que");
		GrabebidaLore.add(ChatColor.GRAY + "disminuye tu gravedad.");
		
		GrabebidaMeta.setLore(GrabebidaLore);		
		Grabebida.setItemMeta(GrabebidaMeta);
		
		//Receta Cerveza
		ShapelessRecipe GrabebidaReceta = new ShapelessRecipe(new ItemStack(Grabebida));
		GrabebidaReceta.addIngredient(Material.SUGAR);
		GrabebidaReceta.addIngredient(Material.MAGMA_CREAM);
		GrabebidaReceta.addIngredient(Material.POTION);
        
        getServer().addRecipe(GrabebidaReceta);

	}

}