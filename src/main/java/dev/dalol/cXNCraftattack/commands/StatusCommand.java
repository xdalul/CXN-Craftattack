package dev.dalol.cXNCraftattack.commands;

import dev.dalol.cXNCraftattack.CXNCraftattack;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatusCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Audience player = (Audience) commandSender;
        Component message = CXNCraftattack.componentPrefix().append(Component.text("⚠ Dieses Feature ist aktuell noch nicht verfügbar. ⚠").color(TextColor.color(0xfc8a4c)));

        player.sendMessage(message);
        return true;
    }
}
