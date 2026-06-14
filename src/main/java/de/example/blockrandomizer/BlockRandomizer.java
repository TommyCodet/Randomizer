package de.example.blockrandomizer;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class BlockRandomizer extends JavaPlugin {

    private final Map<Material, Material> randomMap = new HashMap<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(
                new RandomizerListener(this),
                this
        );

        getCommand("reset").setExecutor(new ResetCommand(this));

        getLogger().info("BlockRandomizer aktiviert.");
    }

    public Map<Material, Material> getRandomMap() {
        return randomMap;
    }

    public void resetMappings() {
        randomMap.clear();
    }
}
