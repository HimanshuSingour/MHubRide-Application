package com.v3.hub.bus.rider.MHubRide.service;

import com.v3.hub.bus.rider.MHubRide.dto.BusDto.BusRequest;
import com.v3.hub.bus.rider.MHubRide.dto.BusDto.BusResponse;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerDto.OwnerRequest;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerDto.OwnerResponse;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerInforDto.OwnerInfoRequest;
import com.v3.hub.bus.rider.MHubRide.dto.OwnerInforDto.OwnerInfoResponse;
import com.v3.hub.bus.rider.MHubRide.entity.BusInformation;
import com.v3.hub.bus.rider.MHubRide.entity.BusOwnerApp;
import com.v3.hub.bus.rider.MHubRide.exceptions.BusServiceException;
import com.v3.hub.bus.rider.MHubRide.payloads.PayLoadsConfig;
import com.v3.hub.bus.rider.MHubRide.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
    @Autowired
    private BusOwnerRepositories busOwnerRepositories;


    @Override
    public OwnerResponse addOwnerInformation(OwnerRequest ownerRequest) {

        if (ownerRequest.getOwnerFirstName().isBlank()
                || ownerRequest.getOwnerLastName().isBlank()
                || ownerRequest.getOwnerEmail().isBlank()
                || ownerRequest.getOwnerContactNumber().isBlank()
                || ownerRequest.getOwnerAddress().isBlank()
                || ownerRequest.getOwnerCompany().isBlank()
                || ownerRequest.getOwnerAge().isBlank()) {

            throw new BusServiceException(ALL_FIELDS_ARE_REQUIRED);
        }
        if (ownerRequest.getOwnerFirstName().length() < 4 || ownerRequest.getOwnerFirstName().length() > 20) {
            throw new BusServiceException(FIRST_NAME_LENGTH);
        } else if (ownerRequest.getOwnerLastName().length() < 4 || ownerRequest.getOwnerLastName().length() > 20) {
            throw new BusServiceException(LAST_NAME_LENGTH);
        } else if (busOwnerRepositories.existsByOwnerEmail(ownerRequest.getOwnerEmail())) {
            throw new BusServiceException(OWNER_EMAIL_EXIST);
        } else if (busOwnerRepositories.existsByOwnerContactNumber(ownerRequest.getOwnerContactNumber())) {
            throw new BusServiceException(OWNER_PHONE_EXIST);
        }


        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formattedDate = currentDate.format(formatter);

        BusOwnerApp busOwnerApp = BusOwnerApp.builder()
                .ownerId(UUID.randomUUID().toString())
                .ownerAddress(ownerRequest.getOwnerAddress())
                .ownerAge(ownerRequest.getOwnerAge())
                .ownerCompany(ownerRequest.getOwnerCompany())
                .ownerEmail(ownerRequest.getOwnerEmail())
                .ownerContactNumber(ownerRequest.getOwnerContactNumber())
                .ownerInsuranceNumber(PayLoadsConfig.generateBusInsuranceNumber())
                .ownerTodayDate(formattedDate)
                .ownerFirstName(ownerRequest.getOwnerFirstName())
                .ownerLastName(ownerRequest.getOwnerLastName())
                .ownerRegistrationDate(formattedDate)
                .insuranceImportantMesMessage(ALERT_MESSAGE)
                .note(OWNER_ADDED_SUCCESSFULLY)
                .numberOfBuses(String.valueOf(4))
                .build();
        busOwnerRepositories.save(busOwnerApp);

        return OwnerResponse.builder()
                .ownerId(busOwnerApp.getOwnerId())
                .ownerCompany(busOwnerApp.getOwnerCompany())
                .ownerEmail(busOwnerApp.getOwnerEmail())
                .ownerRegistrationDate(busOwnerApp.getOwnerRegistrationDate())
                .note(busOwnerApp.getNote())
                .ownerInsuranceNumber(busOwnerApp.getOwnerInsuranceNumber())
                .ownerAddress(busOwnerApp.getOwnerAddress())
                .insuranceImportantMesMessage(busOwnerApp.getInsuranceImportantMesMessage())
                .ownerTodayDate(busOwnerApp.getOwnerTodayDate())
                .ownerContactNumber(busOwnerApp.getOwnerContactNumber())
                .ownerAge(busOwnerApp.getOwnerAge())
                .ownerNumberOfBuses(busOwnerApp.getNumberOfBuses())
                .ownerName(busOwnerApp.getOwnerFirstName() + " " + busOwnerApp.getOwnerLastName())
                .build();
    }

    @Override
    public BusResponse saveBus(BusRequest busRequest) {

        LocalDateTime currentDateTime = LocalDate.now().atStartOfDay();
        LocalDateTime maintenanceDate = currentDateTime.plusDays(60);

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formattedDate = currentDate.format(formatter);

        if (busRequest.getRoute().isBlank() || busRequest.getRoute().isEmpty()) {
            throw new BusServiceException(ROUTE_NOT_PROVIDED);
        }

        BusInformation information = null;

        Optional<BusOwnerApp> busOwnerApp = busOwnerRepositories.findById(busRequest.getOwnerId());
        if (busOwnerApp.isPresent()) {
            Optional<BusInformation> busInformation = busRepositories.findById(busRequest.getBusId());
            if (busInformation.isEmpty()) {
                information = BusInformation.builder()
                        .busNumber("MP51" + "-" + PayLoadsConfig.generateBusNumber())
                        .busId(busRequest.getBusId())
                        .modelNumber(PayLoadsConfig.generateBusModelNumber())
                        .busInit(PayLoadsConfig.generateRandomInit())
                        .route(busRequest.getRoute())
                        .busAddedDate(formattedDate)
                        .fuelCapacity(busRequest.getFuelCapacity())
                        .maintenanceToday(String.valueOf(formatter))
                        .mileage(busRequest.getMileage())
                        .numberOfSeats(80)
                        .busAddedTime(String.valueOf(LocalTime.now()))
                        .manufacturer(PayLoadsConfig.generateRandomBusCompanyName())
                        .busOwnerApp(busOwnerApp.get())
                        .ownerId(busRequest.getOwnerId())
                        .build();
                busRepositories.save(information);
            } else {
                throw new BusServiceException(BUS_ALREADY_EXIST);
            }
        }
        assert information != null;
        return BusResponse.builder()
                .busNumber(information.getBusNumber())
                .butInit(information.getBusInit())
                .busId(information.getBusId())
                .route(information.getRoute())
                .maintenanceToday(String.valueOf(currentDateTime))
                .todayDate(formattedDate)
                .localTime(LocalTime.parse(String.valueOf(LocalTime.now())))
                .manufacturer(information.getManufacturer())
                .message(BUS_ADDED_SUCCESSFULLY).statusOwner(TO_OWNER_MOBILE)
                .comingMaintenanceDay(UPCOMING_MAINTENANCE_DAY + " - " + String.valueOf(maintenanceDate))
                .build();

    }

    @Override
    public OwnerInfoResponse getOwnerInfo(String ownerId, String ownerContactNumber, String ownerEmail) {

        if (ownerId.isBlank() || ownerContactNumber.isBlank() || ownerEmail.isBlank()) {
            throw new BusServiceException(ALL_FIELDS_ARE_REQUIRED);
        }

        Optional<BusOwnerApp> forId = busOwnerRepositories.findById(ownerId);

        if (forId.isPresent()) {
            BusOwnerApp ownerApp = forId.get();

            List<BusInformation> busInformationList = busRepositories.findByOwnerId(ownerApp.getOwnerId());
            ownerApp.setBusInformation(busInformationList);

            // Convert to response DTO
            OwnerInfoResponse response = OwnerInfoResponse.builder()
                    .ownerId(ownerApp.getOwnerId())
                    .ownerFirstName(ownerApp.getOwnerFirstName())
                    .ownerLastName(ownerApp.getOwnerLastName())
                    .ownerAge(ownerApp.getOwnerAge())
                    .ownerContactNumber(ownerApp.getOwnerContactNumber())
                    .ownerAddress(ownerApp.getOwnerAddress())
                    .ownerTodayDate(ownerApp.getOwnerTodayDate())
                    .ownerEmail(ownerApp.getOwnerEmail())
                    .ownerCompany(ownerApp.getOwnerCompany())
                    .ownerRegistrationDate(ownerApp.getOwnerRegistrationDate())
                    .ownerInsuranceNumber(ownerApp.getOwnerInsuranceNumber())
                    .insuranceImportantMesMessage(ownerApp.getInsuranceImportantMesMessage())
                    .numberOfBuses(ownerApp.getNumberOfBuses())
                    .note(ownerApp.getNote())
                    .busInformation(ownerApp.getBusInformation())
                    .build();

            return response;
        } else {
            throw new BusServiceException("Id is not available");
        }

    }
}




