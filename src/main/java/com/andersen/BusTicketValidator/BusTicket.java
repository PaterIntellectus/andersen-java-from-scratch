package com.andersen.BusTicketValidator;

public class BusTicket {

    String ticketClass;

    String ticketType;

    String startDate;

    String price;


    public BusTicket() {
        this.ticketClass = "";
        this.ticketType = "";
        this.startDate = "";
        this.price = "";
    }


    public void setPrice(String price) {
        this.price = price;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }
}

