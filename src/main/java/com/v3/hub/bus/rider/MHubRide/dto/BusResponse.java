package com.v3.hub.bus.rider.MHubRide.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BusResponse {

    private String busId;
    private String butInit;
    private String busNumber;
    private String route;
    private LocalDateTime localDateTime;
    private String message;
}
