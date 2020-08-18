package me.petterim1.antiunicode;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.plugin.PluginBase;

import java.util.regex.Pattern;

public class Main extends PluginBase implements Listener {

    private static final Pattern pattern = Pattern.compile("[^\\p{L}\\p{N}\\p{P}\\p{Z}]", Pattern.UNICODE_CHARACTER_CLASS);

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onChat(PlayerChatEvent e) {
        e.setMessage(pattern.matcher(e.getMessage()).replaceAll("?"));
    }
}
