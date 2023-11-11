package com.v3.hub.bus.rider.MHubRide.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
public class BusResponse {

    private String busId;
    private String butInit;
    private String busNumber;
    private String maintenanceToday;
    private String comingMaintenanceDay;
    private String route;
    private String todayDate;
    private LocalTime localTime;
    private String message;
    private String manufacturer;
    private String statusOwner;
}
