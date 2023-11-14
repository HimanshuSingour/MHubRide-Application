package com.v3.hub.bus.rider.MHubRide.security;

import com.v3.hub.bus.rider.MHubRide.entity.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomsUserDetails implements UserDetails {

    private UserInformation information;

    public CustomsUserDetails(UserInformation information) {
        super();
        this.information = information;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return information.getUserPassword();
    }

    @Override
    public String getUsername() {
        return information.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
