package hotelBookingProgram;

import java.util.regex.Pattern;

public class Customer {
    public String name;
    public int money;
    public String phoneNumber;

    public Customer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public boolean phoneNumber(String tempPhoneNumber) { //tempPhoneNumber: 입력받은 핸드폰번호
        String regEx = "(010)-\\d{4}-\\d{4}";
        if(!Pattern.matches(regEx, tempPhoneNumber))
            return false;
        else {
            this.phoneNumber = tempPhoneNumber.replaceAll(regEx, "$1-$2-$3");
            return true;
        }
    }
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getMoney() {
        return money;
    }

}







