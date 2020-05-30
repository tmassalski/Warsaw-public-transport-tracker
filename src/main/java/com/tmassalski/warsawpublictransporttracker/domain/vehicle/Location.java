package com.tmassalski.warsawpublictransporttracker.domain.vehicle;

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
class Location {
    Double latitude;
    Double longitude;
    LocalDateTime timestamp;

    static Location build(VehicleLocationCommand vehicleLocationCommand) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Location.builder()
                .latitude(vehicleLocationCommand.getLat())
                .longitude(vehicleLocationCommand.getLon())
                .timestamp(LocalDateTime.parse(vehicleLocationCommand.getTime(), formatter))
                .build();
    }
}
