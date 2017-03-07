package rape.brutal.stephan.checkpoint.auto;

/**
 * Created by ViRGiL7 on 25.02.2017.
 * Project: check-point
 */
public class BigAuto extends Auto {


    public static final String NAME = "BigAuto";
    public static final int COST = 7000;

    public BigAuto(int hitPoints, String documents, int morality) {
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
