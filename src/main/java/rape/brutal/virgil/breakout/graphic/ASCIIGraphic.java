package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import rape.brutal.virgil.breakout.INameable;

import java.io.IOException;

/**
 * Created by ViRGiL7 on 02.03.2017.
 * Project: columbian-checkpoint-breakout
 */
public abstract class ASCIIGraphic implements INameable {

    protected BasicTextImage basicTextImage;
    protected TerminalScreen terminalScreen;
    protected String name;
    protected boolean isDestroyed;
    protected boolean isBlown;
    private boolean attack;

    public ASCIIGraphic(String name, TerminalScreen terminalScreen) {
        this.name = name;
        this.terminalScreen = terminalScreen;
        basicTextImage = new BasicTextImage(terminalScreen.getTerminalSize());
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public BasicTextImage getBasicTextImage() {
        return basicTextImage;
    }

    public String getName() {
        return name;
    }

    public abstract void draw(TerminalPosition cursorPosition) throws IOException;

    protected TextGraphics newTextGraphics() {
        return basicTextImage.newTextGraphics();
    }

    protected void attack() {

    }

    public boolean isAttack() {
        return attack;
    }

    public void setAttack(boolean attack) {
        this.attack = attack;
    }
}

