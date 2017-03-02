package rape.brutal.virgil.breakout;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import rape.brutal.virgil.breakout.graphic.ATSGraphicObject;
import rape.brutal.virgil.breakout.graphic.BattleCarGraphicObject;
import rape.brutal.virgil.breakout.graphic.BigCarGraphicObject;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        printAllASCII();

        try {
            DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
            Terminal terminal = defaultTerminalFactory.createTerminal();
            TerminalScreen terminalScreen = new TerminalScreen(terminal);
            TerminalPosition cursorPosition = terminalScreen.getCursorPosition();

            terminalScreen.startScreen();

            ATSGraphicObject atsGraphicObject = new ATSGraphicObject("ATS", terminalScreen);
            atsGraphicObject.draw(cursorPosition.withRelative(6, 1));

            BattleCarGraphicObject battleCarGraphicObject = new BattleCarGraphicObject("MadMax", terminalScreen);
            battleCarGraphicObject.draw(cursorPosition.withRelative(15, 4));

            BigCarGraphicObject bigCarGraphicObject = new BigCarGraphicObject("BigCar", terminalScreen);
            bigCarGraphicObject.draw(cursorPosition.withRelative(8, 8));

            terminalScreen.refresh();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void printAllASCII() {
        for (int i = 0; i < 255; i++) {
            System.out.println(Character.toString((char) i) + " : " + i);
        }
    }

    private static void terminalDemo() {
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        Terminal terminal = null;
        try {

            terminal = defaultTerminalFactory.createTerminal();
            terminal.putCharacter('H');
            terminal.putCharacter('e');
            terminal.putCharacter('l');
            terminal.putCharacter('l');
            terminal.putCharacter('o');
            terminal.putCharacter('\n');
            terminal.flush();
            Thread.sleep(2000);

            TerminalPosition startPosition = terminal.getCursorPosition();
            terminal.setCursorPosition(startPosition.withRelativeColumn(3).withRelativeRow(2));
            terminal.flush();
            Thread.sleep(2000);

            terminal.setBackgroundColor(TextColor.ANSI.BLUE);
            terminal.setForegroundColor(TextColor.ANSI.YELLOW);

            terminal.putCharacter('Y');
            terminal.putCharacter('e');
            terminal.putCharacter('l');
            terminal.putCharacter('l');
            terminal.putCharacter('o');
            terminal.putCharacter('w');
            terminal.putCharacter(' ');
            terminal.putCharacter('o');
            terminal.putCharacter('n');
            terminal.putCharacter(' ');
            terminal.putCharacter('b');
            terminal.putCharacter('l');
            terminal.putCharacter('u');
            terminal.putCharacter('e');
            terminal.flush();
            Thread.sleep(2000);

            terminal.setCursorPosition(startPosition.withRelativeColumn(3).withRelativeRow(3));
            terminal.flush();
            Thread.sleep(2000);
            terminal.enableSGR(SGR.BOLD);
            terminal.putCharacter('Y');
            terminal.putCharacter('e');
            terminal.putCharacter('l');
            terminal.putCharacter('l');
            terminal.putCharacter('o');
            terminal.putCharacter('w');
            terminal.putCharacter(' ');
            terminal.putCharacter('o');
            terminal.putCharacter('n');
            terminal.putCharacter(' ');
            terminal.putCharacter('b');
            terminal.putCharacter('l');
            terminal.putCharacter('u');
            terminal.putCharacter('e');
            terminal.flush();
            Thread.sleep(2000);

            terminal.resetColorAndSGR();
            terminal.setCursorPosition(terminal.getCursorPosition().withColumn(0).withRelativeRow(1));
            terminal.putCharacter('D');
            terminal.putCharacter('o');
            terminal.putCharacter('n');
            terminal.putCharacter('e');
            terminal.putCharacter('\n');
            terminal.flush();

            Thread.sleep(2000);

            terminal.bell();
            terminal.flush();
            Thread.sleep(200);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (terminal != null) {
                try {
                    terminal.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
