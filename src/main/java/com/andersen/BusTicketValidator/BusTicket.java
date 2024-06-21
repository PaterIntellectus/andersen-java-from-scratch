package com.andersen.BusTicketValidator;

public class BusTicket {

    String ticketClass;

    String ticketType;

    String startDate;

    int price;


    public BusTicket() {
        this.ticketClass = null;
        this.ticketType = null;
        this.startDate = null;
        this.price = 0;
    }



    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "BusTicket(ticketClass: \"%s\", ticketType: \"%s\", startDate: %s, price: %d)",
                ticketClass, ticketType, startDate, price
        );
    }
}

