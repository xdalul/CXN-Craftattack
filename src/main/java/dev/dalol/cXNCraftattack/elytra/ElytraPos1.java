package dev.dalol.cXNCraftattack.elytra;

import java.io.File;
import java.io.IOException;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ElytraPos1 implements CommandExecutor {
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        Player p = (Player)cs;
        File Posi = new File("Plugins//CraftAttack/CraftAttackElytraPositionen.yml");
        YamlConfiguration pos1 = YamlConfiguration.loadConfiguration(Posi);
        if (args.length == 0) {
            pos1.set("Pos1X.X", Double.valueOf(p.getLocation().getX()));
            pos1.set("Pos1Y.Y", Double.valueOf(p.getLocation().getY()));
            pos1.set("Pos1Z.Z", Double.valueOf(p.getLocation().getZ()));
            try {
                pos1.save(Posi);
            } catch (IOException e) {
                e.printStackTrace();
            }
            p.sendMessage(ChatColor.GRAY + "Position 1 wurde gesetzt!");
        }
        return false;
    }
}
