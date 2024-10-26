package dev.dalol.cXNCraftattack.elytra;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GetElytra {
    public static void getElytra(Player player) {
        if (!MoveEvent.inzone.contains(player) &&
                player.getInventory().getChestplate() == null) {
            ItemStack Elytra = new ItemStack(Material.ELYTRA);
            ItemMeta Elytra_meta = Elytra.getItemMeta();
            Elytra_meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
            Elytra_meta.setDisplayName("Einweg-Elytra");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("");
            Elytra_meta.setLore(lore);
            Elytra.setItemMeta(Elytra_meta);
            player.getInventory().setChestplate(Elytra);
            MoveEvent.inzone.add(player);
            MoveEvent.hately.add(player);
        }
    }
}
