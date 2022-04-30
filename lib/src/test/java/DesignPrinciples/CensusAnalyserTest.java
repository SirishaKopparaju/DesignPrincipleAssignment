package DesignPrinciples;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "D:\\Design\\DesignPrinciples\\lib\\src\\test\\java";
    private static final String WRONG_CSV_FILE_PATH = "D:\\Design\\DesignPrinciples\\lib\\src\\test\\java";
    private static final String INDIA_CENSUS_CSV_WRONG_FILETYPE = "D:\\Design\\DesignPrinciples\\lib\\src\\test\\java\\IndiaStateCensusData.pdf";
    private static final String INDIA_CENSUS_CSV_PATH_DELIMETER = "D:\\\\Design\\\\DesignPrinciples\\\\lib\\\\src\\\\test\\\\java\\\\IndiaStateCensusData.pdf";
    private static final String INDIA_CENSUS_CSV_PATH_HEADER = "D:\\\\Design\\\\DesignPrinciples\\\\lib\\\\src\\\\test\\\\java\\\\IndiaStateCensusDataHeader.pdf";
    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
    @Test
    public void givenIndianCensusCSVFileReturnsInCorrecFileType_But_PathShouldBeCorrect() {
    	try {
        CensusAnalyser censusAnalyzer = new CensusAnalyser();
       
            int numOfRecord = censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_WRONG_FILETYPE);
            Assert.assertEquals(29, numOfRecord);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianCensusCSVFileReturnsIncorrectDelimeter(){
        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        try {
            censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH_DELIMETER);
            Assert.assertTrue("Wrong delimiter", true);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianCensusCSVFileHaveIncorrectHeader() {
        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        try {
            censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH_HEADER);
            Assert.assertTrue("Wrong header in csv file", true);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }

    }
}



