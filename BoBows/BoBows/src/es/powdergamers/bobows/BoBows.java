package es.powdergamers.bobows;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BoBows extends JavaPlugin implements Listener {
  public void onEnable()
  {
    getServer().getPluginManager().registerEvents(this, this);
    ItemStack witherBow = new ItemStack(Material.BOW);
    ItemMeta meta = witherBow.getItemMeta();
    List<String> loreData = new ArrayList();
    loreData.add("La furia de los Withers");
    meta.setDisplayName("Arco Wither");
    meta.setLore(loreData);
    witherBow.setItemMeta(meta);
    ShapelessRecipe recipe = new ShapelessRecipe(witherBow).addIngredient(Material.BOW).addIngredient(Material.NETHER_STAR);
    getServer().addRecipe(recipe);
  }
  
  public void onDisable()
  {
    getServer().clearRecipes();
  }
  
  @EventHandler
  public void onShoot(EntityShootBowEvent event)
  {
    if (((event.getEntity() instanceof Player)) && (event.getBow().hasItemMeta()) && (event.getBow().getItemMeta().getDisplayName().equals("Arco Wither")))
    {
      List<String> loreData = new ArrayList();
      loreData.add("La furia de los Withers");
      if ((event.getBow().getItemMeta().hasLore()) && (event.getBow().getItemMeta().getLore().equals(loreData)))
      {
        Player p = (Player)event.getEntity();
        if (p.hasPermission("witherbow.use"))
        {
          Arrow arrow = (Arrow)event.getProjectile();
          event.setCancelled(true);
          ((WitherSkull)p.launchProjectile(WitherSkull.class)).setVelocity(arrow.getVelocity());
        }
        else
        {
          p.sendMessage("No tienes fuerza para usar este arco..");
          event.setCancelled(true);
        }
      }
    }
  }
  
  @EventHandler
  public void onHit(EntityDamageByEntityEvent event)
  {
    Entity e1 = event.getEntity();
    Entity e2 = event.getDamager();
    if (((e1 instanceof Player)) && ((e2 instanceof WitherSkull)))
    {
      Player player = (Player)e1;
      player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 1));
    }
  }
  
  @EventHandler
  public void onCraftEvent(PrepareItemCraftEvent event)
  {
    Player p = (Player)event.getView().getPlayer();
    ItemStack witherBow = new ItemStack(Material.BOW);
    ItemMeta meta = witherBow.getItemMeta();
    List<String> loreData = new ArrayList();
    loreData.add("La furia de los Withers");
    meta.setDisplayName("Arco Wither");
    meta.setLore(loreData);
    witherBow.setItemMeta(meta);
    if ((event.getRecipe().getResult().equals(witherBow)) && (!p.hasPermission("witherbow.craft"))) {
      event.getInventory().setResult(null);
    }
  }
}
