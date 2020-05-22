package com.tmassalski.warsawpublictransporttracker.api;

import com.tmassalski.warsawpublictransporttracker.domain.vehicle.RetrieveVehicleClient;
import com.tmassalski.warsawpublictransporttracker.domain.vehicle.VehicleFacade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
class VehicleController {

    private final VehicleFacade vehicleFacade;
    private final RetrieveVehicleClient retrieveVehicleClient;

    @GetMapping("/vehicle-location")
    public String getVehicleLocation(Model model) {
        model.addAttribute("vehicles", retrieveVehicleClient.getAll());
        model.addAttribute("vehicleRequest", new VehicleRequest());
        return "map";
    }

    @PostMapping("/find-vehicle")
    public String findVehicle (@ModelAttribute VehicleRequest vehicleRequest) {
        vehicleFacade.createVehicles(vehicleRequest);
        return "redirect:/vehicle-location";
    }

    @GetMapping("/update-location")
    public String updateLocation(ModelMap model) {
        vehicleFacade.updateVehicleLocation();
        model.addAttribute("vehicles", retrieveVehicleClient.getAll());
        return "map::#refreshMarkers";
    }
}


