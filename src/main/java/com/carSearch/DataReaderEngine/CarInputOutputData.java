package com.carSearch.DataReaderEngine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarInputOutputData {
    ArrayList<String> plateNumbers = new ArrayList<>();
    HashMap<String, String[]> details = new HashMap<>();
    public String content;

    {
        try {
            content = new String(Files.readAllBytes(Paths.get("car_input.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getPlateNumber() throws IOException {
//            HashMap<String, String[]> details = new HashMap<>();
            //        String output = new String(Files.readAllBytes(Paths.get("car_output.txt")));
            Pattern pattern = Pattern.compile("[A-Z]{2}[0-9]{2}[A-Z]{3}");
            Matcher matcher = pattern.matcher(content.replaceAll("\\s+", ""));
            while (matcher.find()) {

                plateNumbers.add(matcher.group());
            }
        System.out.println("REG NUMBERS EXTRACTED FROM INPUT TEXT FILE");
        System.out.println(plateNumbers);
            return plateNumbers;
        }

        public String[] getCarDetails(String plateNumber) {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(
                        "car_output.txt"));
                String line = reader.readLine();
                while (line != null) {
                    String[] detail = line.split(",");
                    this.details.put(detail[0], detail);
                    line = reader.readLine();
                }
                reader.close();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
            details.keySet().remove("REGISTRATION");

//            System.out.println(Arrays.toString(details.get(plateNumber)));
//            System.out.println(Arrays.toString(details.get(plateNumber)));
//            System.out.println(Arrays.toString(details.get("KT17DLX")));
//            System.out.println(Arrays.toString(details.get("SG18HTN")));
            return details.get(plateNumber);
        }
}
