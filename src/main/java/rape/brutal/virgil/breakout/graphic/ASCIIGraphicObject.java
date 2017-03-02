package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

/**
 * Created by ViRGiL7 on 02.03.2017.
 * Project: columbian-checkpoint-breakout
 */
public abstract class ASCIIGraphicObject {

    protected BasicTextImage basicTextImage;
    protected TerminalScreen terminalScreen;
    protected String name;

    public ASCIIGraphicObject(String name, TerminalScreen terminalScreen) {
        this.name = name;
        this.terminalScreen = terminalScreen;
        basicTextImage = new BasicTextImage(terminalScreen.getTerminalSize());
    }

    public abstract void draw(TerminalPosition cursorPosition) throws IOException;

}

