package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class BorderGraphic extends ASCIIGraphic {

    public BorderGraphic(String name, TerminalScreen terminalScreen) {
        super(name, terminalScreen);
    }

    public void draw(TerminalPosition cursorPosition) throws IOException {

        basicTextImage.newTextGraphics().drawLine(0, 0, 0, terminalScreen.getTerminalSize().getRows(), '#');

        terminalScreen.newTextGraphics().drawImage(cursorPosition, basicTextImage);

    }
}
