package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class AverageAutoGraphic extends AutoGraphic {

    public AverageAutoGraphic(TerminalPosition terminalPosition, String name, TerminalScreen terminalScreen) {
        super(terminalPosition, name, terminalScreen);
    }

    public void draw(TerminalPosition cursorPosition) throws IOException {

        newTextGraphics().putString(0, 3, Character.toString((char) 247));
        newTextGraphics().putString(1, 3, "O");
        newTextGraphics().putString(2, 3, Character.toString((char) 173));
        newTextGraphics().putString(3, 3, Character.toString((char) 173));
        newTextGraphics().putString(4, 3, "O");
        newTextGraphics().putString(5, 3, Character.toString((char) 247));
        newTextGraphics().putString(0, 2, Character.toString((char) 181));
        newTextGraphics().putString(1, 2, Character.toString((char) 240));
        newTextGraphics().putString(2, 2, Character.toString((char) 243));
        newTextGraphics().putString(3, 2, Character.toString((char) 248));

        terminalScreen.newTextGraphics().drawImage(cursorPosition, basicTextImage);

    }
}
