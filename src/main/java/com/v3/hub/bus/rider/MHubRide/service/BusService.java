package com.v3.hub.bus.rider.MHubRide.service;

import com.v3.hub.bus.rider.MHubRide.dto.BusResponse;
import com.v3.hub.bus.rider.MHubRide.entity.BusInformation;

public interface BusService {

    BusResponse saveBus(BusInformation busInformation);
}
