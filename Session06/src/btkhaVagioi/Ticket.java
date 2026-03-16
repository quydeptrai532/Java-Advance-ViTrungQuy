package btkhaVagioi;

public class Ticket {
    protected String ticketId;
    protected String roomName;
    protected boolean isSold;

    public Ticket(String ticketId, String roomName, boolean isSold) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isSold = isSold;
    }

    public Ticket(String id, String roomName) {
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
}
