package dev.dalol.cXNCraftattack.commands;

import dev.dalol.cXNCraftattack.CXNCraftattack;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class TestTimer implements CommandExecutor {

    private final CXNCraftattack plugin;

    public TestTimer(CXNCraftattack plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        plugin.startTimer(3 * 60 * 60);
        commandSender.sendMessage(CXNCraftattack.stringPrefix() + ChatColor.of(new Color(245, 228, 76)) + " Timer sollte nun starten!");
        return false;
    }

}
