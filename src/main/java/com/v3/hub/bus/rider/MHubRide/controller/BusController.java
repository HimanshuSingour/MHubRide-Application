package com.v3.hub.bus.rider.MHubRide.controller;

import com.v3.hub.bus.rider.MHubRide.dto.BusDto.BusRequest;
import com.v3.hub.bus.rider.MHubRide.dto.BusDto.BusResponse;
import com.v3.hub.bus.rider.MHubRide.dto.ConductorDto.ConductorRequest;
import com.v3.hub.bus.rider.MHubRide.dto.ConductorDto.ConductorResponse;
import com.v3.hub.bus.rider.MHubRide.dto.DriverDto.DriverRequest;
import com.v3.hub.bus.rider.MHubRide.dto.DriverDto.DriverResponse;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerDto.OwnerRequest;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerDto.OwnerResponse;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerInforDto.OwnerInfoRequest;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerInforDto.OwnerInfoResponse;
import com.v3.hub.bus.rider.MHubRide.dto.PassengerDto.PassengerRequest;
import com.v3.hub.bus.rider.MHubRide.dto.PassengerDto.PassengerResponse;
import com.v3.hub.bus.rider.MHubRide.entity.BusInformation;
import com.v3.hub.bus.rider.MHubRide.entity.BusOwnerApp;
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

    @PostMapping("/add-owner")
    ResponseEntity<OwnerResponse> addOwner(@RequestBody OwnerRequest busInformation) {
        OwnerResponse response = busService.addOwner(busInformation);
        return new ResponseEntity<OwnerResponse>(response, HttpStatus.CREATED);

    }

    @PostMapping("/add-bus")
    ResponseEntity<BusResponse> addBus(@RequestBody BusRequest busRequest) {
        BusResponse response = busService.addBus(busRequest);
        return new ResponseEntity<BusResponse>(response, HttpStatus.CREATED);

    }

    @PostMapping("/add-conductor")
    ResponseEntity<ConductorResponse> addConductor(@RequestBody ConductorRequest conductorRequest) {
        ConductorResponse response = busService.addConductor(conductorRequest);
        return new ResponseEntity<ConductorResponse>(response, HttpStatus.CREATED);

    }

    @PostMapping("/add-driver")
    ResponseEntity<DriverResponse> addDriver(@RequestBody DriverRequest driverRequest) {
        DriverResponse response = busService.addDriver(driverRequest);
        return new ResponseEntity<DriverResponse>(response, HttpStatus.CREATED);

    }

    @PostMapping("/add-passenger")
    ResponseEntity<PassengerResponse> addPassenger(@RequestBody PassengerRequest passengerRequest) {
        PassengerResponse response = busService.addPassenger(passengerRequest);
        return new ResponseEntity<PassengerResponse>(response, HttpStatus.CREATED);

    }

    @GetMapping("/get/info/{ownerId}/{ownerContactNumber}/{ownerEmail}")
    ResponseEntity<OwnerInfoResponse> getOwnerInfo(@PathVariable String ownerId, @PathVariable String ownerContactNumber, @PathVariable String ownerEmail) {
        OwnerInfoResponse response = busService.getOwnerInfo(ownerId, ownerEmail, ownerContactNumber);
        return new ResponseEntity<OwnerInfoResponse>(response, HttpStatus.CREATED);

    }

    @GetMapping("/get/info/{passengerId}")
    ResponseEntity<PassengerResponse> getPassengerInfo(@PathVariable String passengerId) {
        PassengerResponse response = busService.getPassengerInfo(passengerId);
        return new ResponseEntity<PassengerResponse>(response, HttpStatus.CREATED);

    }
}
