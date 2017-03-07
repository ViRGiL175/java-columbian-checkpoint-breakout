package rape.brutal.stephan.checkpoint;


import rape.brutal.haze.pc.constructor.Engineer;
import rape.brutal.haze.pc.constructor.TechItem;
import rape.brutal.punydevil.communications.phone.NoNamePhone;
import rape.brutal.punydevil.communications.phone.hardware.SIM;
import rape.brutal.stephan.checkpoint.auto.Auto;
import rape.brutal.stephan.checkpoint.auto.BigAuto;

public class Main {

    public static void main(String[] args) {

        // Builder builder = new Builder();
        // builder.beginingOfGeneration();

        Engineer engineer = new Engineer(new NoNamePhone(new SIM(666666)));
        TechItem item = engineer.createItem(BigAuto.COST + 1, BigAuto.NAME);
        System.out.println("\n");
        Auto auto = null;
        switch (item.getItemName()) {
            case BigAuto.NAME:
                auto = ((BigAuto) item);

        }

        CheckPoint checkPoint = new CheckPoint(100001111, 777, 8000);
        checkPoint.setAuto(auto);
        checkPoint.checkAuto();

    }


}

