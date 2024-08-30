package me.RareHyperIon.BeautyChat.providers.impl;

import me.RareHyperIon.BeautyChat.providers.PlaceholderProvider;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import org.bukkit.entity.Player;

public class LuckPermsPlaceholderProvider extends PlaceholderProvider {

    private final LuckPerms luckPerms;

    public LuckPermsPlaceholderProvider(final LuckPerms luckPerms) {
        this.luckPerms = luckPerms;
    }

    @Override
    public String getPrefix(final Player player) {
        final UserManager manager = this.luckPerms.getUserManager();
        final User user = manager.getUser(player.getUniqueId());

        if(user == null)
            return "";

        return user.getCachedData().getMetaData().getPrefix();
    }

    @Override
    public String getSuffix(final Player player) {
        final UserManager manager = this.luckPerms.getUserManager();
        final User user = manager.getUser(player.getUniqueId());

        if(user == null)
            return "";

        return user.getCachedData().getMetaData().getSuffix();
    }

}
