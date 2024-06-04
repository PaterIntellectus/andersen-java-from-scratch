package com.andersen.TicketService;

import java.sql.Timestamp;

public class Ticket {
    public enum StadiumSector {
        A, B, C
    }


    private String ID; // max 4 digits/characters
    private String concertHall; // 10 characters
    private String eventCode; // 3 digits
    private Timestamp time;
    private boolean isPromo;
    private StadiumSector stadiumSector;
    private double maxBackpackWeight;
    private double price;


    public Ticket() {

    }

    public Ticket(
            String id,
            String concertHall,
            String eventCode,
            boolean isPromo,
            Ticket.StadiumSector stadiumSector,
            double maxBackpackWeight,
            double price
    ) {
        setId(id);
        setConcertHall(concertHall);
        setEventCode(eventCode);
        setCurrentTime();
        setIsPromo(isPromo);
        setStadiumSector(stadiumSector);
        setMaxBackpackWeight(maxBackpackWeight);
        setPrice(price);
    }

    public Ticket(String concertHall, String eventCode) {
        setConcertHall(concertHall);
        setEventCode(eventCode);
        setCurrentTime();
    }


    public String getId() {
        return ID;
    }

    public void setId(String ID) {
        if (ID == null || ID.length() > 4) {
            throw new IllegalArgumentException("Id must be at most 4 characters long.");
        }

        this.ID = ID;
    }

    public String getConcertHall() {
        return concertHall;
    }

    public void setConcertHall(String concertHall) {
        if (concertHall == null || concertHall.length() > 10) {
            throw new IllegalArgumentException("Concert hall must be at most 10 characters long.");
        }

        this.concertHall = concertHall;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        if (eventCode == null || !eventCode.matches("\\d{3}")) {
            throw new IllegalArgumentException("Event code must be 3 digits long, and contain ONLY digits.");
        }

        this.eventCode = eventCode;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public boolean getIsPromo() {
        return isPromo;
    }

    public void setIsPromo(boolean promo) {
        isPromo = promo;
    }

    public StadiumSector getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(StadiumSector stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    public double getMaxBackpackWeight() {
        return maxBackpackWeight;
    }

    public void setMaxBackpackWeight(double maxBackpackWeight) {
        this.maxBackpackWeight = maxBackpackWeight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private void setCurrentTime() {
        setTime(new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public String toString() {
        return String.format(
                "[id = %s, concertHall = %s, eventCode = %s, " +
                        "time = %s, isPromo = %s, stadiumSector = %s, " +
                        "maxBackpackWeight = %.1f, price = %.2f]",
                getId(),
                getConcertHall(),
                getEventCode(),
                getTime(),
                getIsPromo(),
                getStadiumSector(),
                getMaxBackpackWeight(),
                getPrice()
        );
    }
}
