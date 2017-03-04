package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

/**
 * Created by ViRGiL7 on 02.03.2017.
 * Project: columbian-checkpoint-breakout
 */
public class BattleCarGraphic extends CarGraphic {

    public BattleCarGraphic(TerminalPosition terminalPosition, String name, TerminalScreen terminalScreen) {
        super(terminalPosition, name, terminalScreen);
    }

    @Override
    public void attack() {
        try {
            terminalScreen.getTerminal().bell();

            newTextGraphics().putString(0, 2, Character.toString((char) 172), SGR.BOLD);
            newTextGraphics().putString(1, 2, "O");
            newTextGraphics().putString(2, 2, Character.toString((char) 173), SGR.BOLD);
            newTextGraphics().putString(3, 2, Character.toString((char) 173), SGR.BOLD);
            newTextGraphics().putString(4, 2, Character.toString((char) 173), SGR.BOLD);
            newTextGraphics().putString(5, 2, "O");
            newTextGraphics().putString(6, 2, Character.toString((char) 177), SGR.BOLD);
            newTextGraphics().putString(1, 1, Character.toString((char) 215), SGR.BOLD);
            newTextGraphics().putString(2, 1, Character.toString((char) 43), SGR.BOLD);
            newTextGraphics().putString(3, 1, Character.toString((char) 43), SGR.BOLD);
            newTextGraphics().putString(4, 1, Character.toString((char) 165), SGR.BOLD);
            newTextGraphics().putString(5, 1, Character.toString((char) 166), SGR.BOLD);
            newTextGraphics().putString(4, 0, Character.toString((char) 164), SGR.BOLD);
            newTextGraphics().putString(5, 0, Character.toString((char) 247), SGR.BOLD);
            newTextGraphics().putString(6, 0, Character.toString((char) 247), SGR.BOLD);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(TerminalPosition cursorPosition) throws IOException {
        if (isAttack()) {
            attack();
        } else {
            newTextGraphics().putString(0, 2, Character.toString((char) 172));
            newTextGraphics().putString(1, 2, "O");
            newTextGraphics().putString(2, 2, Character.toString((char) 173));
            newTextGraphics().putString(3, 2, Character.toString((char) 173));
            newTextGraphics().putString(4, 2, Character.toString((char) 173));
            newTextGraphics().putString(5, 2, "O");
            newTextGraphics().putString(6, 2, Character.toString((char) 177));
            newTextGraphics().putString(1, 1, Character.toString((char) 215));
            newTextGraphics().putString(2, 1, Character.toString((char) 43));
            newTextGraphics().putString(3, 1, Character.toString((char) 43));
            newTextGraphics().putString(4, 1, Character.toString((char) 165));
            newTextGraphics().putString(5, 1, Character.toString((char) 166));
            newTextGraphics().putString(4, 0, Character.toString((char) 164));
            newTextGraphics().putString(5, 0, Character.toString((char) 247));
            newTextGraphics().putString(6, 0, Character.toString((char) 247));

        }
        terminalScreen.newTextGraphics().drawImage(cursorPosition, basicTextImage);

    }

}

