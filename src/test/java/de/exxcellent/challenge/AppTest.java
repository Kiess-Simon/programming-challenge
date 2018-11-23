package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {

    @Test
    public void testSetProperties() {
        String expIden = "Hello there";
        int expMinu = 25;
        int expSubt = 5;
        int expDiff = 20;

        CSVRowObject testObj = new CSVRowObject();
        testObj.setProperties("Hello there", 25, 5);
        assertEquals(expIden,testObj.vIdentifier,"Iden ok");
        assertEquals(expDiff, testObj.vDifference,"Diff ok");
    }

    private String successLabel = "not successful";

    @BeforeEach
    public void setUp() {
        successLabel = "successful";
    }

    @Test
    public void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    public void runFootball() {
        App.main("--football", "football.csv");
    }

}
