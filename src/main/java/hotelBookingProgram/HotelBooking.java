package hotelBookingProgram;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Pattern;

public class HotelBooking {

    private Customer customer;
    private final String bookingId;
    private final LocalDateTime bookingDate;
    private int stayingDate;
    private String roomNumber;

    public HotelBooking() {
        this.bookingDate = LocalDateTime.now() ;
        this.bookingId = UUID.randomUUID().toString();
    }


    // 인터페이스에서 입력 받은 값으로 고객 객체를 생성한다.
    public void createCustomer(String name, int money){
        this.customer = new Customer(name, money);
    }

    // 고객이 호텔을 이용할 날짜를 입력 받음.
    public void dateTheCustomerWillStay(int stayingDate){
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

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public String getName() {
        return customer.name;
    }

    public int getMoney() {
        return customer.money;
    }

    public int getStayingDate() {
        return stayingDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    // 고객 번호를 정규식을 통해 입력 받는 메서드 // 에러남 !!
//    public boolean inputCustomerPhoneNumber(String phoneNumber) { //tempPhoneNumber: 입력받은 핸드폰번호
//        String regEx = "(010)(.{4})(.{4})";
//        if(!Pattern.matches(regEx, phoneNumber))
//            return false;
//        else {
//            customer.phoneNumber = phoneNumber.replaceAll(regEx, "$1-$2-$3");
//            return true;
//        }
//    }

}

