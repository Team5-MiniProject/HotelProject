package hotelBookingProgram;

import java.util.ArrayList;
import java.util.List;

public class HotelBookingList {

    private List<HotelBooking> hotelBookingList = new ArrayList<>();


    // 예약을 예약 리스트에 추가한다.
    public void add(HotelBooking hotelBooking){
        hotelBookingList.add(hotelBooking);
    }

    // 예약번호를 입력하면 해당 예약번호를 가진 객체의 인덱스 값을 반환해준다, 없을 시 -1 반
    public int getListIndex(String bookingId){
        int tempidx = 0;
        for(int i=0; i<hotelBookingList.size(); i++){
            if(bookingId == hotelBookingList.get(i).getBookingId()){
                tempidx = i;
                break;
            }else tempidx = -1;
        }
        return tempidx;
    }

    // 예약번호를 입력하면 해당 예약을 리스트에서 삭제시키고 true를 반환한다.
    public boolean cancelBooking(String bookingId){
        int idx = getListIndex(bookingId);
        if(idx != -1) {
            hotelBookingList.remove(idx);
            return true;
        }else {
            return false;
        }
    }

//  (HB - 1 )
//    public boolean checkBookingPossible(int stayingDate){
//        // 매개변수 값과 같은 값을 가진 stayingDate를 갖는 객체가 리스트에 존재한다면
//        // false를 반환하고 존재하지 않는 다면 True를 반환해라
//    }

}
