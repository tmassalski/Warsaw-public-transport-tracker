package com.tmassalski.warsawpublictransporttracker.domain.vehicle;

import com.tmassalski.warsawpublictransporttracker.domain.location.LocationCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleCreator {

    private final LocationCreator locationCreator;
    private final CreateVehicleClient createVehicleClient;

    void createVehicle(String vehicleType, VehicleLocationCommand vehicleLocationCommand) {
        Vehicle vehicle = generate(vehicleLocationCommand, vehicleType);
        createVehicleClient.save(vehicle);
    }

    Vehicle generate(VehicleLocationCommand vehicleLocationCommand, String vehicleType) {
        return Vehicle.builder()
                .vehicleNumber(vehicleLocationCommand.getVehicleNumber())
                .lineNumber(vehicleLocationCommand.getLineNumber())
                .vehicleType(VehicleType.getType(Integer.parseInt(vehicleType)))
                .currentLocation(locationCreator.build(vehicleLocationCommand))
                .brigade(vehicleLocationCommand.getBrigade())
                .build();
    }
}
