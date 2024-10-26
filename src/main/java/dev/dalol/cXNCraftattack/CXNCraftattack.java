package dev.dalol.cXNCraftattack;

import dev.dalol.cXNCraftattack.commands.AFKCommand;
import dev.dalol.cXNCraftattack.commands.StatusCommand;
import dev.dalol.cXNCraftattack.commands.TestTimer;
import dev.dalol.cXNCraftattack.commands.admin.KickCommand;
import dev.dalol.cXNCraftattack.elytra.ElytraPos1;
import dev.dalol.cXNCraftattack.elytra.ElytraPos2;
import dev.dalol.cXNCraftattack.elytra.MoveEvent;
import dev.dalol.cXNCraftattack.listener.AFKEvents;
import dev.dalol.cXNCraftattack.listener.JoinQuitListener;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;

public final class CXNCraftattack extends JavaPlugin {
    private long timeLeft;
    private BukkitRunnable timerTask;
    private static CXNCraftattack instance;

    public static CXNCraftattack getInstance() {
        return instance;
    }

    public static String stringPrefix() {
        String text = ChatColor.DARK_GRAY + "[" + ChatColor.of(new Color(237, 216, 78)) + "CXNCraftattack" + ChatColor.DARK_GRAY + "] ";
        return text;
    }
    public static Component componentPrefix() {
        Component component = Component.text("[").color(TextColor.color(46, 46, 46)).append(Component.text("CXNCraftattack").color(TextColor.color(0xedd84e))).append(Component.text("] ").color(TextColor.color(46, 46, 46)));
        return component;
    }

    @Override
    public void onEnable() {
        instance = this;

        getLogger().info("Loaded");
        getCommand("status").setExecutor(new StatusCommand());
        getCommand("setpos1").setExecutor(new ElytraPos1());
        getCommand("setpos2").setExecutor(new ElytraPos2());
        getCommand("kick").setExecutor(new KickCommand());
        getCommand("afk").setExecutor(new AFKCommand());
        getCommand("testtimer").setExecutor(new TestTimer(this));


        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new MoveEvent(), this);
        pm.registerEvents(new JoinQuitListener(), this);
        pm.registerEvents(new AFKEvents(), this);
    }

    public void startTimer(long durationInSeconds) {
        if (timerTask != null) {
            timerTask.cancel(); // Stoppe den vorherigen Timer, falls er aktiv ist
        }

        timeLeft = durationInSeconds; // Setze die neue Dauer

        // Erstelle einen BukkitRunnable, der den Timer herunterzählt und die Actionbar aktualisiert
        timerTask = new BukkitRunnable() {
            @Override
            public void run() {
                if (timeLeft > 0) {
                    // Berechne die verbleibende Zeit
                    long hours = timeLeft / 3600;
                    long minutes = (timeLeft % 3600) / 60;
                    long seconds = timeLeft % 60;

                    // Erstelle die Actionbar Nachricht
                    String actionBarMessage = hours + "h " + minutes + "m " + seconds + "s";

                    // Gehe durch alle Spieler auf dem Server und sende die Actionbar
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        sendActionBar(player, actionBarMessage); // Sende die Actionbar Nachricht
                    }

                    // Ziehe nur hier 1 Sekunde ab
                    timeLeft--;
                } else {
                    this.cancel(); // Stoppe den Task, wenn der Timer abgelaufen ist
                    // Hier kannst du weitere Aktionen ausführen, wenn der Timer abläuft
                }
            }
        };
        timerTask.runTaskTimer(this, 0L, 20L); // Aktualisiere jede Sekunde (20 Ticks)



    timeLeft = durationInSeconds;

    timerTask.runTaskTimer(this, 0L, 20L);
    }
    public long getTimeLeft() {
        return timeLeft;
    }

    public void sendActionBar(Player player, String message) {

        // Erstelle die Nachricht für die Actionbar
        TextComponent actionBarMessage = new TextComponent(message);

        //actionBarMessage.setStyle();

        // Sende die Nachricht in die Actionbar des Spielers
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
    }



}
