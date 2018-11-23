package de.exxcellent.challenge;

public class CSVRowObject {
    String vIdentifier;     //Stores the value (v) that identifies the data of a single CSV-file row
    int vMinuend;           //Stores the value of the minuend of that row
    int vSubtrahend;        //           "            subtrahend     "
    int vDifference;        //Stores the difference of the minuend and the subtrahend

   public void setProperties(String identifier, int minuend, int subtrahend){
        vIdentifier = identifier;
        vMinuend = minuend;
        vSubtrahend = subtrahend;
        vDifference = minuend - subtrahend;

    }
}
