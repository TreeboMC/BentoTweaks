package me.shakeforprotein.bentotweaks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BentoTweaksCommand implements CommandExecutor {

    private BentoTweaks pl;

    public BentoTweaksCommand(BentoTweaks main) {
        this.pl = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("bentotweaks")){
            if(sender.hasPermission("bentotweaks.version")) {
                sender.sendMessage(pl.getDescription().getVersion());
            }
            else {
                sender.sendMessage("You require the bentotweaks.version permission to run this command");
            }
        }
        return true;
    }
}