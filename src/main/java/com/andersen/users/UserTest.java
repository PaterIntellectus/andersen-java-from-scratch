package com.andersen.users;

import com.andersen.concert_tickets.Ticket;

import java.util.ArrayList;

public class UserTest {
    public static void main(String[] args) {
        final var tickets = new ArrayList<Ticket>(3);
        tickets.add(new Ticket(1, "SW Hall #1", "327", false, Ticket.StadiumSector.C, 12, 49.99));
        tickets.add(new Ticket(2, "SW Hall #2", "321", true, Ticket.StadiumSector.A, 15, 14.99));
        tickets.add(new Ticket(3, "SW Hall #1", "327", false, Ticket.StadiumSector.B, 12, 49.99));


        final var users = new ArrayList<User>(4);
        users.add(new Client(2, "Malcolm", tickets.get(0)));
        users.add(new Client( 3, "Linda", tickets.get(1)));
        users.add(new Admin(1, "John"));
        users.add(new Client(4, "George", tickets.get(2)));


        System.out.printf("We have %d users right now\n", users.size());
        System.out.println("Three clients and one admin\n");
        System.out.println("We need to find a Client with promo ticket\n");
        System.out.println("For this purpose we need to find an admin\n");

        System.out.println("lest try to find an Admin\n");

        usersLoop:
        for (final var user : users) {
            if (user instanceof Client client) {
                client.printRole();
                System.out.printf("Lets see this Client's ticket:\n%s\n\n", client.getTicket());
            }

            if (user instanceof Admin admin) {
                System.out.printf("Here is our %s\n", admin.getName());
                admin.printRole();
                System.out.println("Lest check all the tickets:");

                for (final var ticket : tickets) {
                    admin.checkTicket(ticket);

                    if (ticket.getIsPromo()) {
                        System.out.println("Finally! We found it!");
                        break usersLoop;
                    }
                }
            }
        }


    }
}
