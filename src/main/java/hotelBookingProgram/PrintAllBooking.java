package hotelBookingProgram;

public class PrintAllBooking {

    public PrintAllBooking() {

        for (HotelBooking hotelBooking : HotelBookingList) {
            System.out.println(hotelBooking);
        }
        System.out.println();
        }
    }

