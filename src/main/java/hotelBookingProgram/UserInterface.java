package hotelBookingProgram;

import java.util.Scanner;

public class UserInterface {

    public void usrInterfaceRun(){
        int selectedMenu = 0;
        int selectedUserMenu = 0;
        Scanner scanner = new Scanner(System.in);
        HotelBookingList bookingList = new HotelBookingList();

        while (true){

            System.out.println("========== 쵝5조 호텔 ==========");
            System.out.println("1. 관리자");
            System.out.println("2. 고객");
            System.out.println("==============================");

            System.out.println("번호를 입력해주세요: ");
            selectedMenu = scanner.nextInt();

            if(selectedMenu == 1){
                int tempAdminPsw;
                System.out.println("예약을 조회합니다.");
                System.out.println("관리자 비밀번호를 입력해주세요:");
                tempAdminPsw = scanner.nextInt();

                if(tempAdminPsw == 0 /*관리자 비밀번호랑 비교*/){
                    // printAllBooking();
                }else{
                    System.out.println("잘못된 비밀번호 입니다.");
                    continue;
                }

            }else{
                Loop:
                while(true){
                    System.out.println("========== 쵝5조 호텔 ==========");
                    System.out.println("환영합니다. 쵝5조 호텔입니다.");
                    System.out.println("1. 예약 하기");
                    System.out.println("2. 예약 조회");
                    System.out.println("3. 예약 취소");
                    System.out.println("4. 돌아 가기");
                    System.out.println();
                    System.out.println("원하시는 메뉴를 선택해주세요!");
                    selectedUserMenu = scanner.nextInt();
                    System.out.println("==============================");

                    if( selectedUserMenu == 1) {
//
//                        HotelBooking booking = new HotelBooking();
//
//                        System.out.println("이름을 입력하세요: ");
//                        String name = scanner.next();
//                        booking.setName(name);
//
//                        System.out.println("번호를 입력하세요: ");
//                        String phoneNumber = scanner.next();
//                        if(booking.setPhoneNumber(phoneNumber)== false){
//                            System.out.println("잘못된 형식의 번호입니다. 다시 입력해주세요");
//                            break;
//                        }
//
//                        System.out.println("금액을 입력하세요: ");
//                        int money = scanner.nextInt();
//                        booking.setMoney(money);
//
//                        if( booking.getMoney() >= 방금액){
//                            System.out.println(booking.getName()+"님이 머물 수 있는 방입니다.");
//                            // 목록 출력
//                            if(호텔.isEmpty == true){
//                                System.out.println("이미 예약이 완료된 방입니다.");
//                            }
//                            else{
//                                System.out.println("예약이 완료되었습니다.");
//                                bookingList.add(booking);
//                            }
//                        }else{
//                            System.out.println("금액이 부족합니다.");
//                        }


                    } else if(selectedUserMenu == 2){
                        // 조회 메서드
                    } else if(selectedUserMenu == 3){
                        // 취소 메서드
                    } else if(selectedUserMenu == 4){
                        break Loop;
                    } else{
                        System.out.println("잘못된 입력입니다.");
                        continue;
                    }

                }

            }

        }

    }
}
