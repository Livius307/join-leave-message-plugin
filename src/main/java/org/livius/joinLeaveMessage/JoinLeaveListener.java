package org.livius.joinLeaveMessage;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + player.getDisplayName() + ChatColor.DARK_RED + " has left. Bye!");
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (player.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.GREEN + "Welcome back to the server " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.YELLOW + "!");
        } else {
            e.setJoinMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Welcome to the server " + ChatColor.BLUE + "" + player.getDisplayName());
        }

    }
}
