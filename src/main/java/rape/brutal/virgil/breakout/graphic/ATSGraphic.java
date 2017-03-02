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

        basicTextImage.newTextGraphics().drawLine(2, 1, 2, 4, '|');
        basicTextImage.newTextGraphics().drawLine(1, 4, 3, 4, '-');
        basicTextImage.newTextGraphics().putString(2, 0, "#", SGR.BLINK);
        basicTextImage.newTextGraphics().putString(4, 2, name);

        terminalScreen.newTextGraphics().drawImage(cursorPosition, basicTextImage);
    }
}
