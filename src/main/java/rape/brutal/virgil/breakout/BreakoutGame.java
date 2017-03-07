package rape.brutal.virgil.breakout;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import rape.brutal.alex.evaluator.Builder;
import rape.brutal.alex.evaluator.Evaluator;
import rape.brutal.alex.evaluator.building.ApartmentBuilding;
import rape.brutal.alex.evaluator.building.BuildingType;
import rape.brutal.haze.pc.constructor.Engineer;
import rape.brutal.haze.pc.constructor.TechItem;
import rape.brutal.punydevil.communications.infrastructure.ATS;
import rape.brutal.punydevil.communications.infrastructure.IConnector;
import rape.brutal.punydevil.communications.phone.Iphone;
import rape.brutal.punydevil.communications.phone.NoNamePhone;
import rape.brutal.punydevil.communications.phone.Phone;
import rape.brutal.punydevil.communications.phone.hardware.SIM;
import rape.brutal.punydevil.communications.users.User;
import rape.brutal.stephan.checkpoint.CheckPoint;
import rape.brutal.stephan.checkpoint.auto.*;
import rape.brutal.virgil.breakout.graphic.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by ViRGiL7 on 03.03.2017.
 * Project: columbian-checkpoint-breakout
 */
public class BreakoutGame implements INameable {

    public static final TerminalPosition DEFAULT_CAR_POSITION = new TerminalPosition(2, 9);
    public static final int GABRIELA_NUMBER = 4567;
    public static final int FERNANDO_NUMBER = 674566;
    public static final int ENGINEER_NUMBER = 837687;
    public static final int CHECKPOINT_HIT_POINTS = 500;
    public static final int CHECKPOINT_DAMAGE = 400;
    public static final String GABRIELA_NAME = "Gabriela";
    public static final String FERNANDO_NAME = "Fernando del Boss";
    public static final int CHECKPOINT_MORALITY = 1000;
    public static final int ARTILLERY_NUMBER = 45454;
    public static final int PLAYER_NUMBER = 68568;
    public static final String YOU_NAME = "You";
    public static final int MAD_MAX_HIT_POINTS = 500;
    public static final int MAD_MAX_MORALITY = 400;
    public static final int BIG_AUTO_HIT_POINTS = 200;
    public static final int BIG_AUTO_MORALITY = 200;
    public static final int MAD_MAX_DAMAGE = 1000;
    public static final String ENGINEER_NAME = "Carlos del Ingenegro";
    public static final int BIG_AUTO_DAMAGE = 500;
    public static final int MANSION_HIT_POINTS = 1000;
    public static final int EVALUATOR_NUMBER = 634356;
    public static final int START_MONEY = 100000000;
    public static final boolean IS_DEBUG = true;

    //    Graphic
    private TerminalScreen terminalScreen;
    private ATSGraphic ats1Graphic;
    private ATSGraphic ats2Graphic;
    private ATSGraphic ats3Graphic;
    private AutoGraphic autoGraphic;
    private CheckPointGraphic checkPointGraphic;
    private GarageGraphic garageGraphic;
    private MansionGraphic mansionGraphic;
    //    Gameplay
    private boolean exit;
    private int money = START_MONEY;
    //    Buildings
    private ApartmentBuilding bossMansionBuilding = Builder.build("Mexico, Taco st. 45-67",
            BuildingType.INDIVIDUAL, true, true, 1, 3, 4, true,
            true, MANSION_HIT_POINTS);
    private DestroyableATS ats1 = new DestroyableATS(1000, ats1Graphic);
    private DestroyableATS ats2 = new DestroyableATS(40000, ats2Graphic);
    private DestroyableATS ats3 = new DestroyableATS(300, ats3Graphic);
    private ArrayList<DestroyableATS> destroyableATSS = new ArrayList<>();
    private ArrayList<IConnector> iConnectors = new ArrayList<>();
    private CheckPoint mexicanCheckpoint = new CheckPoint(CHECKPOINT_HIT_POINTS, CHECKPOINT_DAMAGE, CHECKPOINT_MORALITY);
    //    Characters
    private Iphone evaluatorPhone = new Iphone(new SIM(EVALUATOR_NUMBER));
    private Evaluator delgadoEvaluator = new Evaluator(evaluatorPhone, bossMansionBuilding);
    private NoNamePhone engineerPhone = new NoNamePhone(new SIM(ENGINEER_NUMBER));
    private Engineer carlosEngineer = new Engineer(engineerPhone);
    private NoNamePhone gabrielaPhone = new NoNamePhone(new SIM(GABRIELA_NUMBER));
    private User gabrielaRebel = new User(gabrielaPhone);
    private Iphone playerIphone = new Iphone(new SIM(PLAYER_NUMBER));
    private User player = new User(playerIphone);
    private Iphone fernandoIphone = new Iphone(new SIM(FERNANDO_NUMBER));
    private User fernandoBoss = new User(new Iphone(new SIM(FERNANDO_NUMBER)));
    private Iphone artilleryIphone = new Iphone(new SIM(ARTILLERY_NUMBER));
    private ArtilleryUser gonsalesDelArtillerist = new ArtilleryUser(artilleryIphone, destroyableATSS);
    private Auto auto;

    {
        iConnectors.add(ats1);
        iConnectors.add(ats2);
        iConnectors.add(ats3);
    }

    public BreakoutGame() {
        try {
            DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
            Terminal terminal = defaultTerminalFactory.createTerminal();
            terminalScreen = new TerminalScreen(terminal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAllASCII() {
        for (int i = 0; i < 255; i++) {
            System.out.println(Character.toString((char) i) + " : " + i);
        }
    }

    public void start() {
        try {
            terminalScreen.startScreen();
            if (!IS_DEBUG) {
                mainMenu(terminalScreen);
            }
            battleScreen(terminalScreen);
            terminalScreen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void battleScreen(TerminalScreen terminalScreen) {
        terminalScreen.clear();
        if (!IS_DEBUG) {
            say(this, "Hola un amigo.");
            say(this, "I'm a Gabr-r-riela.");
            say(this, "Les puto no time to explain!");
            say(this, "We should br-r-reaks out this checkpoint!");
            say(this, "And kill all those cabrons-diese-Madr-r-re-puto-Victoria!");
            say(FERNANDO_NAME, "You never-r-r destroy my perfect mansion!");
            say(FERNANDO_NAME, "Ha-ha-ha!");
            say(this, "We can use only our hacked ATS stations!");
            say(this, "Carlos del Engineegro can build battle cars for us!");
            say(this, "Call him!");
            say(this, "But you need a lot of pesos...");
        }
        initGraphic(terminalScreen);
        while (!exit) {
            initMobileNetwork();
            auto = null;
            say(YOU_NAME, "Hey! Are you hear me? I need a good car...");
            say(ENGINEER_NAME, "No hay pr-r-roblema!");
            char autoChoice = ' ';
            String autoName = null;
            TechItem techItem = null;
            if (new Random().nextBoolean()) {
                say(this, "Pr-r-ress 1 for Battle Car of 2 for Tr-r-ruck");
                while ((autoChoice != '1') && (autoChoice != '2'))
                    try {
                        autoChoice = terminalScreen.readInput().getCharacter();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                int cost = 0;
                switch (autoChoice) {
                    case '1':
                        autoName = MadMaxAuto.NAME;
                        cost = MadMaxAuto.COST;
                        techItem = new MadMaxAuto(MAD_MAX_HIT_POINTS, makeDocuments(), MAD_MAX_MORALITY);
                        break;
                    case '2':
                        autoName = BigAuto.NAME;
                        cost = BigAuto.COST;
                        techItem = new BigAuto(BIG_AUTO_HIT_POINTS, makeDocuments(), BIG_AUTO_MORALITY);
                        break;
                    default:
                        auto = new OrdinaryAuto(1, makeDocuments(), 500);
                }

//                Not working
//                player.call(ENGINEER_NUMBER, autoName);
//                carlosEngineer.createItem(cost, autoName);
//                TechItem techItem = carlosEngineer.getTechItem();
                String itemName = techItem.getItemName();
                if (itemName.equals(MadMaxAuto.NAME)) {
                    auto = (MadMaxAuto) techItem;
//                    auto.setDocuments(makeDocuments());
//                    auto.setHitPoints(MAD_MAX_HIT_POINTS);
//                    auto.setMorality(MAD_MAX_MORALITY);
//                    auto.setDamage(MAD_MAX_DAMAGE);
                } else if (itemName.equals(BigAuto.NAME)) {
                    auto = (BigAuto) techItem;
//                    auto.setDocuments(makeDocuments());
//                    auto.setHitPoints(BIG_AUTO_HIT_POINTS);
//                    auto.setMorality(BIG_AUTO_MORALITY);
//                    auto.setDamage(BIG_AUTO_DAMAGE);
                }
            } else {
                say(ENGINEER_NAME, "Sh-h-h... Wait! Look!");
                auto = new OrdinaryAuto(1, makeDocuments(), 500);
            }
            createNewCar(terminalScreen);
            driveCarToCheckpoint(terminalScreen);
            checkAuto();
        }
    }

    private String makeDocuments() {
        return new Random().nextBoolean() ? "ИГИЛ" : "Correct";
    }

    private void initMobileNetwork() {
        if (iConnectors.size() > 0) {
            IConnector iConnector = iConnectors.get(new Random().nextInt(iConnectors.size() - 1));
            if (iConnector != null) {
                engineerPhone.addATSs(iConnectors);
                playerIphone.addATSs(iConnectors);
                gabrielaPhone.addATSs(iConnectors);
                fernandoIphone.addATSs(iConnectors);
                artilleryIphone.addATSs(iConnectors);
                evaluatorPhone.addATSs(iConnectors);
            }
        } else {
            loseBecauseOfATS();
        }
    }

    private void loseBecauseOfATS() {
        say(this, "We lost all ATS in this area...");
        System.exit(0);
    }

    private void checkAuto() {
        if (!checkPointGraphic.isDestroyed()) {
            say(checkPointGraphic, "Let's check your car!");
            if (!isBreakout()) {
                mexicanCheckpoint.setAuto(auto);
                boolean legal = mexicanCheckpoint.checkAuto();
                if (!legal) {
                    if (breakout()) {
                        passThough();
                    }
                } else {
                    passThough();
                }
            } else {
                breakout();
            }
        } else {
            passThough();
            mansionGraphic.setDestroyed(true);
            drawBattleScreen(terminalScreen);
        }
    }

    private void passThough() {
        checkPointGraphic.setClosed(false);
        drawBattleScreen(terminalScreen);
        shortWait();
        driveCarThoughCheckpoint();
        shortWait();
        checkPointGraphic.setClosed(true);
        drawBattleScreen(terminalScreen);
    }

    private void driveCarThoughCheckpoint() {
        autoGraphic.setPassed(true);
        for (int i = 0; i < 42; i++) {
            TerminalPosition position = new TerminalPosition(autoGraphic.getPosition().getColumn() + 1,
                    autoGraphic.getPosition().getRow());
            autoGraphic.setPosition(position);
            drawBattleScreen(terminalScreen);
        }
        autoGraphic.setPassed(false);
        if (autoGraphic.getClass() == BigAutoGraphic.class) {
            say(this, "We sold dr-r-rugs and bailed out " + 4000 + " peso.");
            money += 4000;
        }
        if (autoGraphic.getClass() == BattleAutoGraphic.class) {
            damageToMansion();
        }
    }

    private void damageToMansion() {
        say(FERNANDO_NAME, "My perfect mansion!!! Noo!!!");
        say(autoGraphic, "Let's destroy everything!!!");
        bossMansionBuilding.makeDamage(auto.getDamage());
        if (bossMansionBuilding.isDestroyed()) {
            mansionGraphic.setDestroyed(true);
            drawBattleScreen(terminalScreen);
            tinyWait();
            drawBattleScreen(terminalScreen);
            mansionWin();
        }
        say(this, "Good! Goood!!! Let's do another tr-r-ry!");
        fernandoBoss.call(EVALUATOR_NUMBER, bossMansionBuilding.getAddress());
        say(FERNANDO_NAME, "Mierda! Mierda! Mierda! It costs only " + delgadoEvaluator.getLastValue() + " pesos!");
        fernandoBoss.call(ARTILLERY_NUMBER, ArtilleryUser.FUCK_ATS_UP);
        say(gonsalesDelArtillerist, "Fire!");
        for (DestroyableATS destroyableATS : destroyableATSS) {
            if (destroyableATS.isDestroyed()) {
                destroyableATSS.remove(destroyableATS);
            }
        }
    }

    private void mansionWin() {
        say(FERNANDO_NAME, "My mansion...");
        say(FERNANDO_NAME, "*Ricardo killed himself*");
        System.exit(0);
    }

    private boolean isLegal() {
        if (autoGraphic.getClass() == AverageAutoGraphic.class) {
            say(checkPointGraphic, "It's OK with your documents and goods.");
            return true;
        }
        say(checkPointGraphic, "I can't pass you though, it is illegal stuff...");
        return false;
    }


    private boolean breakout() {
        say(checkPointGraphic, "They breaking out!!!");
        say(autoGraphic, "Die!");
        attack(autoGraphic);
        attack(checkPointGraphic);
        if (mexicanCheckpoint.isDestroyed()) {
            say(checkPointGraphic, "No!!! We diablo les dying bastar-r-rds!");
            checkPointGraphic.setDestroyed(true);
            drawBattleScreen(terminalScreen);
            tinyWait();
            drawBattleScreen(terminalScreen);
            return true;
        }
        if (mexicanCheckpoint.getMorality() <= 0) {
            say(checkPointGraphic, "R-r-run for your lives!!!");
            say(autoGraphic, "Haha! Suckar-r-rs!");
            return true;
        }
        auto = null;
        drawBattleScreen(terminalScreen);
        return false;
    }

    private void attack(ASCIIGraphic asciiGraphic) {
        asciiGraphic.setAttack(true);
        drawBattleScreen(terminalScreen);
        tinyWait();
        asciiGraphic.setAttack(false);
        drawBattleScreen(terminalScreen);
        tinyWait();
    }

    private boolean isBreakout() {
        if (autoGraphic.getClass() == AverageAutoGraphic.class) {
            return false;
        }
        try {
            say(this, "Should we breaks though? (Enter / n)");
            KeyStroke keyStroke = terminalScreen.readInput();
            return keyStroke.getKeyType() == KeyType.Enter;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void initGraphic(TerminalScreen terminalScreen) {
        ats1Graphic = new ATSGraphic("ATS1", terminalScreen);
        ats2Graphic = new ATSGraphic("ATS2", terminalScreen);
        ats3Graphic = new ATSGraphic("ATS3", terminalScreen);
        checkPointGraphic = new CheckPointGraphic("Columbian Checkpoint", terminalScreen);
        garageGraphic = new GarageGraphic("El Cabrons Garage", terminalScreen);
        mansionGraphic = new MansionGraphic("Fernando", terminalScreen);
    }

    private void driveCarToCheckpoint(TerminalScreen terminalScreen) {
        for (int i = 0; i < 42; i++) {
            TerminalPosition position = new TerminalPosition(autoGraphic.getPosition().getColumn() + 1,
                    autoGraphic.getPosition().getRow());
            autoGraphic.setPosition(position);
            drawBattleScreen(terminalScreen);
        }
    }

    private void createNewCar(TerminalScreen terminalScreen) {
        if (auto instanceof BigAuto) {
            buildCar(BigAuto.COST, new BigAutoGraphic(DEFAULT_CAR_POSITION, "Mad El Burro", terminalScreen));
        } else if (auto instanceof MadMaxAuto) {
            buildCar(MadMaxAuto.COST, new BattleAutoGraphic(DEFAULT_CAR_POSITION, "Mad Max", terminalScreen));
        } else {
            autoGraphic = new AverageAutoGraphic(DEFAULT_CAR_POSITION, "Mario and family", terminalScreen);
        }

        if (autoGraphic.getClass() != AverageAutoGraphic.class) {
            garageGraphic.setClosed(false);
            drawBattleScreen(terminalScreen);
            shortWait();
            drawBattleScreen(terminalScreen);
            garageGraphic.setClosed(true);
            say(garageGraphic, "Looks like new!");
            drawBattleScreen(terminalScreen);
        }
    }

    private void buildCar(int carCost, AutoGraphic autoGraphic) {
        say(garageGraphic, "Let's build it from true mexican gar-r-rbage! Ar-r-riva!");
        this.autoGraphic = autoGraphic;
        money -= carCost;
        if (money <= 0) {
            loseBecauseOfMoney();
        }
        say(garageGraphic, "It cost " + carCost + " for you, amigo!");
    }

    private void loseBecauseOfMoney() {
        say(this, "You spend all our pesos!!! I kill you!");
        longWait();
        System.exit(0);
    }

    private void mainMenu(TerminalScreen terminalScreen) throws IOException {
        System.out.println(terminalScreen.getTerminalSize().getColumns());
        int bias = 0;
        int i = 0;
        int row = 3;
        int end = 0;
        while (end != 3) {
            String s1 = "                 //\\  ///\\  /    /   /   /    /  ///\\   \"    /\\    /\\  /  //////////             ///////         //    //          // /////////////////                 \n";
            String s2 = "                 /    /  /  /    /   /   /\\  //  /__/   /   ///\\   / \\ /  //       ///        ////     ///       //    ///         //        //                         \n";
            String s3 = "                 \\//  \\///  ///  \\///    / \\/ /  /__/   /  /    \\  /  \\/  //        ///     ///          ///     //    ////        //        //                         \n";
            String s4 = "                                                                          //         //    ///            ///    //    // //       //        //       //                \n";
            String s5 = "                   /////.  //      //   ////////    /////.  //     //     //         //   ///              ///   //    //  //      //              //////               \n";
            String s6 = "                 //        //      //   //        //        //   //       //       ///    ///              ///   //    //   /  ///  /        /    //////                \n";
            String s7 = "                //         //      //   //       //         // //         //////////      ///              ///   //    //     ///   /  //   //  /   //                  \n";
            String s8 = "                /          //////////   ///////  /          ///,          //              ///              ///   //    //     //      //// //  //  //                   \n";
            String s9 = "                /          //      //   //       /          //  //        //               ///            ///    //           //  // //  / //  //  //                   \n";
            String s10 = "                //         //      //   //       //         //   //       //                ///   ////   ///           ////   // //  /   ////  /////// //               \n";
            String s11 = "                 //        //      //   //        //        //    //      //                 //  /// //         ////  // ///  ////   // // //// /  ////                 \n";
            String s12 = "                  //////.  //      //   ////////   //////.  //     //     //                    //  //  /////  // // //   // / ////   ///                               \n";
            String s13 = "                                                                                                   //  ////   ////   /  // //  /  ///                                   \n";
            String s14 = "                                                                                                 //////  //   //  //  //                                                \n";
            String s15 = "                                                                                                  /  // // //  ///                                                      \n";
            String s16 = "                                                                                                  / //  ///                                                             \n";
            String s17 = "                                                                                                  ///                                                                   \n";
            terminalScreen.newTextGraphics().putString(0, row + 1, s1.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 2, s2.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 3, s3.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 4, s4.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 5, s5.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 6, s6.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 7, s7.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 8, s8.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 9, s9.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 10, s10.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 11, s11.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 12, s12.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 13, s13.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 14, s14.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 15, s15.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 16, s16.substring(bias, 80 + bias));
            terminalScreen.newTextGraphics().putString(0, row + 17, s17.substring(bias, 80 + bias));
            terminalScreen.refresh();
            microWait();
            if (bias > 80) {
                i = -1;
            } else if (bias <= 0) {
                i = 1;
                end++;
            }
            bias += i;
        }

        terminalScreen.clear();
        terminalScreen.newTextGraphics().putString(10, 17, "Press Enter to start", SGR.BLINK);
        terminalScreen.refresh();

        KeyStroke keyStroke = terminalScreen.readInput();
        while (keyStroke.getKeyType() != KeyType.Enter) {
            keyStroke = terminalScreen.readInput();
            terminalScreen.clear();
        }
    }

    private void drawBattleScreen(TerminalScreen terminalScreen) {
        try {

            terminalScreen.newTextGraphics().putString(1, 0, money + " peso");

            garageGraphic.draw(new TerminalPosition(2, 6));

            ats1Graphic.draw(new TerminalPosition(16, 1));

            ats2Graphic.draw(new TerminalPosition(28, 4));

            ats3Graphic.draw(new TerminalPosition(44, 2));

            terminalScreen.newTextGraphics().drawLine(55, 0, 55, 6, '#');

            if ((autoGraphic != null) && (!autoGraphic.isPassed())) {
                terminalScreen.newTextGraphics().drawLine(0, 10, autoGraphic.getPosition().getColumn(), 10, '.');
                autoGraphic.draw(autoGraphic.getPosition());
                terminalScreen.newTextGraphics().drawLine(autoGraphic.getPosition().getColumn() + 6, 10, 53, 10, '.');
            } else {
                terminalScreen.newTextGraphics().drawLine(0, 10, DEFAULT_CAR_POSITION.getColumn(), 10, '.');
                terminalScreen.newTextGraphics().drawLine(DEFAULT_CAR_POSITION.getColumn() + 6, 10, 53, 10, '.');
            }

            terminalScreen.newTextGraphics().drawLine(57, 10, terminalScreen.getTerminalSize().getColumns(), 10, '.');

            checkPointGraphic.draw(new TerminalPosition(53, 7));

            mansionGraphic.draw(new TerminalPosition(terminalScreen.getTerminalSize().getColumns() - 15, 2));

            if ((autoGraphic != null) && (autoGraphic.isPassed())) {
                autoGraphic.draw(autoGraphic.getPosition());
            }

            terminalScreen.newTextGraphics().drawLine(55, 12, 55, terminalScreen.getTerminalSize().getRows(), '#');

            terminalScreen.newTextGraphics().drawLine(0, 13, 53, 13, '.');

            terminalScreen.newTextGraphics().drawLine(57, 13, terminalScreen.getTerminalSize().getColumns(), 13, '.');

            terminalScreen.refresh();

            tinyWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void tinyWait() {
        try {
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void shortWait() {
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void longWait() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void microWait() {
        try {
            sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void say(INameable iNameable, String text) {
        String name = iNameable.getName();
        say(name, text);
    }

    public void say(String name, String text) {
        try {
            terminalScreen.newTextGraphics().putString(3, 20, name + ": " + text);
            terminalScreen.refresh();
            longWait();
            terminalScreen.clear();
//            drawBattleScreen(terminalScreen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return GABRIELA_NAME;
    }
}

class DestroyableATS extends ATS implements IDestruyable {

    private int hitPoints;
    private ATSGraphic atsGraphic;
    private boolean destroyed;

    public DestroyableATS(int hitPoints, ATSGraphic atsGraphic) {
        this.hitPoints = hitPoints;
        this.atsGraphic = atsGraphic;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void makeDamage(int i) {
        hitPoints -= i;
        if (hitPoints <= 0) {
            destroyed = true;
            atsGraphic.setDestroyed(true);
        }
    }
}

class ArtilleryUser extends User implements INameable {

    public static final String FUCK_ATS_UP = "FUCK_ATS_UP";
    public static final String NAME = "Huan Mortira";
    private final List<DestroyableATS> iDestruyables;
    private int damage = 500;

    public ArtilleryUser(Phone userPhone, List<DestroyableATS> destroyableATSS) {
        super(userPhone);
        this.iDestruyables = destroyableATSS;
    }

    @Override
    public void hear(String text, int contactNumber) {
        super.hear(text, contactNumber);
        switch (text) {
            case FUCK_ATS_UP:
                iDestruyables.get(new Random().nextInt(iDestruyables.size())).makeDamage(damage);
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}
