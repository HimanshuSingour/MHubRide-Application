package com.v3.hub.bus.rider.MHubRide.service;

import com.v3.hub.bus.rider.MHubRide.dto.BusDto.BusRequest;
import com.v3.hub.bus.rider.MHubRide.dto.BusDto.BusResponse;
import com.v3.hub.bus.rider.MHubRide.dto.CancelResponse;
import com.v3.hub.bus.rider.MHubRide.dto.ConductorDto.ConductorRequest;
import com.v3.hub.bus.rider.MHubRide.dto.ConductorDto.ConductorResponse;
import com.v3.hub.bus.rider.MHubRide.dto.DriverDto.DriverRequest;
import com.v3.hub.bus.rider.MHubRide.dto.DriverDto.DriverResponse;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerDto.OwnerRequest;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerDto.OwnerResponse;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerInforDto.OwnerInfoResponse;
import com.v3.hub.bus.rider.MHubRide.dto.PassengerDto.PassengerRequest;
import com.v3.hub.bus.rider.MHubRide.dto.PassengerDto.PassengerResponse;


public interface BusService {

    // TODO ADD DATA
    OwnerResponse addOwner(OwnerRequest ownerRequest);
    BusResponse addBus(BusRequest busRequest);
    ConductorResponse addConductor(ConductorRequest conductorRequest);
    DriverResponse addDriver(DriverRequest driverRequest);

    // TODO GET DATA
    OwnerInfoResponse getOwnerInfo(String ownerId ,String ownerContactNumber ,String ownerEmail);
    PassengerResponse getPassengerInfo(String passengerId);
    PassengerResponse getPassengerInfoByTicketNumberAndSeatNumber(String ticketNumber , String seatNumber);
    DriverResponse getDriverInfo(String licenseNumber, String driverRegistrationNumber);
    ConductorResponse getConductorInfo(String licenseNumber,  String conductorId);
    PassengerResponse checkSeatDetails(String seatNumber);
    BusResponse getBusInfo(String busInit, String busNumber);


    // TODO: PERFORMED SOME USER TASK
    PassengerResponse bookASeat(PassengerRequest passengerRequest);
    CancelResponse cancelASeat(String ticketNumber , String seatNumber , String passengerId);












}
