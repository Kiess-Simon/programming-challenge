package de.exxcellent.challenge;
import com.opencsv.bean.CsvBindByName;

public class CSVFootballPreset {

    /*This class defines the which columns of the .CSV are regarded by the CSV-reader.
    To solve this task it´s important to extract the following data:
    --- the minuend, the subtrahend along with an identifier ---
    The crucial columns are recognized by their names in the CSV-file header row.
    */

    @CsvBindByName(column = "Team")  //identifier
    private String day;

    @CsvBindByName(column = "Goals")  // minuend
    private int maxTemp;

    @CsvBindByName(column = "Goals Allowed")  // subtrahend
    private int minTemp;


    public String getDay(){
        return this.day;
    }
    public int getMaxTemp(){
        return this.maxTemp;
    }

    public int getMinTemp(){
        return this.minTemp;
    }

    public int getDifference(){
        return (this.maxTemp - this.minTemp);
    }
}