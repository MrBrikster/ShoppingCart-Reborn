package ru.mrbrikster.shoppingcartreborn.cart;

import lombok.Getter;
import org.bukkit.entity.Player;
import ru.mrbrikster.shoppingcartreborn.ShoppingCartReborn;
import ru.mrbrikster.shoppingcartreborn.permissions.PermissionProvider;

public class PermissionGroupPurchase implements Purchase {

    @Getter private final String group;
    @Getter private final long time;

    /**
     * Purchase of permissions group.
     * @param group name of the group
     * @param time time in seconds (-1 to permanent)
     */
    public PermissionGroupPurchase(String group, long time) {
        this.group = group;
        this.time = time;
    }

    @Override
    public boolean give(Player player) {
        PermissionProvider permissionProvider = ShoppingCartReborn.getInstance().getPermissionProvider();

        if (time == -1)
            return permissionProvider.addToGroup(player, group);
        else return permissionProvider.addToGroup(player, group, time);
    }

}
