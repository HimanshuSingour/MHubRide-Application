package com.v3.hub.bus.rider.MHubRide.repository;

import com.v3.hub.bus.rider.MHubRide.entity.BusInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepositories extends JpaRepository<BusInformation, Integer> {

    List<BusInformation> findByOwnerId(String ownerId);
}
