package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class GarageGraphic extends ASCIIGraphic {

    private boolean isClosed = false;

    public GarageGraphic(String name, TerminalScreen terminalScreen) {
        super(name, terminalScreen);
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public void draw(TerminalPosition cursorPosition) throws IOException {

        basicTextImage = new BasicTextImage(terminalScreen.getTerminalSize());

        newTextGraphics().putString(0, 0, "+");
        newTextGraphics().drawLine(1, 0, 9, 0, '-');
        newTextGraphics().putString(10, 0, "+");
        newTextGraphics().drawLine(10, 1, 10, 2, '|');
        newTextGraphics().putString(0, 3, "+");
        newTextGraphics().drawLine(1, 3, 9, 3, '-');
        newTextGraphics().putString(10, 3, "+");
        newTextGraphics().drawLine(0, 1, 0, 2, '|');
        newTextGraphics().putString(1, 1, "El Garage");

        if (isClosed) {
            newTextGraphics().drawLine(1, 2, 9, 2, '#');
        } else {
            newTextGraphics().putString(1, 2, "|");
            newTextGraphics().putString(9, 2, "|");
        }

        terminalScreen.newTextGraphics().drawImage(cursorPosition, basicTextImage);
    }

}
