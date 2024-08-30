package me.RareHyperIon.BeautyChat.providers.impl;

import me.RareHyperIon.BeautyChat.providers.PlaceholderProvider;
import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.permissions.AnjoPermissionsHandler;
import org.bukkit.entity.Player;

public class GroupManagerPlaceholderProvider extends PlaceholderProvider {

    private final GroupManager groupManager;

    public GroupManagerPlaceholderProvider(final GroupManager luckPerms) {
        this.groupManager = luckPerms;
    }

    @Override
    public String getPrefix(final Player player) {
        final AnjoPermissionsHandler handler = this.groupManager.getWorldsHolder().getWorldPermissions(player);

        if(handler == null) return "";

        return handler.getUserPrefix(player.getName());
    }

    @Override
    public String getSuffix(final Player player) {
        final AnjoPermissionsHandler handler = this.groupManager.getWorldsHolder().getWorldPermissions(player);

        if(handler == null) return "";

        return handler.getUserSuffix(player.getName());
    }

}

