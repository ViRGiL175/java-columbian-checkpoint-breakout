package rape.brutal.alex.evaluator;

import rape.brutal.alex.evaluator.building.*;

import java.util.Random;

public class Builder {

    public static ApartmentBuilding build(String address, BuildingType buildingType, boolean hasBoiler,
                                          boolean hasParking, int entrancesCount, int floorsCount,
                                          int apartmentsPerFloor, boolean hasElevator, boolean hasGarbageChute,
                                          int hitPoints) {
        ApartmentBuilding apartmentBuilding = new ApartmentBuilding(address, buildingType, hasBoiler, hasParking,
                entrancesCount, hitPoints);

        for (int entranceIndex = 0; entranceIndex < entrancesCount; entranceIndex++) {
            Entrance entrance = new Entrance(floorsCount, apartmentsPerFloor, hasElevator, hasGarbageChute,
                    apartmentBuilding);
            for (int floorIndex = 0; floorIndex < floorsCount; floorIndex++) {
                for (int apartmentIndex = 0; apartmentIndex < apartmentsPerFloor; apartmentIndex++) {
                    Random livingRoomsCount = new Random();
                    Random isSold = new Random();
                    int roomsCount = 3 + livingRoomsCount.nextInt(4);
                    Apartment apartment = new Apartment(roomsCount, isSold.nextBoolean(), entrance);
                    Random area = new Random();
                    apartment.addRoom(new Room(RoomType.KITCHEN, area.nextInt(6) + 5));
                    apartment.addRoom(new Room(RoomType.BATHROOM, area.nextInt(3) + 2));
                    for (int roomIndex = 0; roomIndex < roomsCount; roomIndex++) {
                        apartment.addRoom(new Room(RoomType.LIVING_ROOM, area.nextInt(21) + 15));
                    }
                    entrance.addApartment(floorIndex, apartmentIndex, apartment);
                }
            }
            apartmentBuilding.addEntrance(entranceIndex, entrance);
        }
        return apartmentBuilding;
    }

}
