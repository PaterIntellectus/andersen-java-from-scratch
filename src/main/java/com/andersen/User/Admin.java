package com.andersen.User;

import com.andersen.TicketService.Ticket;

public class Admin extends User {
    Admin(int id , String name) {
        super(id, name);
    }

    @Override
    public void printRole() {
        System.out.printf("%d is a Admin\n", getId());
    }

    void checkTicket(Ticket ticket) {
        System.out.printf("Ticket '%d' checked:\n", ticket.getId());
        System.out.printf("This ticket is %s promo ticket!\n", ticket.getIsPromo() ?"" : "not");
    }
}
