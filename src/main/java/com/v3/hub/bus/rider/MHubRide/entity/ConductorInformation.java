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
@Table(name = "CONDUCTOR_INFO")
@Entity
public class ConductorInformation {

    @Id
    private String conductorId;
    private int busId;
    private String conductorName;
    private String conductorLicenseNumber;
    private Date conductorDateOfBirth;
    private String conductorNote;

    @OneToOne
    @JoinColumn(name = "bus_FK")
    private BusInformation busInformation;
}
