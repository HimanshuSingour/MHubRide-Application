package com.v3.hub.bus.rider.MHubRide.dto.OwnerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerRequest {

    private String ownerFirstName;
    private String ownerLastName;
    private String ownerAge;
    private String ownerContactNumber;
    private String ownerAddress;
    private String ownerEmail;
    private String ownerCompany;

}
