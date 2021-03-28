package com.gridnine.testing;

import java.util.List;

public interface FlightFilter {
    List<Flight> flightBeforeCurrentDate(List<Flight> list);
    List<Flight> brokenSegments(List<Flight> list);
    List<Flight> twoHourSegments(List<Flight> list);
}
