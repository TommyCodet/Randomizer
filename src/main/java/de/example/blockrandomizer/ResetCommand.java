package de.example.blockrandomizer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ResetCommand implements CommandExecutor {

    private final BlockRandomizer plugin;

    public ResetCommand(BlockRandomizer plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        plugin.resetMappings();

        sender.sendMessage("§aBlockRandomizer wurde zurückgesetzt.");
        return true;
    }
}
