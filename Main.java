package Aukarapol;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.player.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents((Listener) new PlayerD(), this);
        pm.registerEvents((Listener) new PlayerIC(), this);
    }

    @Override
    public void onDisable() {
        this.getServer().getPluginManager().disablePlugins();
    }

    public class PlayerD implements Listener {
        @EventHandler(priority = EventPriority.NORMAL)
        public void onDrop(PlayerDropItemEvent event) {
            Player p = event.getPlayer();

            int dropAmount = event.getItemDrop().getItemStack().getAmount();
            String dropName = event.getItemDrop().getItemStack().getItemMeta().getDisplayName();

            if (event.getItemDrop() == p.getWorld()) {

                if (event.getItemDrop().getPickupDelay() == 0) {
                    event.getPlayer().sendMessage("Your drop " + dropName + " amount " + dropAmount);
                }
            } else {
                event.getItemDrop().setPickupDelay(0);
            }

        }

    }

    public class PlayerIC implements Listener {
        @EventHandler
        public void PIC(PlayerInteractEntityEvent event) {
            Player p = event.getPlayer();
            Player rc = (Player) event.getRightClicked();

            if (rc instanceof Player) {
                if (rc.isSneaking()) {
                    rc.sendMessage(
                            ChatColor.DARK_GREEN + "Player: " + rc.getDisplayName() +
                                    ChatColor.YELLOW + "\n" + "Level: " + rc.getLevel() +
                                    ChatColor.GRAY + "\n" + "Exp: " + rc.getExp() +
                                    ChatColor.GREEN + "\n" + "Health: " + rc.getHealthScale() +
                                    ChatColor.RED + "\n" + "Gamemode: " + rc.getGameMode() +
                                    ChatColor.DARK_PURPLE + "\n" + "Item existing: " + rc.getCanPickupItems() +
                                    ChatColor.DARK_BLUE + "\n" + "Location: " + rc.getLocation()
                    );
                }
            }

        }

    }
}