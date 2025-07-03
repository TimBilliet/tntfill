package com.github.timbilliet.tntfill;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FillCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;
        if (!(sender instanceof Player))
            return false;
        player = (Player) sender;
        if (args.length == 0) {
            FillAction.fillDispensers(player, 576, 64);
        } else if (args.length == 1) {
            try {
                int amount = Integer.parseInt(args[0]);
                if (amount > 576)
                    amount = 576;
                FillAction.fillDispensers(player, amount, 64);
            } catch (NumberFormatException e) {
                sender.sendMessage("Invalid argument");
                sender.sendMessage("Usage:");
                sender.sendMessage("/tntfill [amount] [radius]");
            }
        } else if (args.length == 2) {
            try {
                int amount = Integer.parseInt(args[0]);
                if (amount > 576)
                    amount = 576;
                int radius = Integer.parseInt(args[1]);
                if (radius > 256)
                    radius = 256;
                FillAction.fillDispensers(player, amount, radius);
            } catch (NumberFormatException e) {
                sender.sendMessage("Invalid argument");
                sender.sendMessage("Usage:");
                sender.sendMessage("/tntfill [amount] [radius]");
            }
        } else {
            sender.sendMessage("Invalid argument");
            sender.sendMessage("Usage:");
            sender.sendMessage("/tntfill [amount] [radius]");
        }
        return true;
    }
}
