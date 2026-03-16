package btkhaVagioi;

import java.util.*;

public class TicketPool {

    String roomName;
    List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int count) {

        this.roomName = roomName;

        for(int i=1;i<=count;i++){

            String id = roomName + "-" + String.format("%03d", i);

            tickets.add(new Ticket(id, roomName));
        }
    }

    public synchronized Ticket sellTicket() {

        while(true){

            for(Ticket t : tickets){

                if(!t.isSold){

                    t.isSold = true;
                    return t;
                }
            }

            try {

                System.out.println(
                        "Hết vé phòng " + roomName + ", đang chờ..."
                );

                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void addTickets(int count) {

        int start = tickets.size() + 1;

        for(int i=0;i<count;i++){

            String id = roomName + "-" +
                    String.format("%03d", start+i);

            tickets.add(new Ticket(id, roomName));
        }

        System.out.println(
                "Nhà cung cấp: thêm " + count +
                        " vé vào phòng " + roomName
        );

        notifyAll();
    }

    public int remainingTickets(){

        int c=0;

        for(Ticket t : tickets)
            if(!t.isSold) c++;

        return c;
    }
}