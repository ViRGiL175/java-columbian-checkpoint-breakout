package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class BigCarGraphic extends CarGraphic {

    public BigCarGraphic(TerminalPosition terminalPosition, String name, TerminalScreen terminalScreen) {
        super(terminalPosition, name, terminalScreen);
    }

    @Override
    public void attack() {
        try {
            terminalScreen.getTerminal().bell();

            newTextGraphics().putString(1, 3, Character.toString((char) 34), SGR.BOLD);
            newTextGraphics().putString(2, 3, "O");
            newTextGraphics().putString(3, 3, Character.toString((char) 61), SGR.BOLD);
            newTextGraphics().putString(4, 3, Character.toString((char) 61), SGR.BOLD);
            newTextGraphics().putString(5, 3, Character.toString((char) 173), SGR.BOLD);
            newTextGraphics().putString(6, 3, "O");
            newTextGraphics().putString(7, 3, Character.toString((char) 166), SGR.BOLD);
            newTextGraphics().putString(1, 2, Character.toString((char) 43), SGR.BOLD);
            newTextGraphics().putString(2, 2, Character.toString((char) 43), SGR.BOLD);
            newTextGraphics().putString(3, 2, Character.toString((char) 43), SGR.BOLD);
            newTextGraphics().putString(4, 2, Character.toString((char) 43), SGR.BOLD);
            newTextGraphics().putString(5, 2, Character.toString((char) 165), SGR.BOLD);
            newTextGraphics().putString(6, 2, Character.toString((char) 166), SGR.BOLD);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(TerminalPosition cursorPosition) throws IOException {
        if (isAttack()) {
            attack();
        } else {
            newTextGraphics().putString(0, 3, Character.toString((char) 34));
            newTextGraphics().putString(1, 3, "O");
            newTextGraphics().putString(2, 3, Character.toString((char) 61));
            newTextGraphics().putString(3, 3, Character.toString((char) 61));
            newTextGraphics().putString(4, 3, Character.toString((char) 173));
            newTextGraphics().putString(5, 3, "O");
            newTextGraphics().putString(6, 3, Character.toString((char) 166));
            newTextGraphics().putString(0, 2, Character.toString((char) 43));
            newTextGraphics().putString(1, 2, Character.toString((char) 43));
            newTextGraphics().putString(2, 2, Character.toString((char) 43));
            newTextGraphics().putString(3, 2, Character.toString((char) 43));
            newTextGraphics().putString(4, 2, Character.toString((char) 165));
            newTextGraphics().putString(5, 2, Character.toString((char) 166));
        }
        terminalScreen.newTextGraphics().drawImage(cursorPosition, basicTextImage);
    }
}
