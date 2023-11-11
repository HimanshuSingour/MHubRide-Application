package com.v3.hub.bus.rider.MHubRide.repository;

import com.v3.hub.bus.rider.MHubRide.entity.BusOwnerApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusOwnerRepositories extends JpaRepository<BusOwnerApp , String> {

    boolean existsByOwnerEmail(String ownerEmail);

    boolean existsByOwnerContactNumber(String ownerContactNumber);
}
