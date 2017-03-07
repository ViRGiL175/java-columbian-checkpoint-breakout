package rape.brutal.alex.evaluator;

import rape.brutal.alex.evaluator.building.Apartment;
import rape.brutal.alex.evaluator.building.ApartmentBuilding;
import rape.brutal.alex.evaluator.building.Entrance;
import rape.brutal.punydevil.communications.phone.Phone;
import rape.brutal.punydevil.communications.users.User;

import java.util.Objects;

public class Evaluator extends User {

    private final ApartmentBuilding apartmentBuilding;
    private int lastValue;

    public Evaluator(Phone userPhone, ApartmentBuilding apartmentBuilding) {
        super(userPhone);
        this.apartmentBuilding = apartmentBuilding;
    }

    public int getLastValue() {
        return lastValue;
    }

    @Override
    public void call(int number, String text) {
        super.call(number, text);
        System.out.println(text);
    }

    @Override
    public void hear(String text, int contactNumber) {
        super.hear(text, contactNumber);
        if (text.matches("[0-9]{1,15}")) {
            int number = Integer.parseInt(text);
            Apartment apartment = searchApartment(number);
            if (apartment != null) {
                lastValue = getValue(apartment);
                System.out.println("Стоимость квартиры - " + lastValue + " тыс. руб.");
            } else {
                System.out.println("Нет такой квартиры.");
            }
        } else if (Objects.equals(text, apartmentBuilding.getAddress())) {
            lastValue = getValue(apartmentBuilding);
            System.out.println("Стоимость дома - " + lastValue + " тыс. руб.");
        }
    }

    public Apartment searchApartment(int number) {
        for (int entranceIndex = 0; entranceIndex < apartmentBuilding.getEntrancesCount(); entranceIndex++) {
            Entrance entrance = apartmentBuilding.getEntrances()[entranceIndex];
            for (int floorIndex = 0; floorIndex < entrance.getFloorsCount(); floorIndex++) {
                for (int apartmentIndex = 0; apartmentIndex < entrance.getApartmentsPerFloor(); apartmentIndex++) {
                    Apartment apartment = entrance.getApartments()[floorIndex][apartmentIndex];
                    if (apartment.getNumber() == number) {
                        return apartment;
                    }
                }
            }
        }
        return null;
    }

    public int getValue(IValuable iValuable) {
        return iValuable.getValue();
    }
}
