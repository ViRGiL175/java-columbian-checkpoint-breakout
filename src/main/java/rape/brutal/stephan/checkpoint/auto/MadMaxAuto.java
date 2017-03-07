package rape.brutal.stephan.checkpoint.auto;

/**
 * Created by ViRGiL7 on 25.02.2017.
 * Project: check-point
 */
public class MadMaxAuto extends Auto {

    public static final String NAME = "MadMaxAuto";
    public static final int COST = 6666;
    private int damage;
    private int water;

    public MadMaxAuto(int hitPoints, String documents, int morality) {
        super(hitPoints, documents, morality);
    }

    public void attakChekPoint() {

    }

    public void getWater() {

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
