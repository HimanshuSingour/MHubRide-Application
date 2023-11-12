package com.v3.hub.bus.rider.MHubRide.service;

import com.v3.hub.bus.rider.MHubRide.dto.BusDto.BusRequest;
import com.v3.hub.bus.rider.MHubRide.dto.BusDto.BusResponse;
import com.v3.hub.bus.rider.MHubRide.dto.ConductorDto.ConductorRequest;
import com.v3.hub.bus.rider.MHubRide.dto.ConductorDto.ConductorResponse;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerDto.OwnerRequest;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerDto.OwnerResponse;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerInforDto.OwnerInfoRequest;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerInforDto.OwnerInfoResponse;
import com.v3.hub.bus.rider.MHubRide.entity.BusOwnerApp;
import com.v3.hub.bus.rider.MHubRide.entity.ConductorInformation;
import org.springframework.web.bind.annotation.PathVariable;

public interface BusService {

    OwnerResponse addOwner(OwnerRequest ownerRequest);
    BusResponse saveBus(BusRequest busRequest);
    ConductorResponse saveConductor(ConductorRequest conductorRequest);
    OwnerInfoResponse getOwnerInfo(String ownerId ,String ownerContactNumber ,String ownerEmail);

}
