package com.tmassalski.warsawpublictransporttracker.domain.vehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "result"
})
public class Result {

    @JsonProperty("result")
    private List<VehicleLocationCommand> VehicleLocationCommand = null;

    @JsonProperty("result")
    public List<VehicleLocationCommand> getResult() {
        return VehicleLocationCommand;
    }
}
