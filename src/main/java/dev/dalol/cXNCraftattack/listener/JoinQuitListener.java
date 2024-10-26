package dev.dalol.cXNCraftattack.listener;

import dev.dalol.cXNCraftattack.CXNCraftattack;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

public class JoinQuitListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(CXNCraftattack.stringPrefix() + ChatColor.of(new Color(86, 129, 227)) + event.getPlayer().getDisplayName() + " hat den Realm betreten.");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(CXNCraftattack.stringPrefix() + ChatColor.of(new Color(86, 129, 227)) + event.getPlayer().getDisplayName() + " hat den Realm verlassen.");
    }
}
