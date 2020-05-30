package com.tmassalski.warsawpublictransporttracker.domain.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleCreator {

    private final CreateVehicleClient createVehicleClient;

    void createVehicle(String vehicleType, VehicleLocationCommand vehicleLocationCommand) {
        Vehicle vehicle = Vehicle.generate(vehicleLocationCommand, vehicleType);
        createVehicleClient.save(vehicle);
    }
}
