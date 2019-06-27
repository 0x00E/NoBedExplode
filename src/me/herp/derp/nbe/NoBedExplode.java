package me.herp.derp.nbe;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginDescriptionFile;

public class NoBedExplode extends org.bukkit.plugin.java.JavaPlugin implements Listener {
	public NoBedExplode plugin;
	public final Logger logger = Logger.getLogger("Minecraft");

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled.");
	}

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		PluginDescriptionFile pdfFile = getDescription();
		this.logger.info(pdfFile.getName() + " has been enabled.");
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().toString().toLowerCase().contains("bed")) {

				Block block = e.getClickedBlock();
				if ((block.getLocation().getWorld().getName().contains("Nether"))
						|| (block.getLocation().getWorld().getName().contains("nether"))) {
					p.sendMessage(ChatColor.YELLOW + "§b[防爆]§c你不能在地狱睡觉.");
					e.setCancelled(true);
				} else if ((block.getLocation().getWorld().getName().contains("End"))
						|| (block.getLocation().getWorld().getName().contains("end"))) {
					p.sendMessage(ChatColor.YELLOW + "§b[防爆]§c你不能在末地睡觉.");
					e.setCancelled(true);
				}
			}
		}
	}
}
