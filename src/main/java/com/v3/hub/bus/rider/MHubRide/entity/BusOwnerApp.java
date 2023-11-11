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
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerAge;
    private String ownerContactNumber;
    private String ownerAddress;
    private String ownerTodayDate;
    private String ownerEmail;
    private String ownerCompany;
    private String ownerRegistrationDate;
    private String ownerInsuranceNumber;
    private String insuranceImportantMesMessage;
    private String note;;

    @OneToMany(mappedBy = "busOwnerApp" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<BusInformation> busInformation;
}
