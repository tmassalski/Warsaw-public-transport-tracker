package com.tmassalski.warsawpublictransporttracker.domain.vehicle;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum VehicleType {
    BUS(1), TRAM(2);

    int id;

   static VehicleType getType(int id){
        if (id == 1) {
            return BUS;
        } else {
            return TRAM;
        }
    }
}
