package hotelBookingProgram;

import java.util.Arrays;
import java.util.Scanner;

public class CheckBooking {
    public void checkBooking(HotelBookingList hotelBookingList) {
        Scanner sc = new Scanner(System.in);
        String tempid = sc.nextLine();


        System.out.println("조회 할 예약의 예약 번호를 입력하세요. :");

        if (hotelBookingList.getbookingId().equals(tempid)) {
            System.out.println("입력하신 예약 번호로 조회합니다.");
            System.out.println(hotelBookingList.getIndex(tempid));


        } else{
            System.out.println("존재하지 않는 예약 번호입니다.");
        }
        System.out.println("조회가 완료되었습니다.");
    }
    }
