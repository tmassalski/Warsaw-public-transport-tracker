package com.tmassalski.warsawpublictransporttracker.api;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleRequest {
    String type;
    String line;
    String brigade;
}
