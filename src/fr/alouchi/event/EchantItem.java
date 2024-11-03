package fr.alouchi.event;

import fr.alouchi.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class EchantItem implements Listener {

    @EventHandler
    public void onEnchantItem(EnchantItemEvent event) {
        ItemStack item = event.getItem();
        Player player = event.getEnchanter();

        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            limitEnchantments(item, player);
        }, 1L);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getType() == InventoryType.ANVIL && event.getSlotType() == InventoryType.SlotType.RESULT) {
            ItemStack result = event.getCurrentItem();
            if (result != null) {
                limitEnchantments(result, (Player) event.getWhoClicked());
            }
        }
    }

    private void limitEnchantments(ItemStack item, Player player) {
        if (item.getType() == Material.DIAMOND_HELMET || item.getType() == Material.DIAMOND_CHESTPLATE ||
                item.getType() == Material.DIAMOND_LEGGINGS || item.getType() == Material.DIAMOND_BOOTS) {

            if (item.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) > 3) {
                item.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                if (player != null) player.sendMessage("§cLa protection maximale pour les armures en diamant est de niveau 3.");
            }
        }

        if (item.getType() == Material.IRON_HELMET || item.getType() == Material.IRON_CHESTPLATE ||
                item.getType() == Material.IRON_LEGGINGS || item.getType() == Material.IRON_BOOTS) {

            if (item.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) > 4) {
                item.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                if (player != null) player.sendMessage("§cLa protection maximale pour les armures en fer est de niveau 4.");
            }
        }

        if (item.getType() == Material.DIAMOND_SWORD) {
            if (item.getEnchantmentLevel(Enchantment.DAMAGE_ALL) > 4) {
                item.addEnchantment(Enchantment.DAMAGE_ALL, 4);
                if (player != null) player.sendMessage("§cL'enchantement Tranchant maximal pour les épées en diamant est de niveau 4.");
            }
        }

        if (item.getType() == Material.IRON_SWORD) {
            if (item.getEnchantmentLevel(Enchantment.DAMAGE_ALL) > 5) {
                item.addEnchantment(Enchantment.DAMAGE_ALL, 5);
                if (player != null) player.sendMessage("§cL'enchantement Tranchant maximal pour les épées en fer est de niveau 5.");
            }
        }

        if (item.containsEnchantment(Enchantment.FIRE_ASPECT)) {
            item.removeEnchantment(Enchantment.FIRE_ASPECT);
            if (player != null) player.sendMessage("§cL'enchantement Fire Aspect est désactivé.");
        }
        if (item.containsEnchantment(Enchantment.ARROW_FIRE)) {
            item.removeEnchantment(Enchantment.ARROW_FIRE);
            if (player != null) player.sendMessage("§cL'enchantement Flame est désactivé.");
        }
        if (item.containsEnchantment(Enchantment.ARROW_KNOCKBACK)) {
            item.removeEnchantment(Enchantment.ARROW_KNOCKBACK);
            if (player != null) player.sendMessage("§cL'enchantement Punch est désactivé.");
        }
        if (item.getEnchantmentLevel(Enchantment.KNOCKBACK) > 1) {
            item.addEnchantment(Enchantment.KNOCKBACK, 1);
            if (player != null) player.sendMessage("§cL'enchantement Knockback est limité au niveau 1.");
        }
    }
}