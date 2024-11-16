package Entity;

import java.time.LocalDateTime;

public class Booking {
    private String id;
    private String roomId;
    private String cusId;
    private LocalDateTime checkInDatetime;
    private LocalDateTime checkOutDatetime;

    public Booking(String id, String roomId, String cusId, LocalDateTime checkInDatetime, LocalDateTime checkOutDatetime) {
        this.id = id;
        this.roomId = roomId;
        this.cusId = cusId;
        this.checkInDatetime = checkInDatetime;
        this.checkOutDatetime = checkOutDatetime;
    }

    public String getRoomId() {
        return roomId;
    }

    public LocalDateTime getCheckInDatetime() {
        return checkInDatetime;
    }

    public LocalDateTime getCheckOutDatetime() {
        return checkOutDatetime;
    }
}