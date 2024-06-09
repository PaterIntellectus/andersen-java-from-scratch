package com.andersen.TicketService;

public class TicketService {
    public static void main(String[] args) {
        var emptyTicket = new Ticket();
        var fullTicket = new Ticket(
                "14R2",
                "Hall #1",
                "242",
                true,
                Ticket.StadiumSector.C,
                4.3,
                12.3
        );
        var limitedTicket = new Ticket("Hall #3", "923");

        System.out.println("Empty  : " + emptyTicket);
        System.out.println("Full   : " + fullTicket);
        System.out.println("Limited: " + limitedTicket);
    }

    public static Ticket getTicketByStadiumSector(Ticket[] tickets, Ticket.StadiumSector stadiumSector){
        int found = 0;
        for(int i=0; i<tickets.length; i++){
            if(tickets[i].getStadiumSector() == stadiumSector){
                System.out.println("ticket.id["+i+"]="+tickets[i].getId()+", stadiumSector="+tickets[i].getStadiumSector());
                found = i;
                break;
            }
        }
        return tickets[found];
    }
}
