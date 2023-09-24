package idk.plugin.healthbar;

import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.potion.Effect;
import cn.nukkit.scheduler.NukkitRunnable;

public class Main extends PluginBase {

    public void onEnable() {
        getServer().getScheduler().scheduleDelayedRepeatingTask(this, new NukkitRunnable() {
            @Override
            public void run() {
                for (Player player : getServer().getOnlinePlayers().values()) {
                    if ((player.isSurvival() || player.isAdventure()) && !player.hasEffect(Effect.INVISIBILITY)) {
                        String displayHealth = "";
                        float health = player.getHealth();
                        if (health <= player.getMaxHealth()) {
                            displayHealth = "\uE116";
                        }
                        if (health <= (float) player.getMaxHealth() / 2) {
                            displayHealth = "\uE117";
                        }
                        if (health <= 0) {
                            displayHealth = "\uE118";
                        }

                        player.setScoreTag(displayHealth);
                    }
                }
            }
        }, 10, 10, true);
    }
}
