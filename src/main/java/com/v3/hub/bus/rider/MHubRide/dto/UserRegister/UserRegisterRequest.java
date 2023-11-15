package com.v3.hub.bus.rider.MHubRide.dto.UserRegister;

import com.v3.hub.bus.rider.MHubRide.validations.EmailValidationSuffixType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterRequest {

    private String userName;
    private String userPassword;


    private String userEmail;
    private String userPhoneNumber;

}
