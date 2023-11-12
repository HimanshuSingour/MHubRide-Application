package com.v3.hub.bus.rider.MHubRide.dto.DriverDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverResponse {

    private String driverId;
    private String busId;
    private String driverName;
    private String licenseNumber;
    private Date dateOfBirth;
    private String contactNumber;
    private String address;
    private String registrationNumber;
    private String insurancePolicyNumber;
    private String emergencyContactName;
    private String emergencyContactNumber;
    private String bloodType;
    private String specialSkills;
    private String notes;
    private String status;
}
