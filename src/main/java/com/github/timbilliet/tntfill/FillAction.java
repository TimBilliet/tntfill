package com.github.timbilliet.tntfill;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.block.Dispenser;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class FillAction {

    public static void fillDispensers(Player player, int amount, int radius) {
        List<Dispenser> dispensers = new ArrayList<>();

        int px = player.getLocation().getBlockX();
        int py = player.getLocation().getBlockY();
        int pz = player.getLocation().getBlockZ();
        for (int x = px - radius; x <= px + radius; x++) {
            for (int y = py - radius; y <= py + radius; y++) {
                for (int z = pz - radius; z <= pz + radius; z++) {
                    Block block = player.getWorld().getBlockAt(x, y, z);
                    if (block.getType() == Material.DISPENSER) {
                        BlockState state = block.getState();
                        if (state instanceof Dispenser) {
                            dispensers.add((Dispenser) state);
                        }
                    }
                }
            }
        }
        int totalToAdd = 0;
        for (Dispenser dispenser : dispensers) {
            int currentAmount = 0;
            for (ItemStack item : dispenser.getInventory().getContents()) {
                if (item != null && item.getType() == Material.TNT) {
                    currentAmount += item.getAmount();
                }
            }
            int toAdd = amount - currentAmount;
            if (toAdd > 0) {
                totalToAdd += toAdd;
                dispenser.getInventory().addItem(new ItemStack(Material.TNT, toAdd));

            }
        }
        player.sendMessage("Filled " + dispensers.size() + " dispensers requiring " + totalToAdd + " tnt");
    }
}
