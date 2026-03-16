package btxuatsac;

import java.util.*;

public class BookingCounter implements Runnable{

    String name;

    List<TicketPool> pools;

    Random rd=new Random();

    public BookingCounter(String name,List<TicketPool> pools){

        this.name=name;
        this.pools=pools;
    }

    public void run(){

        while(true){

            TicketPool pool=
                    pools.get(rd.nextInt(pools.size()));

            boolean vip=rd.nextBoolean();

            Ticket t=pool.holdTicket(vip,name);

            try{

                Thread.sleep(3000);

            }catch(Exception e){}

            if(System.currentTimeMillis()<t.holdExpiryTime){

                pool.sellHeldTicket(t,name);
            }

            try{

                Thread.sleep(1000);

            }catch(Exception e){}
        }
    }
}