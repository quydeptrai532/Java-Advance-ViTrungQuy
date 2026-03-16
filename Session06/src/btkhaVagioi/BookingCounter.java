package btkhaVagioi;

import java.util.Random;

public class BookingCounter implements Runnable{

    String counterName;
    TicketPool roomA;
    TicketPool roomB;

    int soldCount=0;

    Random rand=new Random();

    public BookingCounter(String name,
                          TicketPool A,
                          TicketPool B){

        counterName=name;
        roomA=A;
        roomB=B;
    }

    public void run(){

        while(true){

            Ticket t;

            if(rand.nextBoolean())
                t=roomA.sellTicket();
            else
                t=roomB.sellTicket();

            soldCount++;

            System.out.println(counterName+
                    " bán vé "+t.ticketId+
                    " phòng "+t.roomName);

            try{Thread.sleep(200);}catch(Exception e){}
        }
    }

    public int getSoldCount(){
        return soldCount;
    }
}