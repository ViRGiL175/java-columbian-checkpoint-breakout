package rape.brutal.virgil.breakout;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import rape.brutal.virgil.breakout.graphic.ATSGraphic;
import rape.brutal.virgil.breakout.graphic.AverageCarGraphic;
import rape.brutal.virgil.breakout.graphic.CarGraphic;
import rape.brutal.virgil.breakout.graphic.CheckPointGraphic;

import java.io.IOException;

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
        carGraphic = new AverageCarGraphic(DEFAULT_CAR_POSITION, "Semyon and Family",
                terminalScreen);
        drawBattleScreen(terminalScreen);
    }

    private void mainMenu(TerminalScreen terminalScreen) {

    }

    private void drawBattleScreen(TerminalScreen terminalScreen) throws IOException {

        ats1Graphic.draw(new TerminalPosition(6, 1));

        ats2Graphic.draw(new TerminalPosition(21, 4));

        ats3Graphic.draw(new TerminalPosition(44, 2));

        terminalScreen.newTextGraphics().drawLine(55, 0, 55, 6, '#');

        terminalScreen.newTextGraphics().drawLine(0, 10, DEFAULT_CAR_POSITION.getColumn(), 10, '.');

        carGraphic.draw(carGraphic.getPosition());

        terminalScreen.newTextGraphics().drawLine(DEFAULT_CAR_POSITION.getColumn() + 6, 10, 53, 10, '.');

        terminalScreen.newTextGraphics().drawLine(57, 10, terminalScreen.getTerminalSize().getColumns(), 10, '.');

        checkPointGraphic.draw(new TerminalPosition(53, 7));

        terminalScreen.newTextGraphics().drawLine(55, 12, 55, terminalScreen.getTerminalSize().getRows(), '#');

        terminalScreen.newTextGraphics().drawLine(0, 13, 53, 13, '.');

        terminalScreen.newTextGraphics().drawLine(57, 13, terminalScreen.getTerminalSize().getColumns(), 13, '.');

    }
}
