package com.v3.hub.bus.rider.MHubRide.repository;

import com.v3.hub.bus.rider.MHubRide.entity.ConductorInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepositories extends JpaRepository<ConductorInformation , String> {
}
