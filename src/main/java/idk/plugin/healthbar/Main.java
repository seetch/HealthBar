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
                try {
                    for (Player p : getServer().getOnlinePlayers().values()) {
                        if ((p.isSurvival() || p.isAdventure()) && !p.hasEffect(Effect.INVISIBILITY)) {
                            p.setScoreTag("\u00A7f" + Math.floor(p.getHealth()) + " \u00A7c❤");
                        }
                    }
                } catch (Exception ignore) {
                }
            }
        }, 10, 10, true);
    }
}
