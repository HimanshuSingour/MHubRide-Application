package com.v3.hub.bus.rider.MHubRide.service;

import com.v3.hub.bus.rider.MHubRide.dto.BusResponse;
import com.v3.hub.bus.rider.MHubRide.entity.BusInformation;
import com.v3.hub.bus.rider.MHubRide.exceptions.BusServiceException;
import com.v3.hub.bus.rider.MHubRide.payloads.PayLoadsConfig;
import com.v3.hub.bus.rider.MHubRide.repository.BusRepositories;
import com.v3.hub.bus.rider.MHubRide.repository.ConductorRepositories;
import com.v3.hub.bus.rider.MHubRide.repository.DriverRepositories;
import com.v3.hub.bus.rider.MHubRide.repository.PassengerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static com.v3.hub.bus.rider.MHubRide.constant.BusConstants.*;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepositories busRepositories;

    @Autowired
    private ConductorRepositories conductorRepositories;

    @Autowired
    private PassengerRepositories passengerRepositories;

    @Autowired
    private DriverRepositories driverRepositories;

    private final LocalDateTime localDateTime = LocalDateTime.now();

    @Override
    public BusResponse saveBus(BusInformation busInformation) {

        BusInformation information = null;

        if (busInformation.getRoute().isBlank() || busInformation.getRoute().isEmpty()) {
            throw new BusServiceException(ROUTE_NOT_PROVIDED);

        } else {

            String BusIdGenerator = UUID.randomUUID().toString();
            information = BusInformation.builder()
                    .busId(BusIdGenerator)
                    .busNumber("MP51" + "-" + PayLoadsConfig.generateBusNumber())
                    .modelNumber(PayLoadsConfig.generateBusModelNumber())
                    .butInit(PayLoadsConfig.generateRandomInit())
                    .assignedTo(busInformation.getAssignedTo())
                    .route(busInformation.getRoute())
                    .localDateTime(localDateTime)
                    .fuelCapacity(busInformation.getFuelCapacity())
                    .insuranceExpiryDate(busInformation.getInsuranceExpiryDate())
                    .maintenanceWeek(String.valueOf(LocalDateTime.now()))
                    .mileage(busInformation.getMileage())
                    .numberOfSeats(80)
                    .manufacturer(PayLoadsConfig.generateRandomBusCompanyName())
                    .lastMaintenanceDate(String.valueOf(LocalDate.now()))
                    .build();

            busRepositories.save(information);

        }

        return BusResponse.builder()
                .busNumber(information.getBusNumber())
                .butInit(information.getButInit())
                .busId(information.getBusId())
                .route(information.getRoute())
                .localDateTime(information.getLocalDateTime())
                .message(BUS_ADDED_SUCCESSFULLY)
                .build();
    }
}
