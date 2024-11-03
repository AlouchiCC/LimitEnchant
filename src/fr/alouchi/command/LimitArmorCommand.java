package fr.alouchi.command;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class LimitArmorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Seul les joueurs peuvent executer cette commande.");
            return false;
        }

        Player player = (Player) sender;

        if(label.equalsIgnoreCase("limitarmor")) {
            net.md_5.bungee.api.chat.TextComponent textComponent = new TextComponent("§3[Discord]");
            textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Clique.").create()));
            textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/alouchi"));

            player.sendMessage("§3Le développeur du plugin est Alouchi.");
            player.spigot().sendMessage(textComponent);
        }

        return false;
    }
}