package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

/**
 * Created by ViRGiL7 on 02.03.2017.
 * Project: columbian-checkpoint-breakout
 */
public class BattleCarGraphic extends ASCIIGraphic {

    public BattleCarGraphic(String name, TerminalScreen terminalScreen) {
        super(name, terminalScreen);
    }

    public void draw(TerminalPosition cursorPosition) throws IOException {

        basicTextImage.newTextGraphics().putString(0, 2, Character.toString((char) 172));
        basicTextImage.newTextGraphics().putString(1, 2, "O");
        basicTextImage.newTextGraphics().putString(2, 2, Character.toString((char) 173));
        basicTextImage.newTextGraphics().putString(3, 2, Character.toString((char) 173));
        basicTextImage.newTextGraphics().putString(4, 2, Character.toString((char) 173));
        basicTextImage.newTextGraphics().putString(5, 2, "O");
        basicTextImage.newTextGraphics().putString(6, 2, Character.toString((char) 177));
        basicTextImage.newTextGraphics().putString(1, 1, Character.toString((char) 215));
        basicTextImage.newTextGraphics().putString(2, 1, Character.toString((char) 43));
        basicTextImage.newTextGraphics().putString(3, 1, Character.toString((char) 43));
        basicTextImage.newTextGraphics().putString(4, 1, Character.toString((char) 165));
        basicTextImage.newTextGraphics().putString(5, 1, Character.toString((char) 166));
        basicTextImage.newTextGraphics().putString(4, 0, Character.toString((char) 164));
        basicTextImage.newTextGraphics().putString(5, 0, Character.toString((char) 247));
        basicTextImage.newTextGraphics().putString(6, 0, Character.toString((char) 247));

        terminalScreen.newTextGraphics().drawImage(cursorPosition, basicTextImage);

    }

}

