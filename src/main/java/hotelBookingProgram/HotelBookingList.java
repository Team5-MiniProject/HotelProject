package hotelBookingProgram;

import java.util.ArrayList;
import java.util.List;

public class HotelBookingList {

    private List<HotelBooking> hotelBookingList = new ArrayList<>();

    public List<HotelBooking> getHotelBookingList() {
        return hotelBookingList;
    }

    // 예약을 예약 리스트에 추가한다.
    public void add(HotelBooking hotelBooking){
        hotelBookingList.add(hotelBooking);
    }

    // 예약번호를 입력하면 해당 예약번호를 가진 객체의 인덱스 값을 반환해준다, 없을 시 -1 반
    public int getListIndex(String bookingId){
        int tempidx = 0;
        for(int i=0; i<hotelBookingList.size(); i++){
            if(bookingId.equals(hotelBookingList.get(i).getBookingId())){
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

    // 예약이 중복되지 않도록 예약 날자와 예약
    public int checkBookingPossible(String stayingDate, String roomNumber) {

        for(HotelBooking booking : hotelBookingList){
            String tempStayingDate = booking.getStayingDate();
            String tempRoomNumber = booking.getRoomNumber();
            if(tempStayingDate.equals(stayingDate) && tempRoomNumber.equals(roomNumber)){
                return -1;
            }
        }return 1;
    }



}
