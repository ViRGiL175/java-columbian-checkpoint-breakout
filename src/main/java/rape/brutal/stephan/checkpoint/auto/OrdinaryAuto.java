package rape.brutal.stephan.checkpoint.auto;

/**
 * Created by Mr. User on 05.03.2017.
 */
public class OrdinaryAuto extends Auto {

    public static final String NAME = "OrdinaryAuto";
    public static final int COST = 300;

    public OrdinaryAuto(int hitPoints, String documents, int morality) {
        super(hitPoints, documents, morality);
    }

    @Override
    public String getItemName() {
        return NAME;
    }

    @Override
    public void assignHardware() {

    }

    public int getCost() {
        return COST;
    }
}
