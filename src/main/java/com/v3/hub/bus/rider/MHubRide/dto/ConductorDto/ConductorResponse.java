package com.v3.hub.bus.rider.MHubRide.dto.ConductorDto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ConductorResponse {

    private String conductorId;
    private String busId;
    private String driverName;
    private String licenseNumber;
    private Date dateOfBirth;
    private String note;
    private String status;
}
