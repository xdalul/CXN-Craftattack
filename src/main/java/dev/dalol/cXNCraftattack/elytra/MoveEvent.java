package dev.dalol.cXNCraftattack.elytra;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.BoundingBox;

public class MoveEvent implements Listener {
    File pos = new File("Plugins//CraftAttack/CraftAttackElytraPositionen.yml");

    YamlConfiguration posi = YamlConfiguration.loadConfiguration(this.pos);

    double x1 = this.posi.getDouble("Pos1X.X");

    double y1 = this.posi.getDouble("Pos1Y.Y");

    double z1 = this.posi.getDouble("Pos1Z.Z");

    double x2 = this.posi.getDouble("Pos2X.X");

    double y2 = this.posi.getDouble("Pos2Y.Y");

    double z2 = this.posi.getDouble("Pos2Z.Z");

    public static List<Player> inzone = new ArrayList<>();

    public static List<Player> hately = new ArrayList<>();

    public static List<Player> outzone = new ArrayList<>();

    BoundingBox boxes = new BoundingBox(this.x1, this.y1, this.z1, this.x2, this.y2, this.z2);

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (this.boxes.contains(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ())) {
            GetElytra.getElytra(p);
        } else if (!this.boxes.contains(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ())) {
            if (!e.getPlayer().isGliding() &&
                    e.getPlayer().getInventory().getChestplate() != null &&
                    e.getPlayer().getInventory().getChestplate().getItemMeta().getDisplayName().equals("Einweg-Elytra")) {
                inzone.remove(p);
                p.getInventory().setChestplate(null);
                hately.remove(p);
                return;
            }
        }
    }
}
