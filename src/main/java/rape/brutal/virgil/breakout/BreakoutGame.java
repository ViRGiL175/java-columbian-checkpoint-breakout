package rape.brutal.virgil.breakout;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import rape.brutal.virgil.breakout.graphic.*;

import java.io.IOException;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by ViRGiL7 on 03.03.2017.
 * Project: columbian-checkpoint-breakout
 */
public class BreakoutGame {

    public static final TerminalPosition DEFAULT_CAR_POSITION = new TerminalPosition(2, 9);

    private TerminalScreen terminalScreen;
    private ATSGraphic ats1Graphic;
    private ATSGraphic ats2Graphic;
    private ATSGraphic ats3Graphic;
    private CarGraphic carGraphic;
    private CheckPointGraphic checkPointGraphic;
    private GarageGraphic garageGraphic;

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

    private void battleScreen(TerminalScreen terminalScreen) throws IOException {
        ats1Graphic = new ATSGraphic("ATS1", terminalScreen);
        ats2Graphic = new ATSGraphic("ATS2", terminalScreen);
        ats3Graphic = new ATSGraphic("ATS3", terminalScreen);
        checkPointGraphic = new CheckPointGraphic("Columbian Checkpoint", terminalScreen);
        garageGraphic = new GarageGraphic("Bandits Garage", terminalScreen);

        createNewCar(terminalScreen);

        driveCarToCheckpoint(terminalScreen);
    }

    private void driveCarToCheckpoint(TerminalScreen terminalScreen) throws IOException {
        for (int i = 0; i < 42; i++) {
            TerminalPosition position = new TerminalPosition(carGraphic.getPosition().getColumn() + 1,
                    carGraphic.getPosition().getRow());
            carGraphic.setPosition(position);
            drawBattleScreen(terminalScreen);
        }
    }

    private void createNewCar(TerminalScreen terminalScreen) throws IOException {
        Random random = new Random();
        if (random.nextBoolean()) {
            carGraphic = new BigCarGraphic(DEFAULT_CAR_POSITION, "Semyon and Family", terminalScreen);
        } else if (random.nextBoolean()) {
            carGraphic = new BattleCarGraphic(DEFAULT_CAR_POSITION, "Semyon and Family", terminalScreen);
        } else {
            carGraphic = new AverageCarGraphic(DEFAULT_CAR_POSITION, "Semyon and Family", terminalScreen);
        }

        if (carGraphic.getClass() != AverageCarGraphic.class) {
            garageGraphic.setClosed(false);
            drawBattleScreen(terminalScreen);
            shortWait();
            drawBattleScreen(terminalScreen);
            garageGraphic.setClosed(true);
            drawBattleScreen(terminalScreen);
            shortWait();
        }
    }

    private void mainMenu(TerminalScreen terminalScreen) {

    }

    private void drawBattleScreen(TerminalScreen terminalScreen) throws IOException {

        garageGraphic.draw(new TerminalPosition(2, 6));

        ats1Graphic.draw(new TerminalPosition(16, 1));

        ats2Graphic.draw(new TerminalPosition(28, 4));

        ats3Graphic.draw(new TerminalPosition(44, 2));

        terminalScreen.newTextGraphics().drawLine(55, 0, 55, 6, '#');

        if (carGraphic != null) {
            terminalScreen.newTextGraphics().drawLine(0, 10, carGraphic.getPosition().getColumn(), 10, '.');
            carGraphic.draw(carGraphic.getPosition());
            terminalScreen.newTextGraphics().drawLine(carGraphic.getPosition().getColumn() + 6, 10, 53, 10, '.');
        } else {
            terminalScreen.newTextGraphics().drawLine(0, 10, DEFAULT_CAR_POSITION.getColumn(), 10, '.');
            terminalScreen.newTextGraphics().drawLine(DEFAULT_CAR_POSITION.getColumn() + 6, 10, 53, 10, '.');
        }

        terminalScreen.newTextGraphics().drawLine(57, 10, terminalScreen.getTerminalSize().getColumns(), 10, '.');

        checkPointGraphic.draw(new TerminalPosition(53, 7));

        terminalScreen.newTextGraphics().drawLine(55, 12, 55, terminalScreen.getTerminalSize().getRows(), '#');

        terminalScreen.newTextGraphics().drawLine(0, 13, 53, 13, '.');

        terminalScreen.newTextGraphics().drawLine(57, 13, terminalScreen.getTerminalSize().getColumns(), 13, '.');

        terminalScreen.refresh();

        tinyWait();

    }

    private void tinyWait() {
        try {
            sleep(200);
        } catch (InterruptedException var1) {
            var1.printStackTrace();
        }
    }

    private void shortWait() {
        try {
            sleep(500);
        } catch (InterruptedException var1) {
            var1.printStackTrace();
        }
    }
}
