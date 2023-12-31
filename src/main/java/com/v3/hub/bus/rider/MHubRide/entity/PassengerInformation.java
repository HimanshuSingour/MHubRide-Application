package com.v3.hub.bus.rider.MHubRide.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PASSENGER_INFO")
@Entity
@Builder
public class PassengerInformation {

    @Id
    private String passengerId;
    private int busId;
    private String passengerName;
    private String contactNumber;
    private String seatNumber;
    private String ticketNumber;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "bus_FK")
    private BusInformation busInformation;

}
