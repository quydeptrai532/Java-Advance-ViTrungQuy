package btkhaVagioi;

public class TicketSupplier implements Runnable{

    TicketPool roomA;
    TicketPool roomB;

    int supplyCount;
    int interval;
    int rounds;

    public TicketSupplier(TicketPool A,
                          TicketPool B,
                          int supply,
                          int interval,
                          int rounds){

        roomA=A;
        roomB=B;

        supplyCount=supply;
        this.interval=interval;
        this.rounds=rounds;
    }

    public void run(){

        for(int i=0;i<rounds;i++){

            try{
                Thread.sleep(interval);
            }
            catch(Exception e){}

            roomA.addTickets(supplyCount);
            roomB.addTickets(supplyCount);
        }
    }
}