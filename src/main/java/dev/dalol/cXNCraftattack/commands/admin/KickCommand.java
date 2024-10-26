package dev.dalol.cXNCraftattack.commands.admin;

import dev.dalol.cXNCraftattack.CXNCraftattack;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class KickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = Bukkit.getPlayer(strings[0]);

        if (strings.length == 1) {
            player.kickPlayer(CXNCraftattack.stringPrefix() + ChatColor.of(new Color(86, 129, 227)) + "Du wurdest aus dem Realm gekickt:\n" + CXNCraftattack.stringPrefix() + ChatColor.of(new Color(227, 213, 86)) + strings[1]);
        } else {
            commandSender.sendMessage(CXNCraftattack.stringPrefix() + ChatColor.GRAY + "Richtige Verwendung -> " + ChatColor.of(new Color(227, 213, 86)) + "/kick <Spieler> <Nachricht>");
        }

        return false;
    }
}
