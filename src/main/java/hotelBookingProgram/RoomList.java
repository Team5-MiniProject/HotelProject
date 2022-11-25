package hotelBookingProgram;

import java.util.ArrayList;
import java.util.List;

public class RoomList {

    private List<Room> roomList = new ArrayList<>();

    public RoomList(){
        this.roomList.add(new Room("101", "스탠다드",120_000));
        this.roomList.add(new Room("102", "더블룸(싱글배드)",220_000));
        this.roomList.add(new Room("103", "더블룸(더블배드)",220_000));
        this.roomList.add(new Room("104", "패밀리룸",320_000));
        this.roomList.add(new Room("105", "스위트",420_000));
    }

    // (RL-1) 룸 전체 목록 뽑아내는 메서드
    public void printAllRoomList(){
        for(Room room : roomList){
            System.out.println(room);
        }
        System.out.println();
    }


    // (RL-2) 룸 넘버를 입력하면 해당 방 금액을 리턴하는 메서드
    public int getRoomPrice(String roomNumber){
        int selectedRoomPrice = 0;
        for(int i=0; i<roomList.size(); i++){
            if(roomNumber.equals(roomList.get(i).getRoomNumber())){
                selectedRoomPrice = roomList.get(i).getRoomPrice();
                break;
            } selectedRoomPrice = -1;
        }
        return selectedRoomPrice;
    }

}

