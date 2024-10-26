package dev.dalol.cXNCraftattack.commands;

import dev.dalol.cXNCraftattack.CXNCraftattack;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AFKCommand implements CommandExecutor {
    public static List<Player> afkPlayer = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (afkPlayer.isEmpty()) {
            afkPlayer.add((Player) commandSender);
            Bukkit.broadcastMessage(CXNCraftattack.stringPrefix() + ChatColor.of(new Color(0x98eb34)) + commandSender.getName() + " ist nun AFK.");
            return true;
        } else if (afkPlayer.contains( (Player) commandSender)) {
            afkPlayer.remove(commandSender);
            Bukkit.broadcastMessage(CXNCraftattack.stringPrefix() + ChatColor.of(new Color(0xe0242d)) + commandSender.getName() + " ist nun nicht mehr AFK");
            return true;
        }
        return false;
    }
}
