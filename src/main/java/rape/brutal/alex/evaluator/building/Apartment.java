package rape.brutal.alex.evaluator.building;

import rape.brutal.alex.evaluator.IValuable;

import java.util.HashMap;

public class Apartment implements IValuable {

    private static final HashMap<RoomType, Double> ROOM_TYPE_COEFFICIENT = new HashMap<RoomType, Double>() {{
        put(RoomType.BATHROOM, 0.5);
        put(RoomType.KITCHEN, 0.75);
        put(RoomType.LIVING_ROOM, 1.0);
    }};

    private final int roomsCount;

    private int floor;
    private int number;
    private Room[] rooms;
    private boolean isSold;
    private Entrance entrance;

    public Apartment(int roomsCount, boolean isSold, Entrance entrance) {
        this.roomsCount = roomsCount;
        this.rooms = new Room[roomsCount];
        this.isSold = isSold;
        this.entrance = entrance;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Entrance getEntrance() {
        return entrance;
    }

    public void addRoom(Room room) {
        for (int roomIndex = 0; roomIndex < roomsCount; roomIndex++) {
            if (rooms[roomIndex] == null) {
                rooms[roomIndex] = room;
            }
        }
    }

    public int getTotalArea() {

        int totalArea = 0;

        for (Room room : rooms) {
            totalArea += room.getArea();
        }

        return totalArea;

    }

    @Override
    public int getValue() {

        int value = 0;

        for (int roomIndex = 0; roomIndex < roomsCount; roomIndex++) {
            Room room = rooms[roomIndex];
            value += room.getArea() * ROOM_TYPE_COEFFICIENT.get(room.getRoomType())
                    * entrance.getApartmentBuilding().getCostPerMeter();
        }

        value *= entrance.getApartmentBuilding().getCostPerMeter();

        if (entrance.getApartmentBuilding().isHasBoiler()) {
            value *= ApartmentBuilding.BOILER_COEFFICIENT;
        }

        if (entrance.getApartmentBuilding().isHasParking()) {
            value *= ApartmentBuilding.PARKING_COEFFICIENT;
        }

        switch (getFloor()) {
            case 1:
                break;
            case 2:
                if (getEntrance().isHasGarbageChute()) {
                    value *= Entrance.GARBAGE_CHUTE_COEFFICIENT;
                }

                break;
            default:
                if (getEntrance().isHasElevator()) {
                    value *= Entrance.ELEVATOR_COEFFICIENT;
                }

                if (getEntrance().isHasGarbageChute()) {
                    value *= Entrance.GARBAGE_CHUTE_COEFFICIENT;
                }

                break;
        }

        return value;

    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
}
