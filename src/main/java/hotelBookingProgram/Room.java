package hotelBookingProgram;


public class Room {
    //고객 이름  방 가격 사이즈 날짜
    private String roomNumber;
    private String roomSize;
    private int roomPrice;
    private boolean isEmpty;

    //전부 public을 private로..
    public Room(String roomNumber, String roomSize, int roomPrice) {
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomPrice = roomPrice;
        this.isEmpty = true;
    }

    private String getRoomNumber() {
        return roomNumber;
    }

    private void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    private String getroomSize() {
        return roomSize;
    }

    private void setroomSize(String roomSize) {
        this.roomSize = roomSize;
    }

    private int getroomPrice() {
        return roomPrice;
    }

    private void setroomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }


    public String toString() {
        return roomNumber + "    " + roomSize + "    " + roomPrice;
    }

    //boolean 만들기
}
   // public boolean roomIsEmpty
    //true/false를 어떻게 알고 나눠줄 것이냐





