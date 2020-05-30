package com.tmassalski.warsawpublictransporttracker.api;

import com.tmassalski.warsawpublictransporttracker.domain.vehicle.RetrieveVehicleClient;
import com.tmassalski.warsawpublictransporttracker.domain.vehicle.VehicleFacade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("vehicleRequest")
@RequiredArgsConstructor
class VehicleController {

    private final VehicleFacade vehicleFacade;
    private final RetrieveVehicleClient retrieveVehicleClient;

    @ModelAttribute("vehicleRequest")
    public VehicleRequest vehicleRequest() {
        return new VehicleRequest();
    }

    @GetMapping("/vehicle-location")
    public String getVehicleLocation(Model model) {
        model.addAttribute("vehicles", retrieveVehicleClient.getAll());
        return "map";
    }

    @PostMapping("/find-vehicle")
    public String findVehicle(@ModelAttribute("vehicleRequest") VehicleRequest vehicleRequest, RedirectAttributes attributes) {
        attributes.addFlashAttribute("vehicleRequest", vehicleRequest);
        vehicleFacade.createVehicles(vehicleRequest);
        return "redirect:/vehicle-location";
    }

    @GetMapping("/update-location")
    public String updateLocation(ModelMap model) {
        VehicleRequest vehicleRequest = (VehicleRequest) model.getAttribute("vehicleRequest");
        if (vehicleRequest != null && vehicleRequest.type != null) {
            vehicleFacade.updateVehicleLocation(vehicleRequest);
            model.addAttribute("vehicles", retrieveVehicleClient.getAll());
        }
        return "map::#refreshMarkers";
    }
}


