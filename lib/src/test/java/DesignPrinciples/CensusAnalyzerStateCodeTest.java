package DesignPrinciples;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyzerStateCodeTest {

    private static final String INDIA_CENSUS_CSV_PATH = "D:\\Design\\DesignPrinciples\\lib\\src\\test\\resources\\IndiaStateCode.CSV";

    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertEquals(37, numOfRecord);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianStateCSVFileReturnsInCorrectRecords() {
        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        try {
            int numOfRecord = censusAnalyzer.loadIndiaStateCodeData(INDIA_STATE_CSV_PATH);
            Assert.assertEquals(40, numOfRecord);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

}