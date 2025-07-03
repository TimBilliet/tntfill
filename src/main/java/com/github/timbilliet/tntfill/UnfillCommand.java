package com.github.timbilliet.tntfill;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnfillCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;
        if(!(sender instanceof Player))
            return false;
        player = (Player) sender;

        if(args.length == 0){
            UnfillAction.unfill(player);
        } else {
            sender.sendMessage("Invalid argument");
            sender.sendMessage("Usage:");
            sender.sendMessage("/tntunfill");
        }
        return true;
    }
}
