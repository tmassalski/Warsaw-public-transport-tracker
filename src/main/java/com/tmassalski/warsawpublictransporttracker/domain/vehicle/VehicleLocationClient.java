package com.tmassalski.warsawpublictransporttracker.domain.vehicle;

import com.tmassalski.warsawpublictransporttracker.api.VehicleRequest;

import java.util.List;

public interface VehicleLocationClient {

    List<VehicleLocationCommand> getVehicleData(VehicleRequest vehicleRequest);
}
