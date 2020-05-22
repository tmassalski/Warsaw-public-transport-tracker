package com.tmassalski.warsawpublictransporttracker.infrastructure.vehicle;

import com.tmassalski.warsawpublictransporttracker.domain.vehicle.ClearVehicleRepositoryClient;
import com.tmassalski.warsawpublictransporttracker.domain.vehicle.CreateVehicleClient;
import com.tmassalski.warsawpublictransporttracker.domain.vehicle.RetrieveVehicleClient;
import com.tmassalski.warsawpublictransporttracker.domain.vehicle.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class VehicleRepository implements CreateVehicleClient, ClearVehicleRepositoryClient, RetrieveVehicleClient {

    private Set<Vehicle> vehicles = new HashSet<>();

    @Override
    public void save(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public void clear() {
        vehicles.clear();
    }

    @Override
    public Set<Vehicle> getAll() {
        return vehicles;
    }
}
