package me.shakeforprotein.bentotweaks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NotifyStaff implements Listener {

    private BentoTweaks pl;
    private UpdateChecker uc;

    public NotifyStaff(BentoTweaks main) {
        this.pl = main;
        this.uc = new UpdateChecker(main);
    }

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent e) {

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
            public void run() {
                Player p = e.getPlayer();

                if (e.getPlayer().hasPermission(uc.requiredPermission)) {

                    uc.getCheckDownloadURL(e.getPlayer());
                    pl.getConfig().set(e.getPlayer().getName(), "true");
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
                        public void run() {
                            pl.getConfig().set(e.getPlayer().getName(), "false");
                        }
                        }, 75L);
                }
            }
        }, 200L);
    }
}
