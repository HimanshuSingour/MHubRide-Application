package com.v3.hub.bus.rider.MHubRide.dto.PassengerDto;

import com.v3.hub.bus.rider.MHubRide.entity.BusInformation;
import com.v3.hub.bus.rider.MHubRide.entity.ConductorInformation;
import com.v3.hub.bus.rider.MHubRide.entity.DriverInformation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PassengerResponse {

    private String passengerId;
    private int busId;
    private String passengerName;
    private String contactNumber;
    private String notes;

    private BusInformation busInformation;
    private ConductorInformation conductorInformation;
    private DriverInformation driverInformation;
}
