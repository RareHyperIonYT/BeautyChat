package me.RareHyperIon.BeautyChat.providers;

import org.bukkit.entity.Player;

public class PlaceholderProvider {

    public String getPrefix(final Player player) {
        return "";
    }

    public String getSuffix(final Player player) {
        return "";
    }

    public String getWorld(final Player player) {
        return player.getWorld().getName();
    }

}
