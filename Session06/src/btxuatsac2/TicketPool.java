package btxuatsac2;

import java.util.*;

public class TicketPool {

    String roomName;
    List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int capacity) {

        this.roomName = roomName;

        for (int i = 1; i <= capacity; i++) {
            String id = roomName + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));
        }
    }

    public synchronized Ticket holdTicket(boolean isVIP, String counterName) {

        while (true) {

            for (Ticket t : tickets) {

                if (!t.isSold && !t.isHeld) {

                    t.isHeld = true;
                    t.isVIP = isVIP;
                    t.holdExpiryTime = System.currentTimeMillis() + 5000;

                    System.out.println(counterName +
                            ": Đã giữ vé " + t.ticketId +
                            (isVIP ? " (VIP)" : "") +
                            ". Vui lòng thanh toán trong 5s");

                    return t;
                }
            }

            try {
                System.out.println(counterName +
                        ": Vé phòng " + roomName +
                        " đang được giữ bởi quầy khác, chờ...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sellHeldTicket(Ticket t, String counterName) {

        if (t != null && t.isHeld) {

            t.isHeld = false;
            t.isSold = true;

            System.out.println(counterName +
                    ": Thanh toán thành công vé " +
                    t.ticketId);

            notifyAll();
        }
    }

    public synchronized void releaseExpiredTickets() {

        long now = System.currentTimeMillis();

        for (Ticket t : tickets) {

            if (t.isHeld && !t.isSold && now > t.holdExpiryTime) {

                t.isHeld = false;

                System.out.println(
                        "TimeoutManager: Vé " +
                                t.ticketId +
                                " hết hạn giữ, đã trả lại kho"
                );

                notifyAll();
            }
        }
    }
}