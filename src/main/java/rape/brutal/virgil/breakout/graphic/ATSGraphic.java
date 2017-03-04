package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

/**
 * Created by ViRGiL7 on 02.03.2017.
 * Project: columbian-checkpoint-breakout
 */
public class ATSGraphic extends ASCIIGraphic {

    public ATSGraphic(String name, TerminalScreen terminalScreen) {
        super(name, terminalScreen);
    }

    public void draw(TerminalPosition cursorPosition) throws IOException {

        if (isDestroyed()) {
            if (!isBlown) {
                terminalScreen.getTerminal().bell();
                isBlown = true;
            } else {
                newTextGraphics().drawLine(2, 1, 2, 1, '|');
                newTextGraphics().drawLine(1, 4, 3, 4, '-');

                terminalScreen.newTextGraphics().drawImage(cursorPosition, basicTextImage);
            }
        } else {
            newTextGraphics().drawLine(2, 1, 2, 4, '|');
            newTextGraphics().drawLine(1, 4, 3, 4, '-');
            newTextGraphics().putString(2, 0, "#", SGR.BLINK);
            newTextGraphics().putString(4, 2, name);

            terminalScreen.newTextGraphics().drawImage(cursorPosition, basicTextImage);
        }

    }

}
