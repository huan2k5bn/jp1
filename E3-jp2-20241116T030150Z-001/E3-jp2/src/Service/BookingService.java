package Service;

import Entity.Booking;
import Entity.Customer;
import Entity.Room;
import Entity.RoomType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class BookingService {
    private List<Room> rooms = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public Map<RoomType, Double> calculateRevenueByRoomType() {
        Map<RoomType, Double> revenueMap = new HashMap<>();

        for (Booking booking : bookings) {
            Room room = rooms.stream().filter(r -> r.getId().equals(booking.getRoomId())).findFirst().orElse(null);
            if (room != null) {
                double hours = Duration.between(booking.getCheckInDatetime(), booking.getCheckOutDatetime()).toHours();
                double revenue = hours * room.getPricePerHour();
                revenueMap.merge(room.getRoomType(), revenue, Double::sum);
            }
        }

        return revenueMap;
    }

    public RoomType getTopRevenueRoomTypeFor2023() {
        Map<RoomType, Double> revenue2023 = bookings.stream()
                .filter(booking -> booking.getCheckInDatetime().getYear() == 2023)
                .collect(Collectors.groupingBy(
                        booking -> rooms.stream().filter(r -> r.getId().equals(booking.getRoomId())).findFirst().orElse(null).getRoomType(),
                        Collectors.summingDouble(booking -> {
                            Room room = rooms.stream().filter(r -> r.getId().equals(booking.getRoomId())).findFirst().orElse(null);
                            if (room != null) {
                                long hours = Duration.between(booking.getCheckInDatetime(), booking.getCheckOutDatetime()).toHours();
                                return hours * room.getPricePerHour();
                            }
                            return 0.0;
                        })
                ));

        return revenue2023.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow().getKey();
    }
}
