package com.andersen.User;

import com.andersen.concert_tickets.Ticket;

public class Admin extends User {
    public Admin(int id , String name) {
        super(id, name);
    }

    @Override
    public void printRole() {
        System.out.printf("%s is an Admin\n", getName());
    }

    public void checkTicket(Ticket ticket) {
        System.out.printf("Ticket '%d' checked:\n", ticket.getId());
        System.out.printf("This ticket is%s promo ticket!\n", ticket.getIsPromo() ?"" : " not");
    }
}
