package org.livius.joinLeaveMessage;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    private JoinLeaveMessage plugin;

    public JoinLeaveListener(JoinLeaveMessage plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        String lmessage = plugin.getConfig().getString("lmessage");
        if (lmessage != null){
            lmessage = lmessage.replace("%player%", e.getPlayer().getDisplayName());
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', lmessage));
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String jmessage = plugin.getConfig().getString("jmessage");
        if (jmessage != null){
            jmessage = jmessage.replace("%player%", e.getPlayer().getDisplayName());
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', jmessage));
        }
    }
}
