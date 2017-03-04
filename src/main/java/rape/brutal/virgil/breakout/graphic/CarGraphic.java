package rape.brutal.virgil.breakout.graphic;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.TerminalScreen;

/**
 * Created by ViRGiL7 on 03.03.2017.
 * Project: columbian-checkpoint-breakout
 */
public abstract class CarGraphic extends ASCIIGraphic {

    private TerminalPosition position = new TerminalPosition(0, 0);
    private boolean passed;

    public CarGraphic(TerminalPosition terminalPosition, String name, TerminalScreen terminalScreen) {
        super(name, terminalScreen);
        position = terminalPosition;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public TerminalPosition getPosition() {
        return position;
    }

    public void setPosition(TerminalPosition position) {
        this.position = position;
    }

}
