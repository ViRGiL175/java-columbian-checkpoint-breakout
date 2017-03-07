package rape.brutal.alex.evaluator.building;

import rape.brutal.alex.evaluator.IValuable;
import rape.brutal.stephan.checkpoint.auto.IDestruyable;

import java.util.HashMap;

public class ApartmentBuilding implements IValuable, IDestruyable {

    public static final double BOILER_COEFFICIENT = 1.1;
    public static final double PARKING_COEFFICIENT = 1.1;
    private static final HashMap<BuildingType, Integer> COST_PER_METER = new HashMap<BuildingType, Integer>() {{
        put(BuildingType.BLOCK, 25);
        put(BuildingType.INDIVIDUAL, 40);
        put(BuildingType.BRICK_MONOLITH, 35);
        put(BuildingType.MONOLITH, 30);
        put(BuildingType.PANEL, 20);
        put(BuildingType.STALIN, 10);
        put(BuildingType.KHRUSHCHEV, 15);
        put(BuildingType.BREZHNEV, 20);
    }};
    private final int entrancesCount;
    private String address;
    private BuildingType buildingType;
    private boolean hasBoiler;
    private boolean hasParking;
    private Entrance[] entrances;
    private int hitPoints;
    private boolean destroyed;

    public ApartmentBuilding(String address, BuildingType buildingType, boolean hasBoiler, boolean hasParking,
                             int entrancesCount, int hitPoints) {
        this.address = address;
        this.buildingType = buildingType;
        this.hasBoiler = hasBoiler;
        this.hasParking = hasParking;
        this.entrancesCount = entrancesCount;
        this.entrances = new Entrance[entrancesCount];
        this.hitPoints = hitPoints;
    }

    public int getCostPerMeter() {
        return COST_PER_METER.get(buildingType).intValue();
    }

    public String getAddress() {
        return address;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public boolean isHasBoiler() {
        return hasBoiler;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public int getEntrancesCount() {
        return entrancesCount;
    }

    public Entrance[] getEntrances() {
        return entrances;
    }

    public void addEntrance(int entranceIndex, Entrance entrance) {
        entrances[entranceIndex] = entrance;
        entrances[entranceIndex].setNumber(entranceIndex + 1);
    }

    @Override
    public int getValue() {
        int value = 0;

        for (int entranceNumber = 0; entranceNumber < entrancesCount; entranceNumber++) {
            Entrance entrance = entrances[entranceNumber];

            for (int floorNumber = 0; floorNumber < entrance.getFloorsCount(); floorNumber++) {
                for (int apartmentNumber = 0; apartmentNumber < entrance.getApartmentsPerFloor(); apartmentNumber++) {
                    Apartment apartment = entrance.getApartments()[floorNumber][apartmentNumber];

                    value += apartment.getValue();
                }
            }
        }

        return value;
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public void makeDamage(int i) {
        hitPoints -= i;
        if (hitPoints <= 0) {
            destroyed = true;
        }
    }
}
