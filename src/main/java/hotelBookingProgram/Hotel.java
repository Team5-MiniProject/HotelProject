package hotelBookingProgram;

import java.util.Scanner;

public class Hotel {

    Scanner scanner = new Scanner(System.in);

    private int hotelMoney;
    private HotelBookingList hotelBookingList = new HotelBookingList();
    private RoomList roomList = new RoomList();

    // 호텔 자산을 불러온다.
    public int getHotelMoney() {
        return hotelMoney;
    }

    // 호텔의 자산이 늘어나거나 줄어든다.
    public void hotelLoseAndEarnMoney(int hotelMoeny) {
        this.hotelMoney = hotelMoeny;
    }

    // 질문점 ( 중간에 잘못된 번호를 입력 받거나 결제 금액이 다르거나 할 때 메서드를 종료 시키는
    // 방법은 무엇인가? 인터페이스에서 다시 메뉴 화면으로 돌아가야 하기 때문! System.exit(0)??  )
    // 1. 예약 받기 - 고객 객체를 생성해야함 / 예약 객체를 생성해야함 / 예약 리스트에 추가해야함.
    public void receiveBooking() {

        HotelBooking hotelBooking = new HotelBooking();

        System.out.println("예약자 성함을 입력하세요: ");
        String tempName = scanner.next();

        System.out.println("예약자 전화번호 입력하세요: ");
        String tempPhoneNumber = scanner.next();

        // 번호가 맞는 형식으로 입력되어 있는지 확인하고 제대로 입력되면 객체에 저장한다.
        if (!(hotelBooking.inputCustomerPhoneNumber(tempPhoneNumber))) {
            System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
        }

        // 호텔 방 목록을 보여준다. 호텔 룸 프린트 메서드 실행 (RL-1)

        System.out.println("숙박할 날짜를 입력해주세요 ex)0825: ");
        int tempDate = scanner.nextInt();

//         구현 해야 할 부분
//        if( !(HB - 1 )메서드 ){
//        //HB-1 메서드는 해당 날짜를 가진 예약이 있는 지 확인해준다.
//              System.out.println("해당 날짜는 이미 예약이 완료되었습니다: ");
//        }

        System.out.println("원하는 방 번호를 입력하세요: ");
        String tempRoomNumber = scanner.next();

        System.out.println("결제하실 금액을 입력하세요: ");
        int tempMoney = scanner.nextInt();

        // 입력한 방번호에 해당하는 방의 금액을 tempRoomMoney에 저장한다.
        int tempRoomMoeny = roomList.getRoomPrice(tempRoomNumber);

        if(tempMoney == tempRoomMoeny ){
            // 입력 받은 값으로 고객 객체를 생성한다.
            hotelBooking.createCustomer(tempName,tempMoney);
            // 해당 예약을 리스트에 추가한다.
            hotelBookingList.add(hotelBooking);
            System.out.println("예약이 완료되었습니다.");

            // 예약 번호 불러와서 출력하기
            System.out.println("고객님의 예약번호 입니다.");
            System.out.println(hotelBooking.getBookingId());

            // 호텔 자산에 돈을 추가한다.
            hotelMoney +=tempMoney;
        }else if(tempMoney < tempRoomMoeny){
            System.out.println("금액이 부족합니다.");
        }else System.out.println("결제 오류"); // 오류 메시지 따로 만들까요??

    }

    // 2. 예약 취소 - 생성된
    public void bookingCancel(){
        System.out.println("예약번호를 입력하세요: ");
        String tempBookingId = scanner.next();

        if(hotelBookingList.cancelBooking(tempBookingId)){
            System.out.println("예약이 취소되었습니다.");
        }else System.out.println("해당하는 예약을 찾을 수 없습니다.");

    }



    // 3. 고객 예약 확인

    // 4. 호텔 예약 확인



}
