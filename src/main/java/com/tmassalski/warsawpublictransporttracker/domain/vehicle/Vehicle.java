package com.tmassalski.warsawpublictransporttracker.domain.vehicle;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
@Getter
public class Vehicle {

    final String vehicleNumber;
    final String lineNumber;
    final VehicleType vehicleType;
    final Location currentLocation;
    final String brigade;

    void setLocation(VehicleLocationCommand vehicleLocationCommand) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.currentLocation.latitude = vehicleLocationCommand.getLat();
        this.currentLocation.longitude = vehicleLocationCommand.getLon();
        this.currentLocation.timestamp = LocalDateTime.parse(vehicleLocationCommand.getTime(), formatter);
    }

    static Vehicle generate(VehicleLocationCommand vehicleLocationCommand, String vehicleType) {
        return Vehicle.builder()
                .vehicleNumber(vehicleLocationCommand.getVehicleNumber())
                .lineNumber(vehicleLocationCommand.getLineNumber())
                .vehicleType(VehicleType.getType(Integer.parseInt(vehicleType)))
                .currentLocation(Location.build(vehicleLocationCommand))
                .brigade(vehicleLocationCommand.getBrigade())
                .build();
    }
}
