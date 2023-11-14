package com.v3.hub.bus.rider.MHubRide.dto.UserRegister;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterResponse {

    private String userName;
    private String userEmail;
    private String userPhoneNumber;
    private String message;
}
