package com.andersen.concert_tickets;

import com.andersen.AbstractEntity.AbstractEntity;
import com.andersen.interfaces.Printable;
import com.andersen.interfaces.Shareable;

import java.sql.Timestamp;
import java.util.Objects;

public class Ticket extends AbstractEntity implements Printable, Shareable  {
    public enum StadiumSector {
        A, B, C
    }


    private String concertHall; // 10 characters
    private String eventCode; // 3 digits
    private Timestamp time;
    private boolean isPromo;
    private StadiumSector stadiumSector;
    private double maxBackpackWeight;
    private double price;


    public Ticket() {
        super();
    }

    public Ticket(
            int id,
            String concertHall,
            String eventCode,
            boolean isPromo,
            Ticket.StadiumSector stadiumSector,
            double maxBackpackWeight,
            double price
    ) {
        super(id);

        setConcertHall(concertHall);
        setEventCode(eventCode);
        setCurrentTime();
        setIsPromo(isPromo);
        setStadiumSector(stadiumSector);
        setMaxBackpackWeight(maxBackpackWeight);
        setPrice(price);
    }

    public Ticket(String concertHall, String eventCode) {
        super(0);

        setConcertHall(concertHall);
        setEventCode(eventCode);
        setCurrentTime();
    }

    public String getConcertHall() {
        return concertHall;
    }

    private void setConcertHall(String concertHall) {
        if (concertHall == null || concertHall.length() > 10) {
            throw new IllegalArgumentException("Concert hall must be at most 10 characters long.");
        }

        this.concertHall = concertHall;
    }

    public String getEventCode() {
        return eventCode;
    }

    private void setEventCode(String eventCode) {
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

    private void setIsPromo(boolean promo) {
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

    private void setMaxBackpackWeight(double maxBackpackWeight) {
        this.maxBackpackWeight = maxBackpackWeight;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    private void setCurrentTime() {
        setTime(new Timestamp(System.currentTimeMillis()));
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Ticket)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!super.equals(obj)) {
            return false;
        }

        final var other = (Ticket) obj;

        return
                super.equals(obj) &&
                this.getConcertHall().equals(other.getConcertHall()) &&
                this.getEventCode().equals(other.getEventCode()) &&
                this.getTime().equals(other.getTime()) &&
                this.getIsPromo() == other.getIsPromo() &&
                this.getStadiumSector().equals(other.getStadiumSector()) &&
                Double.compare(this.getMaxBackpackWeight(), other.getMaxBackpackWeight()) == 0 &&
                Double.compare(this.getPrice(), other.getPrice()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                getConcertHall().hashCode(),
                getEventCode().hashCode(),
                getTime().hashCode(),
                Boolean.hashCode(getIsPromo()),
                getStadiumSector().hashCode(),
                Double.hashCode(getMaxBackpackWeight()),
                Double.hashCode(getPrice())
        );
    }

    @Override
    public String toString() {
        return String.format(
                "Ticket(id = %s, concertHall = %s, eventCode = %s, " +
                        "time = %s, isPromo = %s, stadiumSector = %s, " +
                        "maxBackpackWeight = %.1f, price = %.2f)",
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

    @Override
    public void print() {
        System.out.println(this);
    }
}
