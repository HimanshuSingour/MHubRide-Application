package com.v3.hub.bus.rider.MHubRide.dto.BusDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusRequest {

    private String ownerId;
    private int busId;
    private String busInit;
    private String busNumber;
    private String modelNumber;
    private int numberOfSeats;
    private String route;
    private double fuelCapacity;
    private double mileage;
    private String maintenanceToday;
    private String manufacturer;
    private String busAddedDate;
    private String busAddedTime;
}
