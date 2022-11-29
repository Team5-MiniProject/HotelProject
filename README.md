# 쵝5조 호텔 🏟


💻Spring A반 5조 호텔 예약 프로그램 프로젝트

<br>

## 📌프로그램 필수 요구사항



1. 호텔은 여러 객실, 보유 자산을 가지고 있다.
2. 객실은 객실 당 하루에 한 사람만 예약이 가능하다.
3. 객실은 크기, 숙박비를 가진다.
4. 예약은 객실, 고객의 이름, 고객의 전화번호, 예약 날짜를 가지고 있다.
    1. 전화 번호 제한(XXX-XXXX-XXXX) 정규 표현식 (선택)
    2. 예약 날짜  

       날짜는 ISO 8601 형식으로
       조합된 UTC 날짜 및 시간
       예) 2016-10-27T17:13:40+00:00

5. 고객은 이름, 전화번호, 소지금을 가진다.
    1. 고객 소지금보다 비싼 방은 예약 불가
6. 호텔은 모든 예약 목록을 조회 할 수 있다.
7. 고객은 자신의 예약 목록을 조회 할 수 있다.
    1. 예약 번호로 예약 내역을 조회한다
8. 고객은 자신의 예약을 취소 할 수 있다.
9. 고객이 호텔 예약 시에 예약 번호(id)를 반환 (uuid 활용)
    1. 고객이 호텔 예약에 성공하면 예약 번호(id)를 받는다.
    2. 고객이 예약 목록을 조회 시 예약 번호도 같이 조회 된다.
    3. 고객이 예약 취소 시 예약 번호를 통해 자신의 특정 예약을 취소한다.

<br>
<br>

## 클래스 다이어그램


<img src = "https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F46faa7c8-d9a5-4f57-a9fb-6bf493d56273%2FUntitled.png?table=block&id=ac14afc8-5f89-4686-8088-194c1b6ca4a6&spaceId=25861e62-88f1-4b07-b2d6-54a36672be16&width=1730&userId=4ee29aa9-6a6f-484d-8ad1-d6eab9d7139b&cache=v2">



<br>
<br>


## 👨🏼‍🤝‍👨🏼팀원 및 역할


기능에 따라 역할 분담

- 김현중: 예약 취소, 예약 목록 조회(고객) 
- 안해리: 예약 목록 조회(호텔)
- 이송언: 고객 클래스, 호텔 부킹 클래스
- 이신희: 객실 예약, 메인 프레젠테이션
- 장지예: 룸 클래스, 호텔 클래스

<br>
<br>

## UI 와이어프레임

```java
======== 쵝5조 호텔 =========

1. 관리자
2. 고객
0. 시스템 종료

=============================
번호를 입력해주세요:

// < 1 번 선택시 > 

예약을 조회합니다.

관리자 비밀번호를 입력해 주세요: 

--

// < 비밀번호가 틀렸을 시 >

잘못된 비밀번호 입니다.

// < 비밀번호가 맞았을 시 > 

호텔 총 자산: 

숙박일:
고객명:
방 번호:
방 크기:
가격:
예약시점:
예약번호:
================================


 // < 2 번 선택시 > 

========== 쵝5조 호텔 ========== 

환영합니다. 쵝5조 호텔입니다.    

1. 예약 하기     	 

2. 예약 조회		 

3. 예약 취소

4. 돌아 가기

0. 시스템 종료

원하시는 메뉴를 선택해주세요!         

==============================



//  < 예약하기 >

예약자의 성함을 적어주세요 :

--

예약자의 전화번호를 적어주세요 :

--

=============================

101    스탠다드    120,000    

102    더블룸   140,000    

=============================

원하는 방 번호를 입력하세요 :

--

-방을 선택하셨습니다.

숙박할 날짜를 입력해주세요 ex)2022-12-25 :

--

결제하실 금액을 입력하세요:

--

// < 금액이 틀렸을 시 >

   // < 입력금액 < 방 금액>
금액이 부족합니다.

   // < 입력금액 > 방금액>
결제 오류


// < 금액이 맞았을 시 > 

예약이 완료되었습니다.

고객님의 예약번호 입니다.

((예약번호))



// < 예약 조회 >
================================
예약번호를 입력하세요:
--

숙박일:
고객명:
방 번호:
방 크기:
가격:
예약시점:
예약번호:


// < 예약 취소 >

예약 번호를 입력하세요 :
--

// < 예약 번호가 맞았을 때 >
 예약이 취소되었습니다.

// < 예약 번호가 톨렸을 때 >
해당하는 예약을 찾을 수 없습니다

// < 시스템 종료 >
==============================
종료합니다.

```





