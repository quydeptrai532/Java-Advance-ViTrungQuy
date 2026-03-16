package btth;

import java.util.*;

// ======================= TICKET =======================
class Ticket {
    private int id;
    private boolean sold;

    public Ticket(int id) {
        this.id = id;
        this.sold = false;
    }

    public int getId() {
        return id;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public String toString() {
        return "Ve-" + id;
    }
}


// ======================= TICKET POOL =======================
class TicketPool {

    private Queue<Ticket> tickets = new LinkedList<>();
    private int nextId = 1;

    public TicketPool(int initial) {
        addTickets(initial);
    }

    // bán vé
    public synchronized Ticket sellTicket() {

        while (tickets.isEmpty()) {
            try {
                System.out.println(Thread.currentThread().getName() + ": Het ve, cho...");
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }

        Ticket t = tickets.poll();
        t.setSold(true);
        return t;
    }

    // thêm vé
    public synchronized void addTickets(int count) {

        for (int i = 0; i < count; i++) {
            tickets.add(new Ticket(nextId++));
        }

        System.out.println("Nha cung cap da them " + count + " ve.");
        notifyAll();
    }

    // số vé còn
    public synchronized int getAvailableCount() {
        return tickets.size();
    }
}


// ======================= BOOKING COUNTER =======================
class BookingCounter implements Runnable {

    private String name;
    private TicketPool pool;
    private int soldCount = 0;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    public int getSoldCount() {
        return soldCount;
    }

    @Override
    public void run() {

        while (true) {

            Ticket t = pool.sellTicket();

            if (t == null) break;

            soldCount++;

            System.out.println(name + " ban ve: " + t);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }

            // nếu không còn vé và supplier đã xong thì thoát
            if (pool.getAvailableCount() == 0 && Main.supplierFinished) {
                break;
            }
        }

        System.out.println(name + " dung ban.");
    }
}


// ======================= SUPPLIER =======================
class TicketSupplier implements Runnable {

    private TicketPool pool;
    private int addCount;
    private int delay;

    public TicketSupplier(TicketPool pool, int addCount, int delay) {
        this.pool = pool;
        this.addCount = addCount;
        this.delay = delay;
    }

    @Override
    public void run() {

        try {

            for (int i = 0; i < 3; i++) {

                Thread.sleep(delay);

                pool.addTickets(addCount);
            }

        } catch (InterruptedException e) {
        }

        Main.supplierFinished = true;
    }
}


// ======================= MAIN =======================
public class Main {

    public static volatile boolean supplierFinished = false;

    public static void main(String[] args) throws Exception {

        TicketPool pool = new TicketPool(10);

        BookingCounter c1 = new BookingCounter("Quay 1", pool);
        BookingCounter c2 = new BookingCounter("Quay 2", pool);

        TicketSupplier supplier = new TicketSupplier(pool, 5, 3000);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(supplier);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();

        System.out.println("\n===== KET THUC =====");
        System.out.println("Quay 1 ban: " + c1.getSoldCount());
        System.out.println("Quay 2 ban: " + c2.getSoldCount());
    }
}