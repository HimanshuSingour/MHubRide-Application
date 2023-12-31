package com.v3.hub.bus.rider.MHubRide.repository;

import com.v3.hub.bus.rider.MHubRide.entity.BusInformation;
import com.v3.hub.bus.rider.MHubRide.entity.PassengerInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusRepositories extends JpaRepository<BusInformation, Integer> {

    List<BusInformation> findByOwnerId(String ownerId);

}
