package com.v3.hub.bus.rider.MHubRide.constant;

import lombok.Data;

@Data
public class BusConstants {

    public static final String BUS_ADDED_SUCCESSFULLY = "Bus has been successfully added.";
    public static final String DRIVER_LICENSE_NOT_AVAILABLE = "Driver license information is not available.";
    public static final String DRIVER_REGISTER_NUMBER_NOT_AVAILABLE = "Driver registration number is not available.";
    public static final String ROUTE_NOT_PROVIDED = "Route information is not provided.";
    public static final String UPCOMING_MAINTENANCE_DAY = "Upcoming maintenance day for this bus.";
    public static final String TO_OWNER_MOBILE = "You will soon receive information about your bus on your registered mobile number.";
    public static final String ALL_FIELDS_ARE_REQUIRED = "Please ensure that all fields are filled out. It is mandatory to provide information in every field to proceed.";
    public static final String ALERT_MESSAGE = "Attention: An important message requires your consideration. In case of any bus issues, the owner is responsible for resolution.";
    public static final String OWNER_ADDED_SUCCESSFULLY = "Owner information has been added successfully.";
    public static final String OWNER_ALREADY_EXIST = "Owner already exists.";
    public static final String PASSENGER_ID_START_WITH_ONLY_NUMERIC_VALUE = "Passenger ID should start with a numeric value.";
    public static final String FIRST_NAME_LENGTH = "First name should have characters between 4 and 15.";
    public static final String LAST_NAME_LENGTH = "Last name should have characters between 4 and 15.";
    public static final String OWNER_EMAIL_EXIST = "Owner with the provided email already exists.";
    public static final String OWNER_PHONE_EXIST = "Owner with the provided contact number already exists.";
    public static final String BUS_ALREADY_EXIST = "This bus already exists.";
    public static final String OWNER_NOT_FOUND = "Owner details not found.";
    public static final String CONDUCTOR_ADDED_SUCCESSFULLY = "Conductor added successfully.";
    public static final String DRIVER_HAS_BEEN_ADDED = "Driver has been added successfully.";
    public static final String PASSENGER_ADDED = "Passenger has been added successfully.";
    public static final String PASSENGER_ALREADY_BOOKED = "Passenger has already been booked.";
    public static final String PASSENGER_NOT_FOUND = "Passenger not found.";
}
