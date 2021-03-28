package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightHandler implements FlightFilter{

    public List<Flight> flightBeforeCurrentDate(List<Flight> list) {
        List<Flight> fList = list.stream().filter((a) -> a.getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now())).collect(Collectors.toList());
        return fList;
    }

    public List<Flight> brokenSegments(List<Flight> list) {
        List<Flight> fList = list.stream().filter((a) -> {
            for(int i = 0; i < a.getSegments().size(); i++)
            {
                if(a.getSegments().get(i).getDepartureDate().isAfter(a.getSegments().get(i).getArrivalDate()))
                    return true;
            }
            return false;
        }).collect(Collectors.toList());
        return fList;
    }

    public List<Flight> twoHourSegments(List<Flight> list) {
        List<Flight> fList = list.stream().filter((a) ->{
            long period = 0;
            for (int i = 0; i < a.getSegments().size()-1;i++)
            {
                period += Duration.between(a.getSegments().get(i).getArrivalDate().toLocalTime(),a.getSegments().get(i+1).getDepartureDate().toLocalTime() ).getSeconds();
            }
            if (period/3600 > 2) return true;
            return false;
        }).collect(Collectors.toList());
        return fList;
    }
}
