package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {
        FlightHandler flightHandler = new FlightHandler();
        //System.out.println("Вылеты до текущего момента времени:");
        System.out.println(flightHandler.flightBeforeCurrentDate(FlightBuilder.createFlights()).toString());
        //System.out.println("\nИмеются сегменты с датой прилёта раньше даты вылета:");
        System.out.println(flightHandler.brokenSegments(FlightBuilder.createFlights()).toString());
        //System.out.println("\nОбщее время, проведённое на земле превышает два часа:");
        System.out.println(flightHandler.twoHourSegments(FlightBuilder.createFlights()).toString());
    }
}
