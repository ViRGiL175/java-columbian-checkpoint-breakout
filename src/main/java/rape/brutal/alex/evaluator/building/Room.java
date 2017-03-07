package rape.brutal.alex.evaluator.building;

public class Room {

    private RoomType roomType;
    private int area;

    public Room() {
        this.roomType = RoomType.LIVING_ROOM;
        this.area = 0;
    }

    public Room(RoomType roomType, int area) {
        this.roomType = roomType;
        this.area = area;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

}
