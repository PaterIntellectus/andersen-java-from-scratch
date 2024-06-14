package com.andersen.User;

import com.andersen.TicketService.Ticket;

public class Client extends User {
    private Ticket ticket;

    public Client(int id, String name, Ticket ticket) {
        super(id, name);

        this.ticket = ticket;
    }

    @Override
    public void printRole() {
        System.out.printf("%d is a Client\n", getId());
    }

    public Ticket getTicket() {
        return ticket;
    }
}

