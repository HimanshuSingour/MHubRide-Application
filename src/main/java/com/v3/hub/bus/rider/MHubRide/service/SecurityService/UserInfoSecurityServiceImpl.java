package com.v3.hub.bus.rider.MHubRide.service.SecurityService;

import com.v3.hub.bus.rider.MHubRide.dto.UserRegister.UserRegisterRequest;
import com.v3.hub.bus.rider.MHubRide.dto.UserRegister.UserRegisterResponse;
import com.v3.hub.bus.rider.MHubRide.entity.UserInformation;
import com.v3.hub.bus.rider.MHubRide.exceptions.AllFieldsRequired;
import com.v3.hub.bus.rider.MHubRide.repository.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.v3.hub.bus.rider.MHubRide.constant.BusConstants.ALL_FIELDS_ARE_REQUIRED;

@Service
public class UserInfoSecurityServiceImpl implements UserInfoSecurityService {
    @Autowired
    private UserRepositories userRepositories;

    @Override
    public UserRegisterResponse registerUser(UserRegisterRequest userRegisterRequest) {

        if (userRegisterRequest.getUserEmail().isBlank() || userRegisterRequest.getUserPhoneNumber().isBlank() || userRegisterRequest.getUserPassword().isBlank()) {
            throw new AllFieldsRequired(ALL_FIELDS_ARE_REQUIRED);
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String BycrpPasswords = userRegisterRequest.getUserPassword();

        String hashedPassword = passwordEncoder.encode(BycrpPasswords);


        UserInformation request = UserInformation.builder()
                .userEmail(userRegisterRequest.getUserEmail())
                .userName(userRegisterRequest.getUserName())
                .userPassword(hashedPassword)
                .userPhoneNumber(userRegisterRequest.getUserPhoneNumber())
                .message("Register Successfully")
                .build();

        userRepositories.save(request);

        return UserRegisterResponse.builder()
                .userPhoneNumber(request.getUserPhoneNumber())
                .message(request.getMessage())
                .userEmail(request.getUserEmail())
                .userName(request.getUserName())
                .build();

    }
}
