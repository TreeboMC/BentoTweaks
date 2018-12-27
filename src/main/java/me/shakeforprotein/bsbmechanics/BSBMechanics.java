package me.shakeforprotein.bsbmechanics;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.material.Cauldron;
import org.bukkit.material.Mushroom;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


public final class BSBMechanics extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Boolean debug = false;
        System.out.println("BSBMechanics is starting");
        getServer().getPluginManager().registerEvents(this, this);
        getConfig().options().copyDefaults(true);
        getConfig().set("version", this.getDescription().getVersion());
        saveConfig();
        System.out.println("BSBMechanics startup complete");
    }

    @Override
    public void onDisable() {
        System.out.println("BSBMechanics has shut down");
    }

    int cost = 0;
    @EventHandler
    private void onStickCauldron (PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CAULDRON && e.getPlayer().getInventory().getItemInMainHand().getType() == Material.STICK) {
            Player p = e.getPlayer();
            String world = p.getWorld().getName();
            if ((world.equalsIgnoreCase("BSkyblock_world")) || (world.equalsIgnoreCase("AcidIsland_world")) || world.equalsIgnoreCase(e.getClickedBlock().getWorld().toString())) {

                Cauldron cauldron = (Cauldron) e.getClickedBlock().getState().getData();
                Location target = e.getClickedBlock().getLocation();
                if (cauldron.isFull()) {
                    e.setCancelled(true);
                    if (p.getInventory().getItemInOffHand().getType() == Material.WHITE_WOOL) {
                        spawnMob(p, target, "SHEEP");
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.LEATHER) {
                        spawnMob(p, target, "COW");
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.BONE) {
                        spawnMob(p, target,"WOLF");
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.CARROT_ON_A_STICK) {
                        spawnMob(p, target,"PIG");
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.CARROT) {
                        spawnMob(p, target,"RABBIT");
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.FEATHER) {
                        spawnMob(p, target,"CHICKEN");
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.SEAGRASS) {
                        spawnMob(p, target,"TURTLE");
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.WHEAT_SEEDS) {
                        spawnMob(p, target,"PARROT");
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.COD) {
                        spawnMob(p, target,"OCELOT");
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.MUSHROOM_STEW) {
                        spawnMob(p, target,"MUSHROOM_COW");
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.HAY_BLOCK) {
                        spawnMob(p, target,"HORSE");
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.BOOK) {
                        createKnowledgeTome(p);
                    }
                    if (p.getInventory().getItemInOffHand().getType() == Material.NETHER_WART_BLOCK) {
                        ItemStack redMushroom = new ItemStack(Material.RED_MUSHROOM);
                        redMushroom.setType(Material.RED_MUSHROOM);
                        redMushroom.setAmount(1);
                        ItemStack brownMushroom = new ItemStack(Material.BROWN_MUSHROOM);
                        brownMushroom.setType(Material.BROWN_MUSHROOM);
                        brownMushroom.setAmount(1);
                        e.getClickedBlock().getWorld().dropItem(target.add(0,2,0), redMushroom);
                        e.getClickedBlock().getWorld().dropItem(target.add(0,2,0), brownMushroom);
                        p.getInventory().getItemInOffHand().setType(Material.AIR);

                    }
                }
                else{p.sendMessage(ChatColor.RED + "Your cauldron must be full if you want to avoid accidents like this.");
                    p.getWorld().strikeLightning(p.getLocation());
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                        public void run() {
                            p.getWorld().strikeLightning(target);
                        }
                    }, 20L);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                        public void run() {
                            p.getWorld().strikeLightning(target);
                        }
                    }, 40L);
                }
            }

        }
    }

    private void spawnMob(Player p, Location target, String mobName) {
        cost = getConfig().getInt(mobName + ".LEVELS");
        if(getConfig().getString(mobName + ".ENABLED").equalsIgnoreCase("true")){
            if (p.getLevel() >= cost) {
                p.getWorld().strikeLightning(target);
                p.setLevel(p.getLevel() - cost);
                p.getInventory().getItemInOffHand().setType(Material.AIR);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
                    p.getWorld().strikeLightning(target);
                }
            }, 20L);

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
                    p.getWorld().strikeLightning(target);
                }
            }, 30L);

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
                    p.getWorld().strikeLightning(target);
                }
            }, 40L);

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
                    p.getWorld().strikeLightning(target);
                }
            }, 45L);

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
                    p.getWorld().strikeLightning(target);
                }
            }, 50L);

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
                    p.getWorld().spawnEntity(target.add(0,2,0), (EntityType.valueOf(mobName)));
                }
            }, 70L);

        }
        else {p.sendMessage(getConfig().getString("insufficientLEVELS"));}

        }

    }


    private void createKnowledgeTome(Player p) {

        ItemStack pOff = p.getInventory().getItemInOffHand();
        pOff.setType(Material.WRITTEN_BOOK);
        BookMeta pBook = (BookMeta) pOff.getItemMeta();
        pBook.setDisplayName("The effects of Five billion Volts on various cadavers");
        pBook.setTitle("The effects of Five billion Volts on various cadavers");
        pBook.setAuthor("Dr. V. Frankenstein");

        List<String> pages = new ArrayList<String>();
        pages.add("Foreword: Dear reader this book is intended to pass on my knowledge, so noone need repeat my accursed experiments"); // Page 1
        pages.add("Warnings:\n Do not stand too close to the experiment as electricity is known to arc.\n\bThe experiments are hungry, care should be taken to ensure extra materials do not come into contact"); // Page 2
        pages.add("In my early experiments I found that I needed a combination of parts from multiple cadavers, carefully stitched together. I have since learned that the more electricity you use, the less cadaver you need"); // Page 3
        pages.add("Parrot:\nSeveral loose Seeds\n3 parts saline\n" + getConfig().getInt("PARROT.LEVELS") + " parts Knowledge");
        pages.add("Rabbit:\n1 part Carrot (nibbled)\n3 parts saline\n" + getConfig().getInt("RABBIT.LEVELS") + " parts Knowledge");
        pages.add("Chicken:\n1 part feather (pluckewd)\n3 parts saline\n" + getConfig().getInt("CHICKEN.LEVELS") + " parts Knowledge");
        pages.add("Ocelot:\n1 part cod (raw)\n3 parts saline\n" + getConfig().getInt("OCELOT.LEVELS") + " parts Knowledge");
        pages.add("Turtles:\n1 part Seagrass (slimy)\n3 parts saline\n" + getConfig().getInt("TURTLE.LEVELS") + " parts Knowledge");
        pages.add("Wolf:\n1 part Bone (chewed)\n3 parts saline\n" + getConfig().getInt("WOLF.LEVELS") + " parts Knowledge");
        pages.add("Pigs:\n1 part Carrot on a stick (bitten)\n3 parts saline\n" + getConfig().getInt("PIG.LEVELS") + " parts Knowledge");
        pages.add("Sheep:\n1 part white wool(sheared)\n3 parts saline\n" + getConfig().getInt("SHEEP.LEVELS") + " parts Knowledge");
        pages.add("Cows:\n1 part leather (skinned)\n3 parts saline\n" + getConfig().getInt("COW.LEVELS") + " parts Knowledge");
        pages.add("Mushroom Cow:\n1 part Mushroom Stew (salty)\n3 parts saline\n" + getConfig().getInt("MUSHROOM_COW.LEVELS") + " parts Knowledge");
        pages.add("Horse:\n9 part Hay (Baled)\n3 parts saline\n" + getConfig().getInt("HORSE.LEVELS") + " parts Knowledge");



        pBook.setPages(pages);
        pOff.setItemMeta(pBook);

    }
}

