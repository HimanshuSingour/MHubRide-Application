package com.v3.hub.bus.rider.MHubRide.service;

import com.v3.hub.bus.rider.MHubRide.dto.BusDto.BusResponse;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerDto.OwnerRequest;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerDto.OwnerResponse;
import com.v3.hub.bus.rider.MHubRide.entity.BusInformation;
import com.v3.hub.bus.rider.MHubRide.entity.BusOwnerApp;

public interface BusService {

    OwnerResponse addOwnerInformation(OwnerRequest ownerRequest);
    BusResponse saveBus(BusInformation busInformation);
}
