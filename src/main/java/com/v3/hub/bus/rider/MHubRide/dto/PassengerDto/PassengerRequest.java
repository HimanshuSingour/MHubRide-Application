package com.v3.hub.bus.rider.MHubRide.dto.PassengerDto;

import lombok.Data;

@Data
public class PassengerRequest {

    private String passengerId;
    private int busId;
    private String passengerName;
    private String contactNumber;
    private String seatNumber;
    private String ticketNumber;
}
