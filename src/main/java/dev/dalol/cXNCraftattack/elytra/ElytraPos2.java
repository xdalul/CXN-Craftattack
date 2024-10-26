package dev.dalol.cXNCraftattack.elytra;

import java.io.File;
import java.io.IOException;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ElytraPos2 implements CommandExecutor {
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        Player p = (Player)cs;
        File Posi = new File("Plugins//CraftAttack/CraftAttackElytraPositionen.yml");
        YamlConfiguration pos2 = YamlConfiguration.loadConfiguration(Posi);
        if (args.length == 0) {
            pos2.set("Pos2X.X", Double.valueOf(p.getLocation().getX()));
            pos2.set("Pos2Y.Y", Double.valueOf(p.getLocation().getY() + 10.0D));
            pos2.set("Pos2Z.Z", Double.valueOf(p.getLocation().getZ()));
            try {
                pos2.save(Posi);
            } catch (IOException e) {
                e.printStackTrace();
            }
            p.sendMessage(ChatColor.GRAY + "Position 2 wurde gesetzt!");
            p.sendMessage(ChatColor.GRAY + "Der Server wurde dafür reloaded");
            Bukkit.getServer().reload();
        }
        return false;
    }
}
