package analyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    String censusFilePath =
            "./src/main/resources/IndiaStateCensusData.csv";

    String stateCodeFilePath =
            "./src/main/resources/IndiaStateCode.csv";

    StateCensusAnalyser analyser =
            new StateCensusAnalyser();

    // ================= UC1 =================

    @Test
    public void givenStateCensusCSVFile_ShouldReturnCorrectRecords()
            throws CensusAnalyserException {

        int numOfRecords =
                analyser.loadIndiaCensusData(censusFilePath);

        Assertions.assertEquals(29, numOfRecords);
    }

    @Test
    public void givenWrongCensusFile_ShouldThrowException() {

        Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaCensusData(
                        "./wrongPath.csv"));
    }

    @Test
    public void givenWrongTypeFile_ShouldThrowException() {

        Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaCensusData(
                        "./IndiaStateCensusData.txt"));
    }

    @Test
    public void givenWrongDelimiterFile_ShouldThrowException() {

        Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaCensusData(
                        "./src/main/resources/WrongDelimiter.csv"));
    }

    @Test
    public void givenWrongHeaderFile_ShouldThrowException() {

        Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaCensusData(
                        "./src/main/resources/WrongHeader.csv"));
    }

    // ================= UC2 =================

    @Test
    public void givenStateCodeCSVFile_ShouldReturnCorrectRecords()
            throws CensusAnalyserException {

        int numOfRecords =
                analyser.loadIndiaStateCodeData(
                        stateCodeFilePath);

        Assertions.assertEquals(37, numOfRecords);
    }

    @Test
    public void givenWrongStateCodeFile_ShouldThrowException() {

        Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaStateCodeData(
                        "./wrong.csv"));
    }

    @Test
    public void givenWrongTypeStateCodeFile_ShouldThrowException() {

        Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaStateCodeData(
                        "./IndiaStateCode.txt"));
    }

    @Test
    public void givenWrongDelimiterStateCodeFile_ShouldThrowException() {

        Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaStateCodeData(
                        "./src/main/resources/WrongDelimiter.csv"));
    }

    @Test
    public void givenWrongHeaderStateCodeFile_ShouldThrowException() {

        Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadIndiaStateCodeData(
                        "./src/main/resources/WrongHeader.csv"));
    }
}