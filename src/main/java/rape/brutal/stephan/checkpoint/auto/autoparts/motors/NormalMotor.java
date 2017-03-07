package rape.brutal.stephan.checkpoint.auto.autoparts.motors;

/**
 * Created by Mr. User on 05.03.2017.
 */
public class NormalMotor extends Motor {

    public NormalMotor(int condition, String name) {
        super(condition, name);

        motorHalf = 100;
        powerfull = 50;
    }
}
