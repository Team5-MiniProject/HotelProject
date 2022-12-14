package hotelBookingProgram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hotel {

    Scanner scanner = new Scanner(System.in);
    Pattern StayingDatePattern = Pattern.compile("\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])");

    private int hotelMoney=0;
    private final HotelBookingList hotelBookingList = new HotelBookingList();
    private final RoomList roomList = new RoomList();
    private int hotelAdminPsw = 0000;

    // 호텔 관리자 비밀번호 리턴하는 함수
    public int getHotelAdminPsw() {
        return hotelAdminPsw;
    }

    // 호텔 자산이 줄어든다.
    public void loseHotelMoney(int hotelMoney) {
        this.hotelMoney -= hotelMoney;
    }

    // 호텔 자산에서 입력 금액이 입금된다.
    public void addHotelMoney(int hotelMoney){
        this.hotelMoney += hotelMoney;
    }

    public int getHotelMoney() {
        return hotelMoney;
    }

    // 1. 예약 받기 - 고객 객체를 생성해야함 / 예약 객체를 생성해야함 / 예약 리스트에 추가해야함.
    public void receiveBooking() throws ParseException {

        HotelBooking hotelBooking = new HotelBooking();

        System.out.println("예약자 성함을 입력하세요: ");
        String tempName = scanner.next();

        System.out.println("예약자 전화번호 입력하세요. ex)010-1234-1234: ");
        String tempPhoneNumber = scanner.next();


        // 번호가 맞는 형식으로 입력되어 있는지 확인하고 제대로 입력되면 객체에 저장한다.
        if (!(hotelBooking.InputPhoneNumber(tempPhoneNumber))) {
            System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            return;
        }

        // 호텔 방 목록을 보여준다. 호텔 룸 프린트 메서드 실행 (RL-1)
        System.out.println("============================");
        roomList.printAllRoomList();
        System.out.println("============================");

        System.out.println("원하는 방 번호를 입력하세요: ");
        String tempRoomNumber = scanner.next();

        if(!(roomList.getRoom(tempRoomNumber))){
            return;
        }


        System.out.println("숙박할 날짜를 입력해주세요 ex)2022-12-25 : ");
        String tempStayingDate = scanner.next();
        Matcher matcher = StayingDatePattern.matcher(tempStayingDate);

        if(!matcher.find()){
            System.out.println("형식에 맞게 입력해주세요.");
            return;
        }

        // 함수 처리 해야함
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currentTime = new Date();
        String dateNow = format.format(currentTime);

        Date inputDate = format.parse(tempStayingDate);
        Date today = format.parse(dateNow);

        int compare = inputDate.compareTo(today);

        if (compare < 0) {
            System.out.println("이미 지난 날짜 입니다. 다시 입력해주세요.");
            return;
        }



        // 기존 예약중 입력 받은 룸넘버와 숙박 날짜와 같은 예약이 있으면 -1을 반환한다.
        int checkBookingPossible = hotelBookingList.checkBookingPossible(tempStayingDate,tempRoomNumber);

        if(checkBookingPossible == -1){
            System.out.println("해당 날짜는 이미 예약이 완료되었습니다.");
            return;
        }

        System.out.println("결제하실 금액을 입력하세요: ");
        int tempMoney = scanner.nextInt();


        // 입력한 방번호에 해당하는 방의 금액을 tempRoomMoney에 저장한다.
        int tempRoomMoney = roomList.getRoomPrice(tempRoomNumber);

        if(tempMoney == tempRoomMoney ){
            // 입력 받은 값으로 고객 객체를 생성한다.
            hotelBooking.createCustomer(tempName,tempMoney);

            // 예약 객체에 해당 룸넘버와 숙박 날짜를 저장한다.
            hotelBooking.setPhoneNumber(tempPhoneNumber);
            hotelBooking.dateTheCustomerWillStay(tempStayingDate);
            hotelBooking.RoomNumberCustomerWillStay(tempRoomNumber);

            // 해당 예약을 리스트에 추가한다.
            hotelBookingList.add(hotelBooking);
            System.out.println("예약이 완료되었습니다.");

            // 예약 번호 불러와서 출력하기
            System.out.println("고객님의 예약번호 입니다.");
            System.out.println(hotelBooking.getBookingId());

            // 호텔 자산에 돈을 추가한다.
            addHotelMoney(tempMoney);

        }else if(tempMoney < tempRoomMoney){
            System.out.println("금액이 부족합니다.");
        }else System.out.println("결제 오류"); // 오류 메시지 따로 만들까요??

    }

    // 2. 예약 취소 - 생성된
    public void cancelBookingByCustomer(){
        System.out.println("예약번호를 입력하세요: ");
        String tempBookingId = scanner.next();

        // 예약번호로 해당 룸넘버를 받아오고, 받아온 룸넘버로 해당 방의 가격을 tempRoomPrice 변수에 저장한다.
        try{
        String tempRoomNumber = hotelBookingList.getRoomNumberByBookingId(tempBookingId);
        int tempRoomPrice = roomList.getRoomPrice(tempRoomNumber);

            if (hotelBookingList.cancelBooking(tempBookingId)) {
                loseHotelMoney(tempRoomPrice);
                System.out.println("예약이 취소되었습니다.");
            } else System.out.println("해당하는 예약을 찾을 수 없습니다.");
        }catch (IllegalArgumentException e){
            System.out.println( e.getMessage() + "   해당하는 예약을 찾을 수 없습니다." );
        }
    }


    // 3. 고객 예약 확인
    // 예약 번호 입력받아 해당 예약 번호를 가진 예약 정보를 호출하는 메서드
    public void checkBookingByCustomer() {
        System.out.println("예약번호를 입력하세요: ");
        String tempBookingId = scanner.next();

        try {
            int idx = hotelBookingList.getListIndex(tempBookingId);
            List<HotelBooking> bookingList = hotelBookingList.getHotelBookingList();

            String stayingDate = bookingList.get(idx).getStayingDate();
            String roomNumber = bookingList.get(idx).getRoomNumber();
            String bookingDate = bookingList.get(idx).getBookingDate();
            String bookingID = bookingList.get(idx).getBookingId();
            String name = bookingList.get(idx).getName();
            String roomSize = roomList.getRoomSize(roomNumber);
            int roomPrice = roomList.getRoomPrice(roomNumber);

            System.out.println("숙박일  : " + stayingDate);
            System.out.println("예약자명 : " + name);
            System.out.println("방 번호 : " + roomNumber);
            System.out.println("방 크기 : " + roomSize);
            System.out.println("가 격  : " + roomPrice);
            System.out.println("예약일  : " + bookingDate);
            System.out.println("예약번호 : " + bookingID);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("잘못된 예약 번호 입니다.");
        }
    }
    // 4. 호텔 예약 확인
    public void printBookingListByHotel(){
        for(HotelBooking hotelBooking: hotelBookingList.getHotelBookingList()){
            String tempRoomNumber = hotelBooking.getRoomNumber();
            System.out.println("숙박일 : "+hotelBooking.getStayingDate());
            System.out.println("고객명 : "+hotelBooking.getName());
            System.out.println("방 번호 : "+hotelBooking.getRoomNumber());
            System.out.println("방 크기 : "+roomList.getRoomSize(tempRoomNumber));
            System.out.println("가격 : "+roomList.getRoomPrice(tempRoomNumber));
            System.out.println("예약시점 : "+hotelBooking.getBookingDate());
            System.out.println("예약번호 : "+hotelBooking.getBookingId());
            System.out.println("===========================================");
            System.out.println();
        }
    }



    // 5. 호텔 자산 출력 함수
    public void printHotelMoney(){
        System.out.println("현재 호텔 총 자산: "+getHotelMoney());
    }

}
