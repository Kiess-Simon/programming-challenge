package de.exxcellent.challenge;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import de.exxcellent.challenge.DataStorage;



/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     *
     * @param args The CLI arguments passed
     */
    public static void main(String... args) throws Exception {

        // Your preparation code …

        // set .CSV locations
        String pathToWeather = "C:\\Users\\Simon\\IdeaProjects\\programming-challenge\\src\\main\\resources\\de" +
                "\\exxcellent\\challenge\\weather.csv";

        String pathToFootball = "C:\\Users\\Simon\\IdeaProjects\\programming-challenge\\src\\main\\resources\\de" +
                "\\exxcellent\\challenge\\football.csv";

        try (
                // Read the given .CSV file and store the crucial data accordingly.
                // The necessary data is defined by a respective preset
                Reader reader = Files.newBufferedReader(Paths.get(pathToWeather))


        ) {

            CsvToBean<CSVWeatherPreset> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVWeatherPreset.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            //Create an array list and  to store the crucial data (difference and belonging identifier)
            ArrayList<DataStorage> dataList = new ArrayList<>();


            //Iterate through the data bean ...
            Iterator<CSVWeatherPreset> csvWeatherIterator = csvToBean.iterator();
            while (csvWeatherIterator.hasNext()) {

                //to store the crucial data in a storage object (ListPreset)
                CSVWeatherPreset weatherData = csvWeatherIterator.next();       //Data of next the next entry

                DataStorage weatherStorage = new DataStorage();                 //Create storage object
                weatherStorage.setIdentifier(weatherData.getDay());             //Fill storage with data
                weatherStorage.setDifference(weatherData.getDifference());      //          "

                dataList.add(weatherStorage);                                   //Add storage object to array list
            }

            try (
                    // Read the given .CSV file and store the crucial data accordingly.
                    // The necessary data is defined by a respective preset
                    Reader reader2 = Files.newBufferedReader(Paths.get(pathToFootball))


            ) {

                CsvToBean<CSVFootballPreset> csvToBean2 = new CsvToBeanBuilder(reader2)
                        .withType(CSVFootballPreset.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                //Create an array list and  to store the crucial data (difference and belonging identifier)
                ArrayList<DataStorage> dataList2 = new ArrayList<>();


                //Iterate through the data bean ...
                Iterator<CSVFootballPreset> csvFootballIterator = csvToBean2.iterator();
                while (csvFootballIterator.hasNext()) {

                    //to store the crucial data in a storage object (ListPreset)
                    CSVFootballPreset footballData = csvFootballIterator.next();    //Data of next the next entry

                    DataStorage footballStorage = new DataStorage();                 //Create storage object
                    footballStorage.setIdentifier(footballData.getDay());             //Fill storage with data
                    footballStorage.setDifference(Math.abs(footballData.getDifference()));      //   " absolute data

                    dataList2.add(footballStorage);                                   //Add storage object to array list


                }

                //Compare the differences to find the identifier of the minimum

                {
                    String dayWithSmallestTempSpread = dataList.stream()
                            .min(Comparator.comparing(elements -> elements.diff))
                            .get().ident;
                    System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

                    String teamWithSmallestGoalSpread = dataList2.stream()
                            .min(Comparator.comparing(elements -> elements.diff))
                            .get().ident; // Your goal analysis function call …
                    System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);


                }
            }
        }
    }
}

