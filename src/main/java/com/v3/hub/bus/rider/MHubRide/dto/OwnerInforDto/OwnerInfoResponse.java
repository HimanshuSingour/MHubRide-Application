package com.v3.hub.bus.rider.MHubRide.dto.OwnerInforDto;

import com.v3.hub.bus.rider.MHubRide.entity.BusInformation;
import com.v3.hub.bus.rider.MHubRide.entity.ConductorInformation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OwnerInfoResponse {

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
    private String numberOfBuses;
    private String note;;

    private List<BusInformation> busInformation;

    private ConductorInformation conductorInformation;
}
