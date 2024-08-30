package me.RareHyperIon.BeautyChat.providers.impl;

import me.RareHyperIon.BeautyChat.providers.PlaceholderProvider;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.entity.Player;

public class VaultPlaceholderProvider extends PlaceholderProvider {

    private final Chat vault;

    public VaultPlaceholderProvider(final Chat vault) {
        this.vault = vault;
    }

    @Override
    public String getPrefix(final Player player) {
        return this.vault.getPlayerPrefix(player);
    }

    @Override
    public String getSuffix(final Player player) {
        return this.vault.getPlayerSuffix(player);
    }

}
