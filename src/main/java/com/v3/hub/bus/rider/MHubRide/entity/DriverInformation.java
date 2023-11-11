package com.v3.hub.bus.rider.MHubRide.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DRIVER_INFO")
public class DriverInformation {

    @Id
    private String driverId;
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

    @OneToOne
    @JoinColumn(name = "bus_FK")
    private BusInformation busInformation;
}
