package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class CheckPointGraphic extends ASCIIGraphic {

    private boolean isClosed;

    public CheckPointGraphic(String name, TerminalScreen terminalScreen) {
        super(name, terminalScreen);
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public void draw(TerminalPosition cursorPosition) throws IOException {
        newTextGraphics().putString(0, 0, "+");
        newTextGraphics().drawLine(1, 0, 4, 0, '-');
        newTextGraphics().putString(5, 0, "+");
        newTextGraphics().drawLine(5, 1, 5, 2, '|');
        newTextGraphics().putString(0, 3, "+");
        newTextGraphics().drawLine(1, 3, 4, 3, '-');
        newTextGraphics().putString(5, 3, "+");
        newTextGraphics().putString(0, 2, "|");
        newTextGraphics().putString(0, 1, "_");
        newTextGraphics().putString(1, 1, "_");
        newTextGraphics().putString(2, 1, "_");
        newTextGraphics().putString(3, 1, "|");

        if (isClosed) {
            newTextGraphics().drawLine(2, 2, 10, 2, '=');
        } else {
            newTextGraphics().drawLine(2, 2, 15, -3, '=');
        }

        terminalScreen.newTextGraphics().drawImage(cursorPosition, basicTextImage);
    }

}
