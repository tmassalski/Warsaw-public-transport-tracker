package com.tmassalski.warsawpublictransporttracker.domain.location;

import com.tmassalski.warsawpublictransporttracker.domain.vehicle.VehicleLocationCommand;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LocationCreator {

    public Location build(VehicleLocationCommand vehicleLocationCommand) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Location.builder()
                .latitude(vehicleLocationCommand.getLat())
                .longitude(vehicleLocationCommand.getLon())
                .timestamp(LocalDateTime.parse(vehicleLocationCommand.getTime(), formatter))
                .build();
    }
}
