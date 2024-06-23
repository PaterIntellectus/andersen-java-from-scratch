package com.andersen.TicketService;


import java.util.*;

public class TicketService {
    public static void main(String[] args) {
        final var ticketStorage = new ArrayList<Ticket>(Arrays.asList(
                new Ticket(1, "SW Hall #1", "327", false, Ticket.StadiumSector.A, 12, 49.90),
                new Ticket(),
                new Ticket(2, "SW Hall #1", "327", false, Ticket.StadiumSector.B, 8, 29.90),
                new Ticket("Opera Hall", "419"),
                new Ticket(3, "SW Hall #2", "327", false, Ticket.StadiumSector.C, 4, 12.90),
                new Ticket(4, "SW Hall #1", "327", false, Ticket.StadiumSector.A, 12, 49.90),
                new Ticket("Opera Hall", "419"),
                new Ticket(),
                new Ticket(5, "SW Hall #2", "327", false, Ticket.StadiumSector.C, 4, 12.90),
                new Ticket()
        ));

        System.out.println("Ticket Storage:");
        for (final var ticket : ticketStorage) {
            System.out.println(ticket);
        }

        System.out.println("Getting Tickets by id:");
        for (final var id : List.of(1, 4, 0, 2, 4, 23)) {
            final var ticket = getTicketByID(ticketStorage, id);

            System.out.printf(
                    "Ticket with id = %d: %s\n", id, ticket.isPresent() ? ticket.get() : "no such ticket!"
            );
        }
    }

    static private Optional<Ticket> getTicketByID(Collection<Ticket> ticketStorage, int id) {
        for (final var ticket : ticketStorage) {
            if (ticket.getId() == id) {
                return Optional.of(ticket);
            }
        }
        return Optional.empty();
    }
}
