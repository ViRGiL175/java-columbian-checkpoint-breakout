package rape.brutal.alex.evaluator;

import rape.brutal.alex.evaluator.building.ApartmentBuilding;
import rape.brutal.alex.evaluator.building.BuildingType;
import rape.brutal.punydevil.communications.infrastructure.ATS;
import rape.brutal.punydevil.communications.phone.NoNamePhone;
import rape.brutal.punydevil.communications.phone.hardware.SIM;

public class Main {

    public static void main(String[] args) {
        ApartmentBuilding apartmentBuilding =
                Builder.build("Some Place №1", BuildingType.PANEL, false, false,
                        4, 10, 3, true, true,
                        100);

        ATS ats = new ATS();

        NoNamePhone lehaPhone = new NoNamePhone(new SIM(1231));
        lehaPhone.addATS(ats);
        Concierge lehaConcierge = new Concierge(apartmentBuilding.getEntrances()[0], lehaPhone);

        NoNamePhone vasyaPhone = new NoNamePhone(new SIM(666));
        vasyaPhone.addATS(ats);
        Evaluator vasyaEvaluator = new Evaluator(vasyaPhone, apartmentBuilding);

        vasyaEvaluator.getUserPhone().phoneCall("Hello! Do you have some apartments for sale?", 1231);
        lehaConcierge.call(666, "Some Place №1");
        lehaConcierge.call(666, "1");
        lehaConcierge.call(666, "2");
        lehaConcierge.call(666, "3");
    }

}