package com.github.timbilliet.tntfill;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;

public class UnfillAction {
    private static final int radius = 64;

    public static void unfill(Player player) {

        int px = player.getLocation().getBlockX();
        int py = player.getLocation().getBlockY();
        int pz = player.getLocation().getBlockZ();
        int size = 0;
        for (int x = px - radius; x <= px + radius; x++) {
            for (int y = py - radius; y <= py + radius; y++) {
                for (int z = pz - radius; z <= pz + radius; z++) {
                    Block block = player.getWorld().getBlockAt(x, y, z);
                    if (block.getType() == Material.DISPENSER) {
                        BlockState state = block.getState();
                        if (state instanceof Dispenser) {
                            size++;
                            ((Dispenser) state).getInventory().clear();
                        }
                    }
                }
            }
        }

        player.sendMessage("Unfilled " + size + " dispensers");
    }
}
