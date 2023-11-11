package com.v3.hub.bus.rider.MHubRide.dto.OwnerDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OwnerResponse {

    private String ownerId;
    private String ownerName;
    private String ownerContactNumber;
    private String ownerAddress;
    private String ownerEmail;
    private String ownerAge;
    private String ownerCompany;
    private String ownerRegistrationDate;
    private String ownerTodayDate;
    private String ownerInsuranceNumber;
    private String insuranceImportantMesMessage;
    private String note;
}
