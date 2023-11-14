package com.v3.hub.bus.rider.MHubRide.repository;

import com.v3.hub.bus.rider.MHubRide.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<UserInformation, Integer> {

    @Query("SELECT u FROM UserInformation u WHERE u.userName = :userName")
    UserInformation findbyUserName(String userName);
}
