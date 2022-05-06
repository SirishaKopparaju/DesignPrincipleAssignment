package DesignPrinciples;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyzerStateCodeTest {

	private static final String INDIA_STATE_CSV_PATH = "D:\\Design\\DesignPrinciples\\lib\\src\\test\\resources\\IndiaStateCode.csv";
    private static final String INDIA_STATE_CSV_WRONG_FILETYPE = "D:\\Design\\DesignPrinciples\\lib\\src\\test\\resources\\IndiaStateCode.pdf";
    private static final String INDIA_STATE_CSV_PATH_DELIMETER = "D:\\Design\\DesignPrinciples\\lib\\src\\test\\resources\\IndiaStateCode.csv";

    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData(INDIA_STATE_CSV_WRONG_FILETYPE);
            Assert.assertEquals(37, numOfRecord);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianStateCSVFileReturnsInCorrectRecords() {
        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData(INDIA_STATE_CSV_PATH);
            Assert.assertEquals(40, numOfRecord);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianStateCSVFileReturnsInCorrecFileType_But_PathShouldBeCorrect() {
        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData(INDIA_STATE_CSV_WRONG_FILETYPE);
            Assert.assertEquals(29, numOfRecord);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianStateCSVFileReturnsIncorrectDelimeter() {
        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        try {
            censusAnalyzer.loadIndiaCensusData(INDIA_STATE_CSV_PATH_DELIMETER);
            Assert.assertTrue("Wrong delimiter", true);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

}