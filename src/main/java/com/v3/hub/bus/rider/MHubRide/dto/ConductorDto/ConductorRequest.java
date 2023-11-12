package com.v3.hub.bus.rider.MHubRide.dto.ConductorDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConductorRequest {

    private String conductorId;
    private String busId;
    private String driverName;
    private String licenseNumber;
    private Date dateOfBirth;
}
