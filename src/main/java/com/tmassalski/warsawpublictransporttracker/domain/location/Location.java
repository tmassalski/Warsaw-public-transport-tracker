package com.tmassalski.warsawpublictransporttracker.domain.location;

import com.tmassalski.warsawpublictransporttracker.domain.vehicle.VehicleLocationCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Location {
    Double latitude;
    Double longitude;
    LocalDateTime timestamp;

    public void setLocation(VehicleLocationCommand vehicleLocationCommand) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.latitude = vehicleLocationCommand.getLat();
        this.longitude = vehicleLocationCommand.getLon();
        this.timestamp = LocalDateTime.parse(vehicleLocationCommand.getTime(), formatter);
    }
}
