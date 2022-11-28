package hotelBookingProgram;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HotelBooking {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");

    private Customer customer;
    private final String bookingId;
    private final String bookingDate;
    private String stayingDate;
    private String roomNumber;

    public HotelBooking() {
        this.bookingDate = dateTimeFormatter.format(LocalDateTime.now());
        this.bookingId = UUID.randomUUID().toString();
    }


    // 인터페이스에서 입력 받은 값으로 고객 객체를 생성한다.
    public void createCustomer(String name, int money){
        this.customer = new Customer(name, money);
    }

    // 고객이 호텔을 이용할 날짜를 입력 받음.
    public void dateTheCustomerWillStay(String stayingDate){
        this.stayingDate = stayingDate;
    }

    // 고객이 이용할 룸넘버를 저장 받는다.
    public void RoomNumberCustomerWillStay(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    // 임시 폰넘버 저장 메서드
    public void setPhoneNumber(String phoneNumber){
        customer.phoneNumber = phoneNumber;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getName() {
        return customer.name;
    }

    public int getMoney() {
        return customer.money;
    }

    public String getStayingDate() {
        return stayingDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }


    public void compareStayingDateAndNow(){

    }

    public boolean InputPhoneNumber (String str){
        Pattern pattern = Pattern.compile("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

}

