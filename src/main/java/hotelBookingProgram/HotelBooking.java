package hotelBookingProgram;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class HotelBooking {

    public Room roomNumber;
    public Customer name;
    public Customer phoneNumber;
    public String bookingId;
    public LocalDateTime bookingDate;

    public HotelBooking() {
        this.bookingDate = LocalDateTime.now() ;
        this.bookingId = UUID.randomUUID().toString();
    }

    public Room getRoomNumber() {
        return roomNumber;
    }

    public Customer getName() {
        return name;
    }

    public Customer getPhoneNumber() {
        return phoneNumber;
    }

    public String getBookingId() {
        return bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

}