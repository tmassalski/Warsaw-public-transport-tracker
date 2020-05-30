package com.tmassalski.warsawpublictransporttracker.domain.vehicle;

import com.tmassalski.warsawpublictransporttracker.api.VehicleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class VehicleFacade {

    private final VehicleCreator vehicleCreator;
    private final VehicleLocationClient vehicleLocationClient;
    private final LocationUpdater locationUpdater;
    private final ClearVehicleRepositoryClient clearVehicleRepositoryClient;

    public void createVehicles(VehicleRequest vehicleRequest) {
        String vehicleType = vehicleRequest.getType();
        clearVehicleRepositoryClient.clear();
        List<VehicleLocationCommand> vehicleLocationCommandList = vehicleLocationClient.getVehicleData(vehicleRequest);
        for (VehicleLocationCommand vehicleLocationCommand : vehicleLocationCommandList) {
            vehicleCreator.createVehicle(vehicleType, vehicleLocationCommand);
        }
    }

    public void updateVehicleLocation(VehicleRequest vehicleRequest) {
        locationUpdater.update(vehicleRequest);
    }
}
