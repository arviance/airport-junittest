package com.dalircode.tddjunit.modifiedtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AirportTest {

    private Flight economyFlight;
    private Flight businessFlight;

    @BeforeEach
    void setUp() {
        economyFlight = new EconomyFlight("1");
        businessFlight = new BusinessFlight("2");
    }

    @Test
    void testEconomyFlightUsualPassenger() {
        Passenger mike = new Passenger("Mike", false);

        assertEquals("1", economyFlight.getId());
        assertEquals(true, economyFlight.addPassenger(mike));
        assertEquals(1, economyFlight.getPassengersList().size());
        assertEquals("Mike", economyFlight.getPassengersList().get(0).getName());

        assertEquals(true, economyFlight.removePassenger(mike));
        assertEquals(0, economyFlight.getPassengersList().size());
    }

    @Test
    void testEconomyFlightVipPassenger() {
        Passenger john = new Passenger("John", true);

        assertEquals("1", economyFlight.getId());
        assertEquals(true, economyFlight.addPassenger(john));
        assertEquals(1, economyFlight.getPassengersList().size());
        assertEquals("John", economyFlight.getPassengersList().get(0).getName());

        assertEquals(false, economyFlight.removePassenger(john));
        assertEquals(1, economyFlight.getPassengersList().size());
    }

    @Test
    void testBusinessFlightUsualPassenger() {
        Passenger mike = new Passenger("Mike", false);

        assertEquals(false, businessFlight.addPassenger(mike));
        assertEquals(0, businessFlight.getPassengersList().size());
        assertEquals(false, businessFlight.removePassenger(mike));
        assertEquals(0, businessFlight.getPassengersList().size());
    }

    @Test
    void testBusinessFlightVipPassenger() {
        Passenger john = new Passenger("John", true);

        assertEquals(true, businessFlight.addPassenger(john));
        assertEquals(1, businessFlight.getPassengersList().size());
        assertEquals(false, businessFlight.removePassenger(john));
        assertEquals(1, businessFlight.getPassengersList().size());
    }
}