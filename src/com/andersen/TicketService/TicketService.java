package com.andersen.TicketService;

import java.util.ArrayList;

public class TicketService {



    public static void main(String[] args) {
        final ArrayList<Ticket> tickets = new ArrayList<Ticket>(10);

        tickets.add(new Ticket());
        tickets.get(0).setId("null");
        tickets.add(new Ticket("R2D2", "SW Hall #1", "327", false, Ticket.StadiumSector.A, 12, 49.90));
        tickets.add(new Ticket("GHA4", "SW Hall #1", "327", false, Ticket.StadiumSector.B, 8, 29.90));
        tickets.add(new Ticket("Opera Hall", "419"));
        tickets.add(new Ticket("GH2K", "SW Hall #2", "327", false, Ticket.StadiumSector.C, 4, 12.90));

        tickets.add(new Ticket("5TFU", "SW Hall #1", "327", false, Ticket.StadiumSector.A, 12, 49.90));
        tickets.add(new Ticket("Opera Hall", "419"));
        tickets.add(new Ticket());
        tickets.get(7).setId("AR2D");
        tickets.add(new Ticket("LK89", "SW Hall #2", "327", false, Ticket.StadiumSector.C, 4, 12.90));
        tickets.add(new Ticket());


        for (final var ticket : tickets) {
            System.out.println(ticket);
        }
    }
}
