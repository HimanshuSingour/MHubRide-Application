package com.v3.hub.bus.rider.MHubRide.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "BUS_INFORMATION")
public class BusInformation {

    @Id
    private int busId;
    private String ownerId;
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


    @ManyToOne
    @JoinColumn(name = "owner_Id_PK")
    @JsonIgnore
    private BusOwnerApp busOwnerApp;

    @OneToOne(mappedBy = "busInformation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private ConductorInformation conductorInformation;

    @OneToOne(mappedBy = "busInformation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private DriverInformation driverInformation;

    @OneToMany(mappedBy = "busInformation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<PassengerInformation> passengerInformation;

}
