package com.andersen.TicketService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class TicketService {
    public static void main(String[] args) {
        final var ticketStorage = new ArrayList<Ticket>(10);

        ticketStorage.add(new Ticket());
        ticketStorage.add(new Ticket(1, "SW Hall #1", "327", false, Ticket.StadiumSector.A, 12, 49.90));
        ticketStorage.add(new Ticket(2, "SW Hall #1", "327", false, Ticket.StadiumSector.B, 8, 29.90));
        ticketStorage.add(new Ticket("Opera Hall", "419"));
        ticketStorage.add(new Ticket(3, "SW Hall #2", "327", false, Ticket.StadiumSector.C, 4, 12.90));

        ticketStorage.add(new Ticket(4, "SW Hall #1", "327", false, Ticket.StadiumSector.A, 12, 49.90));
        ticketStorage.add(new Ticket("Opera Hall", "419"));
        ticketStorage.add(new Ticket());
        ticketStorage.add(new Ticket(5, "SW Hall #2", "327", false, Ticket.StadiumSector.C, 4, 12.90));
        ticketStorage.add(new Ticket());

        ticketStorage.add(new Ticket(6, null,null,false,null,0,0));

        System.out.println("Ticket Storage:");
        for (final var ticket : ticketStorage) {
            System.out.println(ticket);
        }

        System.out.println("Tickets by id:");
        System.out.printf("Ticket with id = 1: %s\n", getTicketByID(ticketStorage, 1));
        System.out.printf("Ticket with id = 4: %s\n", getTicketByID(ticketStorage, 4));
        System.out.printf("Ticket with id = 2: %s\n", getTicketByID(ticketStorage, 2));
        System.out.printf("Ticket with id = 3: %s\n", getTicketByID(ticketStorage, 3));
    }

    static Ticket getTicketByID(Collection<Ticket> ticketStorage, int id) {
        for (final var ticket : ticketStorage) {
            if (ticket.getId() != 0 && ticket.getId() == id) {
                return ticket;
            } else {
                if (Objects.equals(ticket.getId(), id)) {
                    return ticket;
                }
            }
        }
        return null;
    }
}
