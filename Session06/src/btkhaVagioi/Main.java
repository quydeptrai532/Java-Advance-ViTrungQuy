package btkhaVagioi;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A",5);
        TicketPool roomB = new TicketPool("B",5);

        BookingCounter c1 =
                new BookingCounter("Quầy 1",roomA,roomB);

        BookingCounter c2 =
                new BookingCounter("Quầy 2",roomA,roomB);

        TicketSupplier supplier =
                new TicketSupplier(roomA,roomB,
                        3,3000,3);

        Thread t1=new Thread(c1);
        Thread t2=new Thread(c2);
        Thread t3=new Thread(supplier);

        t1.start();
        t2.start();
        t3.start();
    }
}