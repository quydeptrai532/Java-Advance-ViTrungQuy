package btxuatsac2;

public class Ticket {

    String ticketId;
    String roomName;

    boolean isSold;
    boolean isHeld;
    boolean isVIP;

    long holdExpiryTime;

    public Ticket(String id, String room) {
        this.ticketId = id;
        this.roomName = room;

        this.isSold = false;
        this.isHeld = false;
        this.isVIP = false;
    }
}