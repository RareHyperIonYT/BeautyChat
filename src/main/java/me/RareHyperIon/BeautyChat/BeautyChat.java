package me.RareHyperIon.BeautyChat;

import me.RareHyperIon.BeautyChat.commands.ReloadCommand;
import me.RareHyperIon.BeautyChat.providers.PlaceholderProvider;
import me.RareHyperIon.BeautyChat.providers.impl.GroupManagerPlaceholderProvider;
import me.RareHyperIon.BeautyChat.providers.impl.LuckPermsPlaceholderProvider;
import me.RareHyperIon.BeautyChat.providers.impl.VaultPlaceholderProvider;
import me.RareHyperIon.BeautyChat.listeners.FormatListener;
import me.clip.placeholderapi.PlaceholderAPI;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.milkbowl.vault.chat.Chat;
import org.anjocaido.groupmanager.GroupManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class BeautyChat extends JavaPlugin {

    private PlaceholderProvider placeholderProvider;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(new FormatListener(this), this);
        this.getCommand("beautychat").setExecutor(new ReloadCommand(this));
        this.placeholderProvider = this.determineProvider();
    }

    public String format(final Player player, String message) {
        message = this.replacePlaceholders(player, message);

        if(this.isPlaceholderAPIPresent()) {
            message = PlaceholderAPI.setPlaceholders(player, message);
        }

        return message;
    }

    private String replacePlaceholders(final Player player, final String message) {
        return message
                .replaceAll("\\{(\\S+?)}", "%$1%")
                .replaceAll("%username%", player.getName())
                .replaceAll("%displayname%", player.getDisplayName())
                .replaceAll("%prefix%", this.placeholderProvider.getPrefix(player))
                .replaceAll("%suffix%", this.placeholderProvider.getSuffix(player))
                .replaceAll("%world%", this.placeholderProvider.getWorld(player))
                .replace('&', '§');
    }

    private boolean isPlaceholderAPIPresent() {
        final Plugin plugin = this.getServer().getPluginManager().getPlugin("PlaceholderAPI");
        return plugin != null && plugin.isEnabled();
    }

    private PlaceholderProvider determineProvider() {
        final PluginManager pm = this.getServer().getPluginManager();
        final Logger logger = this.getLogger();

        if(pm.getPlugin("LuckPerms") != null) {
            final Plugin plugin = pm.getPlugin("LuckPerms");

            if(plugin.isEnabled()) {
                logger.info("Hooking into LuckPerms");
                return new LuckPermsPlaceholderProvider(LuckPermsProvider.get());
            }
        }

        if(pm.getPlugin("GroupManager") != null) {
            final Plugin plugin = pm.getPlugin("GroupManager");

            if(plugin.isEnabled()) {
                logger.info("Hooking into GroupManager");
                return new GroupManagerPlaceholderProvider((GroupManager) plugin);
            }
        }

        if(pm.getPlugin("Vault") != null) {
            final Plugin plugin = pm.getPlugin("Vault");

            if(plugin.isEnabled()) {
                final Chat chat = this.getServer().getServicesManager().load(Chat.class);

                if(chat != null) {
                    logger.info("Hooking into Vault");
                    return new VaultPlaceholderProvider(chat);
                }
            }
        }

        return new PlaceholderProvider();
    }

}
