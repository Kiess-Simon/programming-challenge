package de.exxcellent.challenge;
import java.io.*;
import java.util.*;
import com.opencsv.*;
import de.exxcellent.challenge.CSVReader;



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
        String pathWeather = "C:\\Users\\Simon\\IdeaProjects\\programming-challenge\\src\\main\\resources\\de..." +
                "\\exxcellent\\challenge\\test.csv";

        try (
                // Read given .CSV file and store the crucial data according.
                // The necessary data is defined by a respective preset
                CSVReader weatherReader = new CSVReader().readWeatherCSV(pathWeather);
        ) {
            String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

            String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);


        }
    }
}
