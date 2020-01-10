package net.collat.pirateplunder;

import net.collat.gametemplate.events.GameStartEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Scoreboard implements Listener {

    @EventHandler
    public void onStart(GameStartEvent event) {
        updateScoreboard();
    }

    public void updateScoreboard() {
        Main.scoreboard.getGlobalScoreboard().setValue(0, "White Score: §7" + Main.whiteScore);
        Main.scoreboard.getGlobalScoreboard().setValue(1, "Red Score: §7" + Main.redScore);
        Main.scoreboard.getGlobalScoreboard().setValue(2, "§2");
    }

}
