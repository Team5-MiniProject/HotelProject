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

    public List<Room> getRoomList() {
        return roomList;
    }

    // (RL-1) 룸 전체 목록 뽑아내는 메서드
    public void printAllRoomList(){
        for(Room room : roomList){
            System.out.println(room);
        }
        System.out.println();
    }


    // (RL-2) 룸 넘버를 입력하면 해당 방 금액을 리턴하는 메서드 (잘 돌아감_혹시 모를 상황 대비해 놔둠 )
//    public int getRoomPrice(String roomNumber){
//        int selectedRoomPrice = 0;
//        for(int i=0; i<roomList.size(); i++){
//            if(roomNumber.equals(roomList.get(i).getRoomNumber())){
//                selectedRoomPrice = roomList.get(i).getRoomPrice();
//                break;
//            } selectedRoomPrice = -1;
//        }
//        return selectedRoomPrice;
//    }

    // (RL-2) 룸 넘버를 입력하면 해당 방 금액을 리턴하는 메서드
    public int getRoomPrice(String roomNumber){
        for(Room room : roomList){
            if(room.getRoomNumber().equals(roomNumber)){
                return room.getRoomPrice();
            }
        }throw new IllegalArgumentException("ERROR"); // 혹시라도 잘못된 값이 들어오면 에러
    }

    //(RL-3) 입력 받은 룸넘버를 가진 Room객체가 리스트에 존재하는지 확인하는 메서드
    public boolean getRoom(String roomNumber){

        for(Room room : this.roomList){
            if(room.getRoomNumber().equals(roomNumber)){
                System.out.println(roomNumber+"방을 선택하셨습니다.");
                return true;
            }
        }
        System.out.println("존재하지 않는 방입니다.");
        return false;
    }

    //(RL-4) 룸넘버 입력하면 해당 룸의 인덱스를 반환해주는 메서드
    // 작성해둔 메서드는 논리적으로 틀렸고, 어디에 필요해서 RL-4를 만들려고 하는 지 까먹음.
    // 그래서 기존 코드 삭제


}

