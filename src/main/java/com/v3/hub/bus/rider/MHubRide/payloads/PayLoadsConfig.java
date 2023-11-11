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

    public static String generateRandomInit() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder randomString = new StringBuilder(7);

        for (int i = 0; i < 7; i++) {
            int index = new Random().nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();

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
