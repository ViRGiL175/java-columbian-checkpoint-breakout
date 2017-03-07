package rape.brutal.alex.evaluator;

import rape.brutal.alex.evaluator.building.Entrance;
import rape.brutal.punydevil.communications.phone.Phone;
import rape.brutal.punydevil.communications.users.User;

public class Concierge extends User {

    private Entrance entrance;

    public Concierge(Entrance entrance, Phone userPhone) {
        super(userPhone);
        this.entrance = entrance;
    }

    @Override
    public void hear(String text, int contactNumber) {
        super.hear(text, contactNumber);
        if (text.contains("sale")) {
            System.out.println(getUserPhone().getNumber() + " sad: " + searchResult());
        }
    }

    public String searchResult() {
        int count = 0;

        for (int floorIndex = 0; floorIndex < entrance.getFloorsCount(); floorIndex++) {
            for (int apartmentIndex = 0; apartmentIndex < entrance.getApartmentsPerFloor(); apartmentIndex++) {
                if (!entrance.getApartments()[floorIndex][apartmentIndex].isSold()) {
                    count++;
                }
            }
        }

        if (count == 0) {
            return "Sorry! All apartments sold!";
        } else {
            return "We have " + count + " apartments for sale.";
        }
    }
}
