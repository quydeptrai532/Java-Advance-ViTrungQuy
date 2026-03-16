package btxuatsac;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA=new TicketPool("A",5);
        TicketPool roomB=new TicketPool("B",6);
        TicketPool roomC=new TicketPool("C",7);

        List<TicketPool> pools=new ArrayList<>();

        pools.add(roomA);
        pools.add(roomB);
        pools.add(roomC);

        for(int i=1;i<=5;i++){

            Thread t=
                    new Thread(
                            new BookingCounter(
                                    "Quầy "+i,
                                    pools));

            t.start();
        }

        Thread timeoutThread=
                new Thread(
                        new TimeoutManager(pools));

        timeoutThread.start();
    }
}