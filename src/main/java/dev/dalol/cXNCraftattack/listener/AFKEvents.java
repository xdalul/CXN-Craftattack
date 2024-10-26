package dev.dalol.cXNCraftattack.listener;

import dev.dalol.cXNCraftattack.CXNCraftattack;
import dev.dalol.cXNCraftattack.commands.AFKCommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

public class AFKEvents implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (AFKCommand.afkPlayer.contains(event.getPlayer())) {
            AFKCommand.afkPlayer.remove(event.getPlayer());
            Bukkit.broadcastMessage(CXNCraftattack.stringPrefix() + ChatColor.of(new Color(0xe0242d)) + event.getPlayer().getName() + " ist nun nicht mehr AFK");
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (AFKCommand.afkPlayer.contains(event.getPlayer())) {
            AFKCommand.afkPlayer.remove(event.getPlayer());
            Bukkit.broadcastMessage(CXNCraftattack.stringPrefix() + ChatColor.of(new Color(0xe0242d)) + event.getPlayer().getName() + " ist nun nicht mehr AFK");
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (AFKCommand.afkPlayer.contains(event.getPlayer())) {
            AFKCommand.afkPlayer.remove(event.getPlayer());
            Bukkit.broadcastMessage(CXNCraftattack.stringPrefix() + ChatColor.of(new Color(0xe0242d)) + event.getPlayer().getName() + " ist nun nicht mehr AFK");
        }
    }
}
