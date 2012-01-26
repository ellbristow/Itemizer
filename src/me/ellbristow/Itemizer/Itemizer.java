package me.ellbristow.Itemizer;

import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Itemizer extends JavaPlugin {
	
	public static Itemizer plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[" + pdfFile.getName() + "] is now disabled.");
	}
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[" + pdfFile.getName() + "] version " + pdfFile.getVersion() + " is enabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args ) {
		if (sender instanceof Player) {
			Boolean comreturn = readCommand((Player) sender, commandLabel, args);
			return comreturn;
		}
		else {
			sender.sendMessage("This command cannot be run from the console!");
			return true;
		}
	}
	
	public Boolean readCommand(Player player, String command, String[] args) {
		if(command.equalsIgnoreCase("whatis")) {
			ItemStack helditem = player.getItemInHand();
			String damage = "";
			if (helditem.getDurability() != 0) {
				damage = ChatColor.GOLD + ":" + ChatColor.WHITE + helditem.getDurability();
			}
			player.sendMessage(ChatColor.GOLD + "You are holding " + ChatColor.WHITE + helditem.getAmount() + ChatColor.GOLD + " of :");
			player.sendMessage(ChatColor.GOLD + " Item ID : " + ChatColor.WHITE + helditem.getTypeId() + damage);
			player.sendMessage(ChatColor.GOLD + " Item Name : " + ChatColor.WHITE + helditem.getType());
			if (!helditem.getEnchantments().isEmpty()) {
				player.sendMessage(ChatColor.GOLD + " Enchantments : ");
				Map<Enchantment, Integer> enchantments = helditem.getEnchantments();
				for (int i = 0; i<enchantments.size(); i++) {
					Object[] enchSet = enchantments.keySet().toArray();
					Object[] enchValues = enchantments.values().toArray();
					String ench = getEnchName(enchSet[i].toString().split(",")[1].replace("]", "").trim());
					player.sendMessage("  " + ench + ChatColor.GOLD + " Level : " + ChatColor.WHITE + enchValues[i]);
				}
			}
			return true;
		}
		return false;
	}
	
	public String getEnchName(String ench) {
		if (ench == "DAMAGE_ALL") {
			ench = "Sharpness";
		}
		else if (ench == "DAMAGE_ARTHROPODS") {
			ench = "Bane of Arthropods";
		}
		else if (ench == "DAMAGE_UNDEAD") {
			ench = "Smite";
		}
		else if (ench == "DIG_SPEED") {
			ench = "Efficiency";
		}
		else if (ench == "DURABILITY") {
			ench = "Unbreaking";
		}
		else if (ench == "FIRE_ASPECT") {
			ench = "Fire Aspect";
		}
		else if (ench == "KNOCKBACK") {
			ench = "Knockback";
		}
		else if (ench == "LOOT_BONUS_BLOCKS") {
			ench = "Fortune";
		}
		else if (ench == "LOOT_BONUS_MOBS") {
			ench = "Looting";
		}
		else if (ench == "OXYGEN") {
			ench = "Respiration";
		}
		else if (ench == "PROTECTION_ENVIRONMENTAL") {
			ench = "Protection";
		}
		else if (ench == "PROTECTION_EXPLOSIONS") {
			ench = "Blast Protection";
		}
		else if (ench == "PROTECTION_FALL") {
			ench = "Feather Falling";
		}
		else if (ench == "PROTECTION_FIRE") {
			ench = "Fire Protection";
		}
		else if (ench == "PROTECTION_PROJECTILE") {
			ench = "Projectile Protection";
		}
		else if (ench == "SILK_TOUCH") {
			ench = "Silk Touch";
		}
		else if (ench == "WATER_WORKS") {
			ench = "Aqua Affinity";
		}
		return ench;
	}
	
}