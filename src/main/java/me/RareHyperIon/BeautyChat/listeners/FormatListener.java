package me.RareHyperIon.BeautyChat.listeners;

import me.RareHyperIon.BeautyChat.BeautyChat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class FormatListener implements Listener {

    private final BeautyChat plugin;

    public FormatListener(final BeautyChat plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(final AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();
        final String format = this.plugin.format(player, this.plugin.getConfig().getString("chat-format"))
                .replaceAll("%message%", event.getMessage());

        event.setFormat(format);
    }

}