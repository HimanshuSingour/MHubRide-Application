package com.v3.hub.bus.rider.MHubRide.service.SecurityService;

import com.v3.hub.bus.rider.MHubRide.dto.UserRegister.UserRegisterRequest;
import com.v3.hub.bus.rider.MHubRide.dto.UserRegister.UserRegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoSecurityService {

    UserRegisterResponse registerUser(UserRegisterRequest userRegisterRequest);

}
