package com.andersen.User;

import com.andersen.concert_tickets.Ticket;

public class Client extends User {
    private final Ticket ticket;

    public Client(int id, String name, Ticket ticket) {
        super(id, name);

        this.ticket = ticket;
    }

    @Override
    public void printRole() {
        System.out.printf("%s is a Client\n", getName());
    }

    public Ticket getTicket() {
        return ticket;
    }
}

