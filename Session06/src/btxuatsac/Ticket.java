package btxuatsac;

public class Ticket {

    String ticketId;
    String roomName;

    boolean isSold;
    boolean isHeld;
    boolean isVIP;

    long holdExpiryTime;

    public Ticket(String id,String room){

        ticketId=id;
        roomName=room;

        isSold=false;
        isHeld=false;
        isVIP=false;
    }
}