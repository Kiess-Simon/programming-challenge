package de.exxcellent.challenge;
import java.io.*;
import java.io.IOException;
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

        String pathToFootball;

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
                weatherStorage.setDifference(weatherData.getdifference());      //          "

                dataList.add(weatherStorage);                                   //Add storage object to array list



            }

            //Compare the differences to find the identifier of the minimum

                {
                    String dayWithSmallestTempSpread = dataList.stream()
                            .min(Comparator.comparing(elements -> elements.diff))
                            .get().ident;
                    System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

                    String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
                    System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);


                }
        }
    }
}

