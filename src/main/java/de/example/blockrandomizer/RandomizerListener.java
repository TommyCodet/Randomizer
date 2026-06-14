package de.example.blockrandomizer;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Map;
import java.util.Random;

public class RandomizerListener implements Listener {

    private final BlockRandomizer plugin;
    private final Random random = new Random();

    public RandomizerListener(BlockRandomizer plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Block block = event.getBlock();
        Material broken = block.getType();

        Map<Material, Material> map = plugin.getRandomMap();

        Material replacement = map.computeIfAbsent(
                broken,
                mat -> getRandomBlock()
        );

        Bukkit.getScheduler().runTask(plugin, () ->
                block.setType(replacement, false)
        );
    }

    private Material getRandomBlock() {

        Material[] materials = Material.values();

        Material selected;

        do {
            selected = materials[random.nextInt(materials.length)];
        } while (!selected.isBlock()
                || selected.isAir()
                || !selected.isSolid());

        return selected;
    }
}
