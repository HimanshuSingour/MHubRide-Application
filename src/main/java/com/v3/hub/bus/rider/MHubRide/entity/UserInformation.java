package com.v3.hub.bus.rider.MHubRide.entity;


import com.v3.hub.bus.rider.MHubRide.validations.EmailValidationSuffixType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER_INFO")
@Entity
@Component
@Builder
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String userPassword;

    @EmailValidationSuffixType
    private String userEmail;
    private String userPhoneNumber;
    private String message;


}
