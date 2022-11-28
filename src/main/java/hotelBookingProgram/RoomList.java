package hotelBookingProgram;

import java.util.ArrayList;
import java.util.List;

public class RoomList {

    private List<Room> roomList = new ArrayList<>();

    public RoomList(){
        this.roomList.add(new Room("101", "스탠다드",120_000));
        this.roomList.add(new Room("102", "스탠다드",120_000));
        this.roomList.add(new Room("103", "스탠다드",120_000));
        this.roomList.add(new Room("104", "스탠다드",120_000));
        this.roomList.add(new Room("105", "스탠다드",120_000));
        this.roomList.add(new Room("201", "더블룸(싱글배드)",220_000));
        this.roomList.add(new Room("202", "더블룸(싱글배드)",220_000));
        this.roomList.add(new Room("203", "더블룸(더블배드)",220_000));
        this.roomList.add(new Room("204", "더블룸(더블배드)",220_000));
        this.roomList.add(new Room("205", "더블룸(더블배드)",220_000));
        this.roomList.add(new Room("301", "패밀리룸",320_000));
        this.roomList.add(new Room("302", "패밀리룸",320_000));
        this.roomList.add(new Room("303", "패밀리룸",320_000));
        this.roomList.add(new Room("304", "패밀리룸",320_000));
        this.roomList.add(new Room("305", "패밀리룸",320_000));
        this.roomList.add(new Room("401", "스위트",420_000));
        this.roomList.add(new Room("402", "스위트",420_000));
        this.roomList.add(new Room("403", "스위트",420_000));
        this.roomList.add(new Room("404", "NOT_FOUND",0));
        this.roomList.add(new Room("405", "스위트",420_000));
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


    // 룸넘버 입력 받으면 해당 룸의 크기를 반환하는 메서드
    public String getRoomSize(String roomNumber){
        for(Room room: roomList){
            if(room.getRoomNumber().equals(roomNumber)){
                return room.getRoomSize();
            }
        }throw new IllegalArgumentException("ERROR");
    }


}

