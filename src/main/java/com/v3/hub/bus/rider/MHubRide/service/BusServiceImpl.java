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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

        String busIdGenerator = UUID.randomUUID().toString();

        LocalDateTime currentDateTime = LocalDate.now().atStartOfDay();
        LocalDateTime maintenanceDate = currentDateTime.plusDays(60); // M

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formattedDate = currentDate.format(formatter);
        BusInformation information = null;

        if (busInformation.getRoute().isBlank() || busInformation.getRoute().isEmpty()) {
            throw new BusServiceException(ROUTE_NOT_PROVIDED);

        } else {
            information = BusInformation.builder()
                    .busId(busIdGenerator)
                    .busNumber("MP51" + "-" + PayLoadsConfig.generateBusNumber())
                    .modelNumber(PayLoadsConfig.generateBusModelNumber())
                    .butInit(PayLoadsConfig.generateRandomInit())
                    .route(busInformation.getRoute())
                    .busAddedDate(formattedDate)
                    .fuelCapacity(busInformation.getFuelCapacity())
                    .maintenanceToday(String.valueOf(formatter))
                    .mileage(busInformation.getMileage())
                    .numberOfSeats(80)
                    .busAddedTime(String.valueOf(LocalTime.now()))
                    .manufacturer(PayLoadsConfig.generateRandomBusCompanyName())
                    .build(); busRepositories.save(information);
        }
        return BusResponse.builder()
                .busNumber(information.getBusNumber())
                .butInit(information.getButInit())
                .busId(information.getBusId())
                .route(information.getRoute())
                .maintenanceToday(String.valueOf(currentDateTime))
                .todayDate(formattedDate)
                .localTime(LocalTime.parse(String.valueOf(LocalTime.now())))
                .message(BUS_ADDED_SUCCESSFULLY)
                .comingMaintenanceDay(UPCOMING_MAINTENANCE_DAY + " - " + String.valueOf(maintenanceDate))
                .build();
    }
}


