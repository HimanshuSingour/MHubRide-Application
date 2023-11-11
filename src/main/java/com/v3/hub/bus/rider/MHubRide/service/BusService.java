package com.v3.hub.bus.rider.MHubRide.service;

import com.v3.hub.bus.rider.MHubRide.dto.BusResponse;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerResponse;
import com.v3.hub.bus.rider.MHubRide.entity.BusInformation;
import com.v3.hub.bus.rider.MHubRide.entity.BusOwnerApp;

public interface BusService {

    OwnerResponse addOwnerInformation(BusOwnerApp busOwnerApp);
    BusResponse saveBus(BusInformation busInformation);
}
