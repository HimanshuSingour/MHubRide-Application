package com.v3.hub.bus.rider.MHubRide.customs;

import com.v3.hub.bus.rider.MHubRide.entity.UserInformation;
import com.v3.hub.bus.rider.MHubRide.repository.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomsUserDetailsServices implements UserDetailsService {

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInformation information = userRepositories.findbyUserName(username);
        if (information == null) {
            throw new UsernameNotFoundException("Not Found Exception");
        }

        return new CustomsUserDetails(information);
    }
}
