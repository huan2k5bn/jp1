import Entity.Booking;
import Entity.Customer;
import Entity.Room;
import Entity.RoomType;
import Service.BookingService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        BookingService bookingService = new BookingService();

        bookingService.addRoom(new Room("RS001", RoomType.SINGLE, 8));
        bookingService.addRoom(new Room("RD001", RoomType.DOUBLE, 12));
        bookingService.addRoom(new Room("RQ002", RoomType.QUEEN, 35));
        bookingService.addRoom(new Room("RT001", RoomType.TRIPLE, 12.5));
        bookingService.addRoom(new Room("RQ001", RoomType.QUAD, 20.5));

        bookingService.addCustomer(new Customer("001", "Mr. Linus Tovaldo", "84125325346457"));
        bookingService.addCustomer(new Customer("002", "Mr. Bill", "91142335346467"));
        bookingService.addCustomer(new Customer("003", "Mr. Turing", "911423354646"));

        bookingService.addBooking(new Booking("1", "RS001", "001", LocalDateTime.of(2023, 3, 15, 9, 30, 15), LocalDateTime.of(2023, 3, 16, 12, 30, 45)));
        bookingService.addBooking(new Booking("2", "RS001", "002", LocalDateTime.of(2023, 6, 9, 19, 30, 25), LocalDateTime.of(2023, 6, 10, 11, 25, 15)));
        bookingService.addBooking(new Booking("3", "RD001", "002", LocalDateTime.of(2023, 3, 11, 10, 10, 5), LocalDateTime.of(2023, 3, 13, 11, 5, 10)));
        bookingService.addBooking(new Booking("4", "RT001", "003", LocalDateTime.of(2023, 11, 11, 11, 11, 15), LocalDateTime.of(2023, 11, 13, 11, 15, 15)));
        bookingService.addBooking(new Booking("5", "RT001", "001", LocalDateTime.of(2023, 10, 25, 9, 20, 25), LocalDateTime.of(2023, 10, 26, 12, 25, 30)));
        bookingService.addBooking(new Booking("6", "RQ001", "002", LocalDateTime.of(2023, 8, 18, 18, 25, 35), LocalDateTime.of(2023, 8, 19, 11, 35, 20)));

        System.out.println("Doanh thu theo loại phòng: " + bookingService.calculateRevenueByRoomType());

        System.out.println("Loại phòng có doanh thu cao nhất trong năm 2023: " + bookingService.getTopRevenueRoomTypeFor2023());
    }
}
