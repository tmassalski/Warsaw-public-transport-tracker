package com.tmassalski.warsawpublictransporttracker.infrastructure.vehicle;

import com.tmassalski.warsawpublictransporttracker.api.VehicleRequest;
import com.tmassalski.warsawpublictransporttracker.domain.vehicle.Result;
import com.tmassalski.warsawpublictransporttracker.domain.vehicle.VehicleLocationClient;
import com.tmassalski.warsawpublictransporttracker.domain.vehicle.VehicleLocationCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class VehicleDataRestClient implements VehicleLocationClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final String apiKey;
    private final String resourceId;

    @Autowired
    public VehicleDataRestClient(RestTemplate restTemplate,
                                 @Value("${get.vehicle.location.base.url}") String baseUrl,
                                 @Value("${vehicle.location.api.key}") String apiKey,
                                 @Value("${get.vehicle.location.resource.id}") String resourceId) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.resourceId = resourceId;
    }

    @Override
    public List<VehicleLocationCommand> getVehicleData(VehicleRequest vehicleRequest) {
        String url = buildUrl(vehicleRequest);
        Result result = restTemplate.getForObject(url, Result.class);
        assert result != null;
        return result.getResult();
    }

    String buildUrl(VehicleRequest vehicleRequest) {
        String type = vehicleRequest.getType();
        String line = vehicleRequest.getLine();
        String brigade = vehicleRequest.getBrigade();
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .queryParam("resource_id", resourceId)
                .queryParam("apikey", apiKey)
                .queryParam("type", type);
        if (!line.isEmpty()) {
            builder.queryParam("line", line);
        }
        if (!brigade.isEmpty()) {
            builder.queryParam("brigade", brigade);
        }
        return builder.build().toString();
    }
}
