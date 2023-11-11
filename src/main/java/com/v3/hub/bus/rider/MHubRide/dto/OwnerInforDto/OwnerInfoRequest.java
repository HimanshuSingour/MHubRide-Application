package com.v3.hub.bus.rider.MHubRide.dto.OwnerInforDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerInfoRequest {

    private String ownerId;
    private String ownerContactNumber;
    private String ownerEmail;
}
