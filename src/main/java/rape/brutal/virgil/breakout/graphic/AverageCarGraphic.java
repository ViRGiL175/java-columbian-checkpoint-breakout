package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class AverageCarGraphic extends ASCIIGraphic {

    public AverageCarGraphic(String name, TerminalScreen terminalScreen) {
        super(name, terminalScreen);
    }

    public void draw(TerminalPosition cursorPosition) throws IOException {

        basicTextImage.newTextGraphics().putString(0, 3, Character.toString((char) 247));
        basicTextImage.newTextGraphics().putString(1, 3, "O");
        basicTextImage.newTextGraphics().putString(2, 3, Character.toString((char) 173));
        basicTextImage.newTextGraphics().putString(3, 3, Character.toString((char) 173));
        basicTextImage.newTextGraphics().putString(4, 3, "O");
        basicTextImage.newTextGraphics().putString(5, 3, Character.toString((char) 247));
        basicTextImage.newTextGraphics().putString(0, 2, Character.toString((char) 181));
        basicTextImage.newTextGraphics().putString(1, 2, Character.toString((char) 240));
        basicTextImage.newTextGraphics().putString(2, 2, Character.toString((char) 243));
        basicTextImage.newTextGraphics().putString(3, 2, Character.toString((char) 248));

        terminalScreen.newTextGraphics().drawImage(cursorPosition, basicTextImage);

    }
}
