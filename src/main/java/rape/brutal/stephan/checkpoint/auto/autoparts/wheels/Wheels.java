package rape.brutal.stephan.checkpoint.auto.autoparts.wheels;

import rape.brutal.haze.pc.constructor.Hardware;

/**
 * Created by Mr. User on 05.03.2017.
 */
public abstract class Wheels extends Hardware {

    int half;
    int speedKey;

    public Wheels(int condition, String name) {
        super(condition, name);
    }
}
