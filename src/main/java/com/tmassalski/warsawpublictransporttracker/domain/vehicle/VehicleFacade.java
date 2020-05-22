package com.tmassalski.warsawpublictransporttracker.domain.vehicle;

import com.tmassalski.warsawpublictransporttracker.api.VehicleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class VehicleFacade {

    private final VehicleLocationClient vehicleLocationClient;
    private final VehicleCreator vehicleCreator;
    private final ClearVehicleRepositoryClient clearVehicleRepositoryClient;
    private final RetrieveVehicleClient retrieveVehicleClient;

    private VehicleRequest vehicleRequest;

    public void createVehicles(VehicleRequest vehicleRequest) {
        this.vehicleRequest = vehicleRequest;
        clearVehicleRepositoryClient.clear();
        List<VehicleLocationCommand> vehicleLocationCommandList = vehicleLocationClient.getVehicleData(vehicleRequest);
        String vehicleType = vehicleRequest.getType();
        for (VehicleLocationCommand vehicleLocationCommand : vehicleLocationCommandList) {
            vehicleCreator.createVehicle(vehicleType, vehicleLocationCommand);
        }
    }

    public void updateVehicleLocation() {
        if (vehicleRequest != null) {
            List<VehicleLocationCommand> vehicleLocationCommandList = vehicleLocationClient.getVehicleData(vehicleRequest);
            retrieveVehicleClient.getAll()
                    .forEach(vehicle -> vehicle.currentLocation.setLocation(
                            vehicleLocationCommandList.stream()
                                    .filter(vehicleLocationCommand ->
                                            vehicleLocationCommand.getVehicleNumber().equals(vehicle.vehicleNumber))
                                    .findFirst()
                                    .orElseThrow(() -> new RuntimeException("exception"))));
        }
    }
}
