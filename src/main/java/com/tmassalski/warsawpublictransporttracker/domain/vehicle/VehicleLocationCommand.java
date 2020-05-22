package com.tmassalski.warsawpublictransporttracker.domain.vehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class VehicleLocationCommand {

    @JsonProperty("Lines")
    private String lineNumber;
    @JsonProperty("Lon")
    private Double lon;
    @JsonProperty("VehicleNumber")
    private String vehicleNumber;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("Lat")
    private Double lat;
    @JsonProperty("Brigade")
    private String brigade;
}
