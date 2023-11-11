package com.v3.hub.bus.rider.MHubRide.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BUS_OWNER_INFO")
@Entity
@Builder
public class BusOwnerApp {

    @Id
    private String ownerId;
    private String ownerName;
    private String contactNumber;
    private String busLicenseNumber;
    private String address;
    private String email;
    private String company;
    private String registrationDate;
    private String insuranceNumber;
    private String busModel;
    private int numberOfBuses;

    @OneToMany(mappedBy = "busOwnerApp" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JsonIgnore
    private List<BusInformation> busInformation;
}
