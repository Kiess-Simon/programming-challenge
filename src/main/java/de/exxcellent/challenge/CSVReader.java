package de.exxcellent.challenge;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.*;

public class CSVReader {

    public CsvToBean readWeatherCSV(String filePath) throws Exception {


                Reader reader = Files.newBufferedReader(Paths.get(filePath));


            CsvToBean<CSVWeatherPreset> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVWeatherPreset.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean;

    }
}
