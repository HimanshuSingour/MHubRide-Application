package com.v3.hub.bus.rider.MHubRide.payloads;

import java.util.Random;

public class PayLoadsConfig {

    public static String generateBusNumber() {

        Random random = new Random();
        int randomValue = 0;

        for (int i = 0; i < 4; i++) {
            randomValue = random.nextInt(9000) + 1000; // Generates a 4-digit number
        }

        return String.valueOf(randomValue);
    }

    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder randomString = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = new Random().nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }

    public static String generateBusModelNumber() {
        String prefix = "BUS";
        String randomPart = generateRandomString(4);
        int serialNumber = new Random().nextInt(1000) + 1; // Adjust the range as needed

        return String.format("%s-%s-%03d", prefix, randomPart, serialNumber);
    }

    public static String generateLicenseNumber() {

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 10;
        StringBuilder licenseNumber = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            licenseNumber.append(randomChar);
        }

        return licenseNumber.toString();
    }

    public static String generateSeatNumber() {
        // Define arrays of seat rows and seat letters
        int[] seatRows = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // Assuming there are 10 rows
        char[] seatLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};  // Assuming there are 10 letters

        Random random = new Random();

        int randomRowIndex = random.nextInt(seatRows.length);
        int randomLetterIndex = random.nextInt(seatLetters.length);

        int randomRow = seatRows[randomRowIndex];
        char randomLetter = seatLetters[randomLetterIndex];

        String seatNumber = Integer.toString(randomRow) + randomLetter;

        return seatNumber;
    }

    public static String generateBusTicketNumber() {

        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int ticketNumberLength = 7;
        StringBuilder ticketNumberBuilder = new StringBuilder(ticketNumberLength);
        Random random = new Random();

        // Generate the ticket number
        for (int i = 0; i < ticketNumberLength; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            char randomChar = allowedCharacters.charAt(randomIndex);
            ticketNumberBuilder.append(randomChar);
        }

        return ticketNumberBuilder.toString();
    }

    public static String generateRandomInit() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder randomString = new StringBuilder(7);

        for (int i = 0; i < 7; i++) {
            int index = new Random().nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();

    }

    public static String generateBusInsuranceNumber() {

        String prefix = "BUS";
        int randomDigits = generateRandomDigits(6);
        String insuranceNumber = prefix + randomDigits;
        return insuranceNumber;
    }

    private static int generateRandomDigits(int numberOfDigits) {
        Random random = new Random();
        int max = (int) Math.pow(10, numberOfDigits);
        return random.nextInt(max);
    }

    public static String generateRandomBusCompanyName() {

        Random random = new Random();
        final String[] PREFIXES = {"Swift", "Express", "City", "Metro", "Global", "Transit"};
        final String[] SUFFIXES = {"Transport", "Bus Lines", "Transit Services", "Shuttle", "Connections"};
        String randomPrefix = PREFIXES[random.nextInt(PREFIXES.length)];
        String randomSuffix = SUFFIXES[random.nextInt(SUFFIXES.length)];

        int randomNumber = random.nextInt(100);

        return randomPrefix + " " + randomNumber + " " + randomSuffix;
    }

}
