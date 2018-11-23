/*
import com.opencsv.bean.*;
import de.exxcellent.challenge.CSVRowObject;
import de.exxcellent.challenge.CSVUser;
import de.exxcellent.challenge.DataStorage;


import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

// The sole purpose of this class is to get familiar with the OpenCSV library and the OpenCSVReader.
// Code examples from "https://www.callicoder.com/java-read-write-csv-file-opencsv/".


public class OpenCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\Simon\\IdeaProjects\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\test.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) { CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            ArrayList<DataStorage> dataList = new ArrayList<>();

            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                //CSVRowObject csvObj = new CSVRowObject().setProperties(csvUser.getC1(),12,10);

                CSVUser csvUser = csvUserIterator.next();
                DataStorage testCSV = new DataStorage();
               String s;
               int x;
               s = csvUser.getC1();
               x = csvUser.getC4();

               testCSV.setIdentifier(s);
               testCSV.setDifference(x);
                dataList.add(testCSV);



                System.out.println("Column1 : " + csvUser.getC1());
                System.out.println("Column2 : " + csvUser.getC2());
                System.out.println("Column3 : " + csvUser.getC3());
                System.out.println("Column4 : " + csvUser.getC4());
                System.out.println("==========================");
            }

            System.out.println(dataList.stream().min(Comparator.comparing(elements -> elements.diff)).get().ident);

        }
    }
}
*/