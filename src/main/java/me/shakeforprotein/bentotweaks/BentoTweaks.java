package me.shakeforprotein.bentotweaks;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.material.Cauldron;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


public final class BentoTweaks extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Boolean debug = false;
        System.out.println("BentoTweaks is starting");
        getServer().getPluginManager().registerEvents(this, this);
        getConfig().options().copyDefaults(true);
        getConfig().set("version", this.getDescription().getVersion());
        saveConfig();
        System.out.println("BentoTweaks startup complete");
    }

    @Override
    public void onDisable() {
        System.out.println("BentoTweaks has shut down");
    }

    int cost = 0;
    int requiredrottenflesh = 0;
    int requiredbones = 0;
    int requiredshulkershells = 0;
    int requiredphantommembranes = 0;
    int con1 = 0;
    int con2 = 0;
    int con3 = 0;
    int con4 = 0;
    int totalcondition = 0;
    int totalrotten = 0;
    int totalbone = 0;
    int totalshulker = 0;
    int totalphantom = 0;
    @EventHandler
    private void onStickCauldron (PlayerInteractEvent e) {
        EquipmentSlot Hand = e.getHand();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && Hand.equals(EquipmentSlot.HAND)&& e.getClickedBlock().getType() == Material.CAULDRON) {
            Player p = e.getPlayer();
            String world = p.getWorld().getName();
            if ((world.equalsIgnoreCase("BSkyblock_world")) || (world.equalsIgnoreCase("AcidIsland_world")) || world.equalsIgnoreCase(e.getClickedBlock().getWorld().toString())) {

                Cauldron cauldron = (Cauldron) e.getClickedBlock().getState().getData();
                Location target = e.getClickedBlock().getLocation();
                if (cauldron.isFull()||p.getInventory().getItemInMainHand().getType() == Material.WATER_BUCKET||p.getInventory().getItemInMainHand().getType() == Material.POTION || p.getInventory().getItemInMainHand().getType() == Material.CAULDRON) {
                    e.setCancelled(false);
                    if (p.getInventory().getItemInMainHand().getType() == Material.STICK) {

                        if (p.getInventory().getItemInOffHand().getType() == Material.WHITE_WOOL) {
                            spawnMob(p, target, "SHEEP");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.LEATHER) {
                            spawnMob(p, target, "COW");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.BONE) {
                            spawnMob(p, target, "WOLF");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.CARROT_ON_A_STICK) {
                            spawnMob(p, target, "PIG");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.CARROT) {
                            spawnMob(p, target, "RABBIT");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.FEATHER) {
                            spawnMob(p, target, "CHICKEN");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.SEAGRASS) {
                            spawnMob(p, target, "TURTLE");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.WHEAT_SEEDS) {
                            spawnMob(p, target, "PARROT");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.COD) {
                            spawnMob(p, target, "OCELOT");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.MUSHROOM_STEW) {
                            spawnMob(p, target, "MUSHROOM_COW");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.HAY_BLOCK) {
                            spawnMob(p, target, "HORSE");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.COOKED_COD) {
                            spawnMob(p, target, "POLAR_BEAR");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.BOOK) {
                            createKnowledgeTome(p);
                        }
                    }

                    if (p.getInventory().getItemInMainHand().getType() == Material.BONE) {

                        if (p.getInventory().getItemInOffHand().getType() == Material.SLIME_BALL) {
                            spawnMob(p, target, "SLIME");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.EMERALD) {
                            spawnMob(p, target, "ZOMBIE_VILLAGER");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.FEATHER) {
                            spawnMob(p, target, "PHANTOM");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.BOOK) {
                            createKnowledgeTomeMonsters(p);
                        }
                    }

                    if (p.getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD) {

                        if (p.getInventory().getItemInOffHand().getType() == Material.BONE) {
                            spawnMob(p, target, "WITHER_SKELETON");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.BOOK) {
                            createKnowledgeTomeNether(p);
                        }
                    }

                    if (p.getInventory().getItemInMainHand().getType() == Material.END_ROD) {

                        if (p.getInventory().getItemInOffHand().getType() == Material.ENDER_PEARL) {
                            spawnMob(p, target, "ENDERMITE");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.ENDER_EYE) {
                            spawnMob(p, target, "SHULKER");
                        }
                        if (p.getInventory().getItemInOffHand().getType() == Material.BOOK) {
                            createKnowledgeTomeEnd(p);
                        }
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
        requiredrottenflesh = getConfig().getInt(mobName + ".ROTTENFLESH");
        requiredbones = getConfig().getInt(mobName + ".BONES");
        requiredshulkershells = getConfig().getInt(mobName + ".SHULKERSHELL");
        requiredphantommembranes = getConfig().getInt(mobName + ".PHANTOMMEMBRANE");
        if (getConfig().getString(mobName + ".ENABLED").equalsIgnoreCase("true")) {
            if (p.getLevel() >= cost) {

                //TESTS THE PLAYERS INVENTORY
                for (ItemStack item : p.getInventory().getContents())

                    if (item != null && item.getType() != null && item.getType() == Material.ROTTEN_FLESH) {
                        totalrotten = totalrotten + item.getAmount();
                    }
                for (ItemStack item : p.getInventory().getContents())

                    if (item != null && item.getType() != null && item.getType() == Material.BONE) {
                        totalbone = totalbone + item.getAmount();
                    }
                for (ItemStack item : p.getInventory().getContents())

                    if (item != null && item.getType() != null && item.getType() == Material.SHULKER_SHELL) {
                        totalshulker = totalshulker + item.getAmount();
                    }
                for (ItemStack item : p.getInventory().getContents())

                    if (item != null && item.getType() != null && item.getType() == Material.PHANTOM_MEMBRANE) {
                        totalphantom = totalphantom + item.getAmount();
                    }
                //CALCULATES THE TOTAL OF EACH ITEM SPECIFIED. IF NOT NEEDED.. IT CHANGES THE CONDITION.
                if (requiredrottenflesh == 0){ con1=1;}
                if (requiredrottenflesh > 0 && totalrotten >= requiredrottenflesh) {
                    con1 = 1;
                }
                if (requiredbones == 0){ con2=1;}
                if (requiredbones > 0 && totalbone >= requiredbones) {
                    con2 = 1;
                }
                if (requiredshulkershells == 0){ con3=1;}
                if (requiredshulkershells > 0 && totalshulker >= requiredshulkershells) {
                    con3 = 1;
                }
                if (requiredphantommembranes == 0){ con4=1;}
                if (requiredphantommembranes > 0 && totalphantom >= requiredphantommembranes) {
                    con4 = 1;
                }

                totalcondition = con1 + con2 + con3 + con4;
                con1 = 0;
                con2 = 0;
                con3 = 0;
                con4 = 0;
                totalrotten = 0;
                totalbone = 0;
                totalshulker = 0;
                totalphantom = 0;
                if (totalcondition == 4) {
                    totalcondition = 0;
                    p.getWorld().strikeLightning(target);
                    p.setLevel(p.getLevel() - cost);
                    p.getInventory().removeItem(new ItemStack(Material.ROTTEN_FLESH, requiredrottenflesh));
                    p.getInventory().removeItem(new ItemStack(Material.BONE, requiredbones));
                    p.getInventory().removeItem(new ItemStack(Material.SHULKER_SHELL, requiredshulkershells));
                    p.getInventory().removeItem(new ItemStack(Material.PHANTOM_MEMBRANE, requiredphantommembranes));
                    //PhysicProdigy added this to minus one item from the left hand
                    p.getInventory().getItemInOffHand().setAmount(p.getInventory().getItemInOffHand().getAmount() - 1);

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
                            p.getWorld().spawnEntity(target.add(0, 2, 0), (EntityType.valueOf(mobName)));
                        }
                    }, 70L);
                }

                else {
                    p.sendMessage("Because you forgotten some key ingredients, you become inexperienced with the test you were performing.");
                    p.setLevel(p.getLevel() - cost);
                }
            }

            else {
                p.sendMessage(getConfig().getString("insufficientLEVELS"));
            }
        }
    }




    private void createKnowledgeTome(Player p) {

        ItemStack pOff = p.getInventory().getItemInOffHand();
        int TOTALAMOUNT = pOff.getAmount();
        if (TOTALAMOUNT > 1){
            pOff.setAmount(1);
        }
        pOff.setType(Material.WRITTEN_BOOK);
        p.getInventory().addItem(new ItemStack(Material.BOOK, TOTALAMOUNT-1));
        BookMeta pBook = (BookMeta) pOff.getItemMeta();
        pBook.setDisplayName("The effects of Five billion Volts on various cadavers");
        pBook.setTitle("The effects of Five billion Volts on various cadavers");
        pBook.setAuthor("Dr. V. Frankenstein");

        List<String> pages = new ArrayList<String>();
        pages.add("Foreword: Dear reader this book is intended to pass on my knowledge. Feeling the need to discover the arts of reanimation, I do not suggest to perform these experiments."); // Page 1
        pages.add("Warnings:\n Do not stand too close to the experiment as electricity is known to arc.\n\bThe experiments are hungry, care should be taken to ensure extra materials do not come into contact"); // Page 2
        pages.add("I have encountered times where i've felt dumbfounded of the missing requirements to my experiment which caused my knowledge to decrease. PLEASE REMEMBER THE EXTRA INGREDIENTS.");//page3
        pages.add("By using my stick on the cauldron and holding the key ingredient in my left hand...I could mix in a set amount of rotten_flesh or extra materials needed to create life!"); // Page 4
        pages.add("Here are the ingredients for each mob you'll want to create");
        pages.add("Parrot - Main ingredients:\n1 Part Seeds\nA filled up cauldron\n" + getConfig().getInt("PARROT.LEVELS") + " parts Knowledge\nExtra ingredients:\n 24 rotten flesh and 12 bones");
        pages.add("Rabbit - Main ingredients:\n1 Part Carrot (nibbled)\nA filled up cauldron\n" + getConfig().getInt("RABBIT.LEVELS") + " parts Knowledge\nExtra ingredients:\n 24 rotten flesh and 12 bones");
        pages.add("Chicken - Main ingredients:\n1 Part Feather (pluckewd)\nA filled up cauldron\n" + getConfig().getInt("CHICKEN.LEVELS") + " parts Knowledge\nExtra ingredients:\n 24 rotten flesh and 12 bones");
        pages.add("Ocelot - Main ingredients:\n1 Part Cod (raw)\nA filled up cauldron\n" + getConfig().getInt("OCELOT.LEVELS") + " parts Knowledge\nExtra ingredients:\n 24 rotten flesh and 12 bones");
        pages.add("Turtles - Main ingredients:\n1 Part Sea grass (slimy)\nA filled up cauldron\n" + getConfig().getInt("TURTLE.LEVELS") + " parts Knowledge\nExtra ingredients:\n 40 rotten flesh and 20 bones and a shulker shell");
        pages.add("Wolf - Main ingredients:\n1 Part Bone (chewed)\nA filled up cauldron\n" + getConfig().getInt("WOLF.LEVELS") + " parts Knowledge\nExtra ingredients:\n 24 rotten flesh and 12 bones");
        pages.add("Pigs - Main ingredients:\n1 Part Carrot on a stick (bitten)\nA filled up cauldron\n" + getConfig().getInt("PIG.LEVELS") + " parts Knowledge\nExtra ingredients:\n 40 rotten flesh and 20 bones");
        pages.add("Sheep - Main ingredients:\n1 Part White wool(sheared)\nA filled up cauldron\n" + getConfig().getInt("SHEEP.LEVELS") + " parts Knowledge\nExtra ingredients:\n 40 rotten flesh and 20 bones");
        pages.add("Cows - Main ingredients:\n1 Part Leather (skinned)\nA filled up cauldron\n" + getConfig().getInt("COW.LEVELS") + " parts Knowledge\nExtra ingredients:\n 40 rotten flesh and 20 bones");
        pages.add("Mushroom Cow - Main ingredients:\n1 part Mushroom Stew (salty)\nA filled up cauldron\n" + getConfig().getInt("MUSHROOM_COW.LEVELS") + " parts Knowledge\nExtra ingredients:\n 40 rotten flesh and 20 bones");
        pages.add("Horse - Main ingredients:\n1 part Hay Bale)\nA filled up cauldron\n" + getConfig().getInt("HORSE.LEVELS") + " parts Knowledge\nExtra ingredients:\n 40 rotten flesh and 20 bones");
        pages.add("Polar bear - Main ingredients:\n1 part Cooked Cod)\nA filled up cauldron\n" + getConfig().getInt("POLAR_BEAR.LEVELS") + " parts Knowledge\nExtra ingredients:\n 40 rotten flesh and 20 bones");
        pages.add("For higher tier summons, you'll need to unlock my second book of 4: The effects of Five billion Volts on various cadavers - THE MONSTER GUIDE \n To get my next book, you'll need to repeat how you got This book, but instead of a stick, you'll need a bone.");

        pBook.setPages(pages);
        pOff.setItemMeta(pBook);

    }
    private void createKnowledgeTomeMonsters(Player p) {

        ItemStack pOffM = p.getInventory().getItemInOffHand();
        int TOTALAMOUNTM = pOffM.getAmount();
        if (TOTALAMOUNTM > 1){
            pOffM.setAmount(1);
        }
        pOffM.setType(Material.WRITTEN_BOOK);
        p.getInventory().addItem(new ItemStack(Material.BOOK, TOTALAMOUNTM-1));
        BookMeta pBook = (BookMeta) pOffM.getItemMeta();
        pBook.setDisplayName("The effects of Five billion Volts on various cadavers - THE MONSTER GUIDE");
        pBook.setTitle("The effects of Five billion Volts on various cadavers - THE MONSTER GUIDE");
        pBook.setAuthor("Dr. V. Frankenstein");

        List<String> pages = new ArrayList<String>();
        pages.add("Foreword: If you have read my previous books, you should know the standard procedures and safety precautions. I would like to say from this point onwards... These summons can cause death and contaiment of these mobs is recommended"); // Page 1
        pages.add("Slime - Main ingredients:\n1 Part Slime Ball(slimy)\nA filled up cauldron\n" + getConfig().getInt("SLIME.LEVELS") + " parts Knowledge\nExtra ingredients:\n Nothing more needed");
        pages.add("Zombie villager - Main ingredients:\n1 Part Emerald(crystal)\nA filled up cauldron\n" + getConfig().getInt("ZOMBIE_VILLAGER.LEVELS") + " parts Knowledge\nExtra ingredients:\n 40 rotten flesh and 20 bones");
        pages.add("Phantom - Main ingredients:\n1 Part FEATHER (plucked)\nA filled up cauldron\n" + getConfig().getInt("PHANTOM.LEVELS") + " parts Knowledge\nExtra ingredients:\n 24 rotten flesh and 12 bones");
        pages.add("For higher tier summons, you'll need to unlock my third book of 4: The effects of Five billion Volts on various cadavers - THE NETHER MOBS GUIDE \n To get my next book, you'll need to repeat how you got This book, but instead of a bone, you'll need a blaze rod.");

        pBook.setPages(pages);
        pOffM.setItemMeta(pBook);

    }
    private void createKnowledgeTomeNether(Player p) {

        ItemStack pOffN = p.getInventory().getItemInOffHand();
        int TOTALAMOUNTN = pOffN.getAmount();
        if (TOTALAMOUNTN > 1){
            pOffN.setAmount(1);
        }
        pOffN.setType(Material.WRITTEN_BOOK);
        p.getInventory().addItem(new ItemStack(Material.BOOK, TOTALAMOUNTN-1));
        BookMeta pBook = (BookMeta) pOffN.getItemMeta();
        pBook.setDisplayName("The effects of Five billion Volts on various cadavers - THE NETHER MOBS GUIDE");
        pBook.setTitle("The effects of Five billion Volts on various cadavers - THE NETHER MOBS GUIDE");
        pBook.setAuthor("Dr. V. Frankenstein");

        List<String> pages = new ArrayList<String>();
        pages.add("Foreword: If you have read my previous books, you should know the standard procedures and safety precautions. I would like to say from this point onwards... These summons can cause death and contaiment of these mobs is recommended"); // Page 1
        pages.add("Wither skeleton - Main ingredients:\n1 Part Bone (chewed)\nA filled up cauldron\n" + getConfig().getInt("WITHER_SKELETON.LEVELS") + " parts Knowledge\nExtra ingredients:\n 30 bones");
        pages.add("For higher tier summons, you'll need to unlock my last book: The effects of Five billion Volts on various cadavers - THE END MOBS GUIDE \n To get my next book, you'll need to repeat how you got his book, but instead of a blaze rod, you'll need an end rod.");

        pBook.setPages(pages);
        pOffN.setItemMeta(pBook);

    }
    private void createKnowledgeTomeEnd(Player p) {

        ItemStack pOffE = p.getInventory().getItemInOffHand();
        int TOTALAMOUNTE = pOffE.getAmount();
        if (TOTALAMOUNTE > 1){
            pOffE.setAmount(1);
        }
        pOffE.setType(Material.WRITTEN_BOOK);
        p.getInventory().addItem(new ItemStack(Material.BOOK, TOTALAMOUNTE-1));
        BookMeta pBook = (BookMeta) pOffE.getItemMeta();
        pBook.setDisplayName("The effects of Five billion Volts on various cadavers - THE END MOBS GUIDE");
        pBook.setTitle("The effects of Five billion Volts on various cadavers - THE END MOBS GUIDE");
        pBook.setAuthor("Dr. V. Frankenstein");

        List<String> pages = new ArrayList<String>();
        pages.add("Foreword: If you have read my previous books, you should know the standard procedures and safety precautions. I would like to say from this point onwards... These summons can cause death and contaiment of these mobs is recommended"); // Page 1
        pages.add("Endermite - Main ingredients:\n1 Part Enderpearl (dropped)\nA filled up cauldron\n" + getConfig().getInt("ENDERMITE.LEVELS") + " parts Knowledge\nExtra ingredients:\n 3 bones");
        pages.add("Shulker - Main ingredients:\n1 Part Eye Of Ender (crafted)\nA filled up cauldron\n" + getConfig().getInt("SHULKER.LEVELS") + " parts Knowledge\nExtra ingredients:\n 5 phantom membranes");
        pBook.setPages(pages);
        pOffE.setItemMeta(pBook);

    }

}
