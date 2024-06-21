package com.andersen.BusTicketValidator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

enum ViolationType {
    None, InvalidTicketType,
    MissingStartDate, FutureStartDate, WrongStartDateFormat,
    PriceIsZero, PriceIsOdd,
}

public class TicketValidator {
    private static final HashSet<String> validTicketTypes = new HashSet<>();
    static {
        validTicketTypes.add("DAY");
        validTicketTypes.add("WEEK");
        validTicketTypes.add("MONTH");
        validTicketTypes.add("YEAR");
    };

    private static String ticketTypeWithoutStartDate = "MONTH";


    public static void main(String[] args) throws JsonProcessingException {
        if (args.length < 1) {
            System.out.println("Please enter the path to a data file as the first cmd argument!");
            return;
        }

        int totalTickets = 0;
        int validTickets = totalTickets;
        final var violationMap = new HashMap<ViolationType, Integer>();

        try {
            String fileName = args[0];
            final var file = new File(fileName);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String data = reader.nextLine();

                BusTicket ticket = new ObjectMapper().readValue(data, BusTicket.class);
                totalTickets += 1;

                final var validationResult = validateTicket(ticket);

                if (validationResult == ViolationType.None) {
                    validTickets += 1;
                } else {
                    violationMap.put(validationResult, violationMap.getOrDefault(validationResult, 0) + 1);
                }
            }

            final var mostPopularViolation = violationMap.entrySet().stream().reduce(
                    (e1, e2) -> e1.getValue() > e2.getValue() ? e1 : e2
            );

            System.out.printf("Total: %d\n", totalTickets);
            System.out.printf("Valid: %d\n", validTickets);
            mostPopularViolation.ifPresent(
                    violationTypeIntegerEntry -> System.out.printf(
                            "Most popular violation: %s\n",
                            violationTypeIntegerEntry.getKey()
                    )
            );
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return;
        }
    }

    private static ViolationType validateTicket(final BusTicket ticket) {
        // validate ticketType
        final var ticketType = ticket.ticketType;
        if (ticketType == null || !validTicketTypes.contains(ticketType)) {
            return ViolationType.InvalidTicketType;
        }

        // validate startDate
        if (!ticketTypeWithoutStartDate.equals(ticketType)) {
            if (ticket.startDate == null) {
                return ViolationType.MissingStartDate;
            }

            try {
                final var parsedStartDate = LocalDate.parse(ticket.startDate);

                if (parsedStartDate.isAfter(LocalDate.now())) {
                    return ViolationType.FutureStartDate;
                }
            } catch (DateTimeParseException e) {
                return ViolationType.WrongStartDateFormat;
            }
        }

        // validate price
        if (ticket.price == 0) {
            return ViolationType.PriceIsZero;
        }

        if ((ticket.price % 2) != 0) {
            return ViolationType.PriceIsOdd;
        }

        return ViolationType.None;
    }
}
