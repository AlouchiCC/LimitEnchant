package fr.alouchi.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Seul les joueurs peuvent executer cette commande.");
            return false;
        }

        Player player = (Player) sender;

        if(label.equalsIgnoreCase("invsee")) {
            if(args.length != 1) {
                player.sendMessage(ChatColor.RED + "Usage: /invsee <player>");
                return false;
            }

            Player target = Bukkit.getPlayer(args[0]);
            if(target == null) {
                player.sendMessage(ChatColor.RED +"Le joueur " + args[0] + " n'est pas en ligne.");
                return false;
            }

            player.openInventory(target.getInventory());
        }

        return false;
    }
}