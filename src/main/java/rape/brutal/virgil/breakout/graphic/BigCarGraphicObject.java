package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class BigCarGraphicObject extends ASCIIGraphicObject {

    public BigCarGraphicObject(String name, TerminalScreen terminalScreen) {
        super(name, terminalScreen);
    }

    public void draw(TerminalPosition cursorPosition) throws IOException {

        basicTextImage.newTextGraphics().putString(0, 3, Character.toString((char) 34));
        basicTextImage.newTextGraphics().putString(1, 3, "O");
        basicTextImage.newTextGraphics().putString(2, 3, Character.toString((char) 61));
        basicTextImage.newTextGraphics().putString(3, 3, Character.toString((char) 61));
        basicTextImage.newTextGraphics().putString(4, 3, Character.toString((char) 173));
        basicTextImage.newTextGraphics().putString(5, 3, "O");
        basicTextImage.newTextGraphics().putString(6, 3, Character.toString((char) 166));
        basicTextImage.newTextGraphics().putString(0, 2, Character.toString((char) 43));
        basicTextImage.newTextGraphics().putString(1, 2, Character.toString((char) 43));
        basicTextImage.newTextGraphics().putString(2, 2, Character.toString((char) 43));
        basicTextImage.newTextGraphics().putString(3, 2, Character.toString((char) 43));
        basicTextImage.newTextGraphics().putString(4, 2, Character.toString((char) 165));
        basicTextImage.newTextGraphics().putString(5, 2, Character.toString((char) 166));

        terminalScreen.newTextGraphics().drawImage(cursorPosition, basicTextImage);
    }
}
