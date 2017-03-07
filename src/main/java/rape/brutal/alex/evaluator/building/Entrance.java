package rape.brutal.alex.evaluator.building;

import rape.brutal.alex.evaluator.Concierge;

public class Entrance {

    public static final double GARBAGE_CHUTE_COEFFICIENT = 1.1;
    public static final double ELEVATOR_COEFFICIENT = 1.1;

    private final int floorsCount;
    private final int apartmentsPerFloor;

    private int number;
    private boolean hasElevator;
    private boolean hasGarbageChute;
    private Apartment[][] apartments;
    private Concierge concierge;
    private ApartmentBuilding apartmentBuilding;

    public Entrance(int floorsCount, int apartmentsPerFloor, boolean hasElevator, boolean hasGarbageChute,
                    ApartmentBuilding apartmentBuilding) {
        this.hasElevator = hasElevator;
        this.hasGarbageChute = hasGarbageChute;
        this.floorsCount = floorsCount;
        this.apartmentsPerFloor = apartmentsPerFloor;
        this.apartments = new Apartment[floorsCount][apartmentsPerFloor];
        this.apartmentBuilding = apartmentBuilding;
    }

    public int getFloorsCount() {
        return floorsCount;
    }

    public int getApartmentsPerFloor() {
        return apartmentsPerFloor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isHasElevator() {
        return hasElevator;
    }

    public boolean isHasGarbageChute() {
        return hasGarbageChute;
    }

    public Apartment[][] getApartments() {
        return apartments;
    }

    public Concierge getConcierge() {
        return concierge;
    }

    public void setConcierge(Concierge concierge) {
        this.concierge = concierge;
    }

    public ApartmentBuilding getApartmentBuilding() {
        return apartmentBuilding;
    }

    public void addApartment(int floorIndex, int apartmentIndex, Apartment apartment) {
        apartments[floorIndex][apartmentIndex] = apartment;
        apartments[floorIndex][apartmentIndex].setFloor(floorIndex + 1);
        apartments[floorIndex][apartmentIndex].setNumber(number * floorIndex * apartmentsPerFloor + floorIndex
                * apartmentsPerFloor + apartmentIndex + 1);
    }
}
