package me.ellbristow.Itemizer;

import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Itemizer extends JavaPlugin {
	
	public static Itemizer plugin;
	
	@Override
	public void onDisable() {
	}
	
	@Override
	public void onEnable() {
	}
	
        @Override
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
		if ("DAMAGE_ALL".equals(ench)) {
			ench = "Sharpness";
		}
		else if ("DAMAGE_ARTHROPODS".equals(ench)) {
			ench = "Bane of Arthropods";
		}
		else if ("DAMAGE_UNDEAD".equals(ench)) {
			ench = "Smite";
		}
		else if ("DIG_SPEED".equals(ench)) {
			ench = "Efficiency";
		}
		else if ("DURABILITY".equals(ench)) {
			ench = "Unbreaking";
		}
		else if ("FIRE_ASPECT".equals(ench)) {
			ench = "Fire Aspect";
		}
		else if ("KNOCKBACK".equals(ench)) {
			ench = "Knockback";
		}
		else if ("LOOT_BONUS_BLOCKS".equals(ench)) {
			ench = "Fortune";
		}
		else if ("LOOT_BONUS_MOBS".equals(ench)) {
			ench = "Looting";
		}
		else if ("OXYGEN".equals(ench)) {
			ench = "Respiration";
		}
		else if ("PROTECTION_ENVIRONMENTAL".equals(ench)) {
			ench = "Protection";
		}
		else if ("PROTECTION_EXPLOSIONS".equals(ench)) {
			ench = "Blast Protection";
		}
		else if ("PROTECTION_FALL".equals(ench)) {
			ench = "Feather Falling";
		}
		else if ("PROTECTION_FIRE".equals(ench)) {
			ench = "Fire Protection";
		}
		else if ("PROTECTION_PROJECTILE".equals(ench)) {
			ench = "Projectile Protection";
		}
		else if ("SILK_TOUCH".equals(ench)) {
			ench = "Silk Touch";
		}
		else if ("WATER_WORKS".equals(ench)) {
			ench = "Aqua Affinity";
		}
                else if ("ARROW_DAMAGE".equals(ench)) {
			ench = "Power";
		}
                else if ("ARROW_FIRE".equals(ench)) {
			ench = "Flame";
		}
                else if ("ARROW_INFINITE".equals(ench)) {
			ench = "Infinity";
		}
                else if ("ARROW_KNOCKBACK".equals(ench)) {
			ench = "Punch";
		}
		return ench;
	}
	
}