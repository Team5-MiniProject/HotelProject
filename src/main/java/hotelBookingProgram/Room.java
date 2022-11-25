package hotelBookingProgram;


public class Room {
    //고객 이름  방 가격 사이즈 날짜
    private String roomNumber;
    private String roomSize;
    private int roomPrice;

    public Room (String roomNumber, String roomSize, int roomPrice){
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomPrice = roomPrice;
    }

    public String getRoomNumber() {
        return  roomNumber;
    }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber;
    }

    public String getroomSize() {
        return roomSize;
    }
    public void setroomSize(String roomSize) {
        this.roomSize = roomSize;
    }

    public int getroomPrice() {
        return roomPrice;
    }
    public void setroomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }


    public String toString(){
        return roomNumber +"    "+ roomSize+"    "+roomPrice;
    }
}


