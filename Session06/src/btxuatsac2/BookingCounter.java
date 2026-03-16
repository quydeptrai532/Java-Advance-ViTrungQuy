package btxuatsac2;

import java.util.*;

public class BookingCounter implements Runnable {

    String name;
    List<TicketPool> pools;

    Random rand = new Random();

    public BookingCounter(String name, List<TicketPool> pools) {
        this.name = name;
        this.pools = pools;
    }

    public void run() {

        while (true) {

            TicketPool pool = pools.get(rand.nextInt(pools.size()));

            boolean isVIP = rand.nextBoolean();

            Ticket ticket = pool.holdTicket(isVIP, name);

            try {
                Thread.sleep(3000);
            } catch (Exception e) {}

            if (System.currentTimeMillis() < ticket.holdExpiryTime) {
                pool.sellHeldTicket(ticket, name);
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}