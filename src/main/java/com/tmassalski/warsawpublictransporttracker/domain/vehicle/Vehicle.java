package com.tmassalski.warsawpublictransporttracker.domain.vehicle;

import com.tmassalski.warsawpublictransporttracker.domain.location.Location;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Vehicle {

    final String vehicleNumber;
    final String lineNumber;
    final VehicleType vehicleType;
    final Location currentLocation;
    final String brigade;

}
