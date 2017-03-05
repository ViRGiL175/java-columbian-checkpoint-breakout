package rape.brutal.virgil.breakout;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import rape.brutal.alex.evaluator.ApartmentBuilding;
import rape.brutal.alex.evaluator.ApartmentEvaluator;
import rape.brutal.alex.evaluator.BuildingType;
import rape.brutal.alex.evaluator.Helper;
import rape.brutal.haze.pc.constructor.Engineer;
import rape.brutal.punydevil.communications.infrastructure.ATS;
import rape.brutal.punydevil.communications.phone.Iphone;
import rape.brutal.punydevil.communications.phone.NoNamePhone;
import rape.brutal.punydevil.communications.phone.hardware.SIM;
import rape.brutal.punydevil.communications.users.User;
import rape.brutal.stephan.checkpoint.CheckPoint;
import rape.brutal.virgil.breakout.graphic.*;

import java.io.IOException;
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

    //    Graphic
    private TerminalScreen terminalScreen;
    private ATSGraphic ats1Graphic;
    private ATSGraphic ats2Graphic;
    private ATSGraphic ats3Graphic;
    private CarGraphic carGraphic;
    private CheckPointGraphic checkPointGraphic;
    private GarageGraphic garageGraphic;
    private MansionGraphic mansionGraphic;

    //    Gameplay
    private boolean exit;
    private int money = 10000;
    //    Buildings
    private ApartmentBuilding apartmentBuilding = Helper.build("Mexico, Taco st. 45-67",
            BuildingType.INDIVIDUAL, true, true, 1, true,
            true, 4, 4, 3);
    private ATS ats1 = new ATS();
    private ATS ats2 = new ATS();
    private ATS ats3 = new ATS();
    private CheckPoint mexicanCheckpoint = new CheckPoint(CHECKPOINT_HIT_POINTS, CHECKPOINT_DAMAGE);
    //    Characters
    private ApartmentEvaluator delgadoEvaluator = new ApartmentEvaluator();
    private Engineer carlosEngineer = new Engineer(/*new NoNamePhone(new SIM(ENGINEER_NUMBER))*/);
    private User gabrielaRebel = new User(new NoNamePhone(new SIM(GABRIELA_NUMBER)));
    private User fernandoBoss = new User(new Iphone(new SIM(FERNANDO_NUMBER)));

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
            mainMenu(terminalScreen);
            battleScreen(terminalScreen);
            terminalScreen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void battleScreen(TerminalScreen terminalScreen) {
        initGraphic(terminalScreen);
        while (!exit) {
            createNewCar(terminalScreen);
            driveCarToCheckpoint(terminalScreen);
            checkCar();
        }
    }

    private void checkCar() {
        if (!checkPointGraphic.isDestroyed()) {
            say(checkPointGraphic, "Let's check your car!");
            if (!isBreakout()) {
                if (!isLegal()) {
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
        carGraphic.setPassed(true);
        for (int i = 0; i < 42; i++) {
            TerminalPosition position = new TerminalPosition(carGraphic.getPosition().getColumn() + 1,
                    carGraphic.getPosition().getRow());
            carGraphic.setPosition(position);
            drawBattleScreen(terminalScreen);
        }
        carGraphic.setPassed(false);
        if (carGraphic.getClass() == BigCarGraphic.class) {
            say(this, "We sold drugs and bailed out " + 4000 + " peso.");
            money += 4000;
        }
        if (carGraphic.getClass() == BattleCarGraphic.class) {
            damageToMansion();
        }
    }

    private void damageToMansion() {
        String delPutoName = "Boss Ricardo del Puto";
        say(delPutoName, "My perfect mansion!!! Noo!!!");
        mansionGraphic.setDestroyed(true);
        drawBattleScreen(terminalScreen);
        tinyWait();
        drawBattleScreen(terminalScreen);
//        for (Apt apt : apts) {
//            if (car.getCondition() > apt.getCondition()) {
//                car.setCondition(apt.getCondition());
//                apt.condition = 0;
//                say(delPutoName, "No!!! My perfect " + apt.getName + "!!!");
//            }
//        }
//        if (apt.cost < 5000) {
//            say(delPutoName, "*Ricardo killed himself*");
//            win();
//        }
    }

    private boolean isLegal() {
        if (carGraphic.getClass() == AverageCarGraphic.class) {
            say(checkPointGraphic, "It's OK with your documents and goods.");
            return true;
        }
        say(checkPointGraphic, "I can't pass you though, it is illegal stuff...");
        return false;
    }


    private boolean breakout() {
        say(checkPointGraphic, "They breaking out!!!");
        say(carGraphic, "Die!");
        attack(carGraphic);
        attack(checkPointGraphic);
        checkPointGraphic.setDestroyed(true);
        drawBattleScreen(terminalScreen);
        tinyWait();
        drawBattleScreen(terminalScreen);
        return true;
//        while (checkpoint.getLaMorale() > 0) {
//            attack(carGraphic);
//            attack(checkPointGraphic);
//        }
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
        if (carGraphic.getClass() == AverageCarGraphic.class) {
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
            TerminalPosition position = new TerminalPosition(carGraphic.getPosition().getColumn() + 1,
                    carGraphic.getPosition().getRow());
            carGraphic.setPosition(position);
            drawBattleScreen(terminalScreen);
        }
    }

    private void createNewCar(TerminalScreen terminalScreen) {
        Random random = new Random();
        if (random.nextBoolean()) {
            buildCar(2000, new BigCarGraphic(DEFAULT_CAR_POSITION, "Mad El Burro", terminalScreen));
        } else if (random.nextBoolean()) {
            buildCar(2500, new BattleCarGraphic(DEFAULT_CAR_POSITION, "Mad Max", terminalScreen));
        } else {
            carGraphic = new AverageCarGraphic(DEFAULT_CAR_POSITION, "Fernando and Family", terminalScreen);
        }

        if (carGraphic.getClass() != AverageCarGraphic.class) {
            garageGraphic.setClosed(false);
            drawBattleScreen(terminalScreen);
            shortWait();
            drawBattleScreen(terminalScreen);
            garageGraphic.setClosed(true);
            say(garageGraphic, "Looks like new!");
            drawBattleScreen(terminalScreen);
        }
    }

    private void buildCar(int carCost, CarGraphic carGraphic) {
        say(garageGraphic, "Let's build it from true mexican garbage!");
        this.carGraphic = carGraphic;
        money -= carCost;
        say(garageGraphic, "It cost " + carCost + " for you, amigo!");
    }

    private void mainMenu(TerminalScreen terminalScreen) {

    }

    private void drawBattleScreen(TerminalScreen terminalScreen) {
        try {

            terminalScreen.newTextGraphics().putString(1, 0, money + " peso");

            garageGraphic.draw(new TerminalPosition(2, 6));

            ats1Graphic.draw(new TerminalPosition(16, 1));

            ats2Graphic.draw(new TerminalPosition(28, 4));

            ats3Graphic.draw(new TerminalPosition(44, 2));

            terminalScreen.newTextGraphics().drawLine(55, 0, 55, 6, '#');

            if ((carGraphic != null) && (!carGraphic.isPassed())) {
                terminalScreen.newTextGraphics().drawLine(0, 10, carGraphic.getPosition().getColumn(), 10, '.');
                carGraphic.draw(carGraphic.getPosition());
                terminalScreen.newTextGraphics().drawLine(carGraphic.getPosition().getColumn() + 6, 10, 53, 10, '.');
            } else {
                terminalScreen.newTextGraphics().drawLine(0, 10, DEFAULT_CAR_POSITION.getColumn(), 10, '.');
                terminalScreen.newTextGraphics().drawLine(DEFAULT_CAR_POSITION.getColumn() + 6, 10, 53, 10, '.');
            }

            terminalScreen.newTextGraphics().drawLine(57, 10, terminalScreen.getTerminalSize().getColumns(), 10, '.');

            checkPointGraphic.draw(new TerminalPosition(53, 7));

            mansionGraphic.draw(new TerminalPosition(terminalScreen.getTerminalSize().getColumns() - 15, 2));

            if ((carGraphic != null) && (carGraphic.isPassed())) {
                carGraphic.draw(carGraphic.getPosition());
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
            drawBattleScreen(terminalScreen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return "Gabriela";
    }
}
