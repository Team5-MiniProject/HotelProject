package hotelBookingProgram;

import java.util.ArrayList;
import java.util.List;

public class CancelBooking {
    public void cancelBooking(String id) {
        List<HotelBooking> bookingList = new ArrayList<>(); // 테스트용. 지워도 되는 부분.

        for (int i = bookingList.size(); i > 0; i--) {
            if (id.equals(bookingList.get(i - 1).getId())) {
                bookingList.remove(i - 1);
                System.out.println("예약이 취소되었습니다.");
            }
            else {
                System.out.println("일치하는 예약 정보가 없습니다. ");
            }
        }
        /* 테스트용
        List<String> forTest = new ArrayList<>();

        forTest.add("하나") ;
        forTest.add("둘") ;
        forTest.add("넷") ;
        forTest.add("다섯") ;
        forTest.add("여섯") ;

        for( int i = forTest.size(); i >0; i--) {
            System.out.println(forTest.remove(i - 1));
        }

         */
    }
}
