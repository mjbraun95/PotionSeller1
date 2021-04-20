//package PotionMaker3;

import java.awt.*;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.api.Keyboard;
import org.osbot.rs07.api.Bank;
import org.osbot.rs07.api.GrandExchange;
import org.osbot.rs07.api.Inventory;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.utility.ConditionalSleep;
import org.osbot.rs07.api.model.NPC;

@ScriptManifest(author = "mjbraun95", info = "sells potions", logo = "", name = "PotionSeller", version = 1.0)
public class PotionSeller extends Script {
    //    public Inventory inv;
//    public String ingredientType;
//    public String bowType;
//    public RS2Object banker;
    public Bank bank;
    public GrandExchange exchange;
    public String ingredientType = "Lantadyme";
    public String unfPotionType = "Vial of water";
//    public String constantItem1 = "Vial of water";
    public char herbloreKey = ' ';
    //    public void getInv() {
//        inv = getInventory();
//    }
    public void slep(int ms) {
        new ConditionalSleep(ms) {
            @Override
            public boolean condition() {
//                        return !getInventory().isFull();
                return false;
            }
        }.sleep();
    }



//    public void buy(String item, int price, int quantity) throws InterruptedException {
//
//
////        GrandExchange GE = new GrandExchange(); //new GrandExchange instance with our script
//        if (!getGrandExchange().isOpen()) { //Checks if ge is open
//            NPC clerk = getNpcs.closest("Grand Exchange Clerk");
//            if (clerk!=null) {
//
//                clerk.interact("Exchange");
//
//            } //open ge randomly using booth or npc
//        } else {
//            GE.collectItems(false); //collect items (boolean true -> to bank, false -> inventory)
//            GE.createBuyOffer(item, price, quantity); //creates a buy offer with specified params
////            GE.createSellOffer(item, price, quantity); //Sells all of the specified items in inventory at specified price ( 0 = all, int = specified amount)
//        }
//        return 150;
//        exchange = getGrandExchange();
//        exchange.buyItem(93, "Marrentil potion (unf)", 20, quantity);
//        sleep(random(700,1300));
//
//        do {
//            sleep(random(700,1300));
//        }
//        while (grandExchange.getStatus(GrandExchange.Box.BOX_1) == GrandExchange.Status.PENDING_BUY);
//        grandExchange.collect();
//    }

    @Override
    public void onStart() {
        int herblore_level = getSkills().getVirtualLevel(Skill.HERBLORE);
        log("herblore level: " + herblore_level);
        if (herblore_level >= 76) {
            log("Herblore high enough!");
        }
        else {
            log("Herblore too low!!");
        }
        log("started!");
//        Scanner user_in = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter log type");

//        ingredientType = user_in.nextLine();  // Read user input
        log("Ingredient type is: " + ingredientType);  // Output user input
//        banker = getObjects().closest("Banker");
//        if (getObjects().closest("Banker") != null) {
//            log("banker is present!");
//            bank.getBank();
//        }
//        else {
//            log("banker is not present. Exiting");
////            System.exit(1);
//        }
    }
    //    getExperience(Skill skill)



    @Override
    public int onLoop() throws InterruptedException {
//		banker.interact("Bank");
        bank = getBank();
//        if !bank.contains(constantItem1) {
//
//        }
        bank.open();
        sleep(random( random(112,130), random(141,150)) );
        bank.depositAll();
        sleep(random( random(112,130), random(141,150)) );
//        bank.withdraw(unfPotionType, 14);
        bank.withdraw(unfPotionType, 14);
        sleep(random( random(112,130), random(141,150)) );
        bank.withdraw(ingredientType, 14);
        sleep(random( random(112,130), random(141,150)) );
        bank.close();
        if (!getInventory().contains(ingredientType) || !getInventory().contains(unfPotionType)) {
            log("did not successfully withdraw.");
//            System.exit(1);

            if (!getInventory().contains(ingredientType)) {
                sleep(random( random(112,130), random(141,150)) );
                log("did not successfully withdraw:" + ingredientType);
//                buy(ingredientType,20,280);

            }
            if (!getInventory().contains(unfPotionType)) {
                sleep(random( random(112,130), random(141,150)) );
                log("did not successfully withdraw:" + unfPotionType);
//                buy(unfPotionType, 20, 280);
            }
            return 93;
        }
        else {
            log("Withdrew items successfully!");
        }
//        if(!getInventory().isFull()) {
//            log("Inventory not full");
//        }
//        else {
//            log("Inventory full");
//        }
//        if(getInventory().isEmpty()) {
//            log("Inventory empty");
//        }
//        else {
//            log("Inventory not empty");
//        }
        getInventory().getItem(unfPotionType).interact("Use");;
        sleep(random( random(112,130), random(141,150)) );
        getInventory().getItem(ingredientType).interact();
        sleep(random( random(812,830), random(841,850)) );
//        new ConditionalSleep(5000) {
//            @Override
//            public boolean condition() {
////                        return !getInventory().isFull();
//                return false;
//            }
//        }.sleep();

        keyboard.typeKey(herbloreKey);

        sleep(random( random(712,730), random(741,758)) );
//        new ConditionalSleep(49000) {
//            @Override
//            public boolean condition() {
//                return !myPlayer().isAnimating();
//            }
//        }.sleep();
//        sleep(random(223,369));
        int previous_herblore_level = getSkills().getVirtualLevel(Skill.HERBLORE);
        log("previous_herblore_level: " + previous_herblore_level);
        int i = 6;
        while (i >= 0) {
            int herblore_level = getSkills().getVirtualLevel(Skill.HERBLORE);
            if (herblore_level > previous_herblore_level) {
                i = -1;
            }
            i = i-1;
            sleep(random(992,1008));
        }

//        sleep(random(25798,26242));
//        sleep(random(4000,20000));
//        new ConditionalSleep(5000) {
//            @Override
//            public boolean condition() {
////                        return !getInventory().isFull();
//                return false;
//            }
//        }.sleep();
        return 500;
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onPaint(Graphics2D g) {
//        g.drawString("Hello World", 50, 50);
    }
}
