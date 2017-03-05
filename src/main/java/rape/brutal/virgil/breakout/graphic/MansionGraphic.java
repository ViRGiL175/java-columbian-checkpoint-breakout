package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class MansionGraphic extends ASCIIGraphic {

    public MansionGraphic(String name, TerminalScreen terminalScreen) {
        super(name, terminalScreen);
    }

    public void draw(TerminalPosition cursorPosition) throws IOException {

        basicTextImage = new BasicTextImage(terminalScreen.getTerminalSize());

        newTextGraphics().putString(1, 0, "+");
        newTextGraphics().drawLine(2, 0, 12, 0, '-');
        newTextGraphics().putString(13, 0, "+");
        newTextGraphics().drawLine(13, 1, 13, 4, '|');
        newTextGraphics().drawLine(14, 2, 14, 4, '|');
        newTextGraphics().putString(14, 1, "_");
        newTextGraphics().putString(14, 5, "=");
        newTextGraphics().putString(1, 5, "+");
        newTextGraphics().drawLine(2, 5, 12, 5, '-');
        newTextGraphics().drawLine(4, 5, 10, 5, '=');
        newTextGraphics().putString(13, 5, "+");
        newTextGraphics().drawLine(0, 1, 0, 4, '|');
        newTextGraphics().drawLine(1, 2, 1, 4, '|');
        newTextGraphics().putString(0, 1, "_");
        newTextGraphics().putString(0, 5, "=");
        newTextGraphics().putString(2, 1, "El Mansione");
        newTextGraphics().putString(2, 2, "del " + name);

        newTextGraphics().putString(3, 3, String.valueOf(((char) 177)));
        newTextGraphics().putString(3, 4, String.valueOf(((char) 177)));

        newTextGraphics().putString(5, 3, String.valueOf(((char) 177)));
        newTextGraphics().putString(5, 4, String.valueOf(((char) 177)));

        newTextGraphics().putString(9, 3, String.valueOf(((char) 177)));
        newTextGraphics().putString(9, 4, String.valueOf(((char) 177)));

        newTextGraphics().putString(11, 3, String.valueOf(((char) 177)));
        newTextGraphics().putString(11, 4, String.valueOf(((char) 177)));

        newTextGraphics().putString(7, 4, String.valueOf(((char) 135)));

        terminalScreen.newTextGraphics().drawImage(cursorPosition, basicTextImage);

    }
}
