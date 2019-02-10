package me.shakeforprotein.bentotweaks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BsbTweaksCommand implements CommandExecutor {

    private BentoTweaks pl;

    public BsbTweaksCommand(BentoTweaks main) {
        this.pl = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("bsbtweaks")){
            if(sender.hasPermission("bsbcustommechanics.version")) {
                sender.sendMessage(pl.getDescription().getVersion());
            }
            else {
                sender.sendMessage("You require the bsbcustommechanics.version permission to run this command");
            }
        }
        return true;
    }
}