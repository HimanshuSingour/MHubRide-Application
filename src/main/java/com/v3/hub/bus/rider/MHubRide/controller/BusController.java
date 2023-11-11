package com.v3.hub.bus.rider.MHubRide.controller;

import com.v3.hub.bus.rider.MHubRide.dto.BusResponse;
import com.v3.hub.bus.rider.MHubRide.entity.BusInformation;
import com.v3.hub.bus.rider.MHubRide.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus/v3/hub")
public class BusController {

    @Autowired
    private BusService busService;


    @PostMapping("/add-bus")
    ResponseEntity<BusResponse> addBus(@RequestBody BusInformation busInformation){
        BusResponse response = busService.saveBus(busInformation);
        return new ResponseEntity<BusResponse>(response , HttpStatus.CREATED);

    }
}
