package me.RareHyperIon.BeautyChat.commands;

import me.RareHyperIon.BeautyChat.BeautyChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Collections;
import java.util.List;

public class ReloadCommand implements CommandExecutor, TabCompleter {

    private final BeautyChat plugin;

    public ReloadCommand(final BeautyChat plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if(!sender.hasPermission("beautychat.reload")) {
            sender.sendMessage("§cYou do not have permission to run that command.");
            return true;
        }

        if(args.length > 0) {
            if(args[0].equalsIgnoreCase("reload")) {
                this.plugin.reloadConfig();
                sender.sendMessage("§aSuccessfully reloaded config.");
                return true;
            }
        }

        return false;
    }


    @Override
    public List<String> onTabComplete(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        return Collections.singletonList("reload");
    }
}
