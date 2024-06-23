package com.andersen.BusTicketValidator;

public class BusTicket {
    private String ticketClass;

    private String ticketType;

    private String startDate;

    private int price;


    public String getTicketClass() {
        return ticketClass;
    }

    public String getTicketType() {
        return ticketType;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getPrice() {
        return price;
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

