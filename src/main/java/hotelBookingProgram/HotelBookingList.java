package hotelBookingProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelBookingList {

    private List<HotelBooking> hotelBookingList = new ArrayList<>();

    public void add(HotelBooking hotelBooking){
        hotelBookingList.add(hotelBooking);
    }

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

    public boolean cancelBooking(String bookingId){
        int idx = getListIndex(bookingId);
        if(idx != -1) {
            hotelBookingList.remove(idx);
            return true;
        }else return false;
    }

}


