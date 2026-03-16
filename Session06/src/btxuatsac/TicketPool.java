package btxuatsac;

import java.util.*;

public class TicketPool {

    String roomName;

    List<Ticket> tickets=new ArrayList<>();

    public TicketPool(String room,int count){

        roomName=room;

        for(int i=1;i<=count;i++){

            String id=room+"-"+String.format("%03d",i);

            tickets.add(new Ticket(id,room));
        }
    }

    public synchronized Ticket holdTicket(boolean vip,String counter){

        while(true){

            for(Ticket t:tickets){

                if(!t.isSold && !t.isHeld){

                    t.isHeld=true;
                    t.isVIP=vip;

                    t.holdExpiryTime=
                            System.currentTimeMillis()+5000;

                    System.out.println(counter+
                            ": Đã giữ vé "+t.ticketId+
                            (vip?" (VIP)":"")+
                            " trong 5s");

                    return t;
                }
            }

            try{

                System.out.println(counter+
                        ": Không còn vé phòng "+
                        roomName+" đang chờ...");

                wait();

            }
            catch(Exception e){}
        }
    }

    public synchronized void sellHeldTicket(Ticket t,String counter){

        if(t!=null && t.isHeld){

            t.isSold=true;
            t.isHeld=false;

            System.out.println(counter+
                    ": Thanh toán thành công "+
                    t.ticketId);

            notifyAll();
        }
    }

    public synchronized void releaseExpiredTickets(){

        long now=System.currentTimeMillis();

        for(Ticket t:tickets){

            if(t.isHeld && !t.isSold
                    && now>t.holdExpiryTime){

                t.isHeld=false;

                System.out.println(
                        "TimeoutManager: Vé "+
                                t.ticketId+
                                " hết hạn giữ -> trả lại kho"
                );

                notifyAll();
            }
        }
    }
}