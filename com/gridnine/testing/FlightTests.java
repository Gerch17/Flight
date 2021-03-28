package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class FlightTests {
    @Test
    public void flightBeforeCurrentDayTest(){
        FlightHandler flightHandler = new FlightHandler();
        List<Flight> actList = flightHandler.flightBeforeCurrentDate(FlightBuilder.createFlights());
        Assert.assertEquals(FlightBuilder.createFlights().get(2).toString(), actList.get(0).toString());
    }

    @Test
    public void brokenSegmentsTest(){
        FlightHandler flightHandler = new FlightHandler();
        List<Flight> actList = flightHandler.brokenSegments(FlightBuilder.createFlights());
        Assert.assertEquals(FlightBuilder.createFlights().get(3).toString(), actList.get(0).toString());
    }

    @Test
    public void twoHourSegmentsTest(){
        FlightHandler flightHandler = new FlightHandler();
        List<Flight> actList = flightHandler.twoHourSegments(FlightBuilder.createFlights());
        List<Flight> exList = new ArrayList<>();
        exList.add(FlightBuilder.createFlights().get(4));
        exList.add(FlightBuilder.createFlights().get(5));
        Assert.assertEquals(exList.toString(), actList.toString());
    }
}
