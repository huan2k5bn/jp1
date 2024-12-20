package Entity;

import java.time.LocalDateTime;

public class Room {
    private String id;
    private RoomType roomType;
    private double pricePerHour;

    public Room(String id, RoomType roomType, double pricePerHour) {
        this.id = id;
        this.roomType = roomType;
        this.pricePerHour = pricePerHour;
    }

    public String getId() {
        return id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
}





