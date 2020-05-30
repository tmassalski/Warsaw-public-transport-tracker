package com.tmassalski.warsawpublictransporttracker.domain.vehicle;

import com.tmassalski.warsawpublictransporttracker.api.VehicleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
class LocationUpdater {

    private final VehicleLocationClient vehicleLocationClient;
    private final RetrieveVehicleClient retrieveVehicleClient;

    void update(VehicleRequest vehicleRequest) {
        List<VehicleLocationCommand> vehicleLocationCommandList = vehicleLocationClient.getVehicleData(vehicleRequest);
        retrieveVehicleClient.getAll()
                .forEach(vehicle -> vehicle.setLocation(
                        vehicleLocationCommandList.stream()
                                .filter(vehicleLocationCommand ->
                                        vehicleLocationCommand
                                                .getVehicleNumber()
                                                .equals(vehicle.vehicleNumber))
                                .findFirst()
                                .orElseThrow(() -> new RuntimeException("exception"))));
    }
}
