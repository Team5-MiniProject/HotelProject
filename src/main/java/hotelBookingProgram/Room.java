package hotelBookingProgram;

public class Room {

    private String name;
    private int roomPrice;
    private String roomSize;
    private String bookingDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Room (String name, int roomPrice, String roomSize){
        this.name = name;
        this.roomPrice = roomPrice;
        this.roomSize = roomSize;
        this.bookingDate = formatter.format(LocalDateTime.now());
    }

    public String toString(){
        return name +"    "+ roomSize+"    "+bookingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getroomPrice() {
        return roomPrice;
    }

    public void setroomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getroomSize() {
        return roomSize;
    }

    public void setroomSize(String roomSize) {
        this.roomSize = roomSize;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String BookingDate) {
        this.bookingDate = bookingDate;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }
}
