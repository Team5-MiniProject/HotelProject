package hotelBookingProgram;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Pattern;

public class HotelBooking {

    public Room roomNumber;
    public Customer customer = new Customer();
    public String bookingId;
    public LocalDateTime bookingDate;

    public HotelBooking() {
        this.bookingDate = LocalDateTime.now() ;
        this.bookingId = UUID.randomUUID().toString();
    }

    public String getBookingId() {
        return bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public Room getRoomNumber() {
        return roomNumber;
    }

    public void setName(String name) {
        customer.name = name;
    }

    public void setMoney(int money) {
        customer.money = money;
    }

    public String getName() {
        return customer.name;
    }

    public int getMoney() {
        return customer.money;
    }

    public boolean setPhoneNumber(String phoneNumber) { //tempPhoneNumber: 입력받은 핸드폰번호
        String regEx = "(010)-\\d{4}-\\d{4}";
        if(!Pattern.matches(regEx, phoneNumber))
            return false;
        else {
            customer.phoneNumber = phoneNumber.replaceAll(regEx, "$1-$2-$3");
            return true;
        }
    }
}