package analyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class StateCensusAnalyser {

    public int loadIndiaCensusData(String csvFilePath)
            throws CensusAnalyserException {

        try {

            if (!csvFilePath.endsWith(".csv")) {

                throw new CensusAnalyserException(
                        "Incorrect File Type",
                        CensusAnalyserException.ExceptionType
                                .INCORRECT_FILE_TYPE);
            }

            Reader reader = new FileReader(csvFilePath);

            CsvToBean<CSVStateCensus> csvToBean =
                    new CsvToBeanBuilder<CSVStateCensus>(reader)
                            .withType(CSVStateCensus.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

            Iterator<CSVStateCensus> iterator =
                    csvToBean.iterator();

            int count = 0;

            while (iterator.hasNext()) {
                iterator.next();
                count++;
            }

            return count;

        } catch (IOException e) {

            throw new CensusAnalyserException(
                    "File Problem",
                    CensusAnalyserException.ExceptionType
                            .NO_SUCH_FILE);

        } catch (RuntimeException e) {

            throw new CensusAnalyserException(
                    "CSV Parse Error",
                    CensusAnalyserException.ExceptionType
                            .UNABLE_TO_PARSE);
        }
    }

    public int loadIndiaStateCodeData(String csvFilePath)
            throws CensusAnalyserException {

        try {

            if (!csvFilePath.endsWith(".csv")) {

                throw new CensusAnalyserException(
                        "Incorrect File Type",
                        CensusAnalyserException.ExceptionType
                                .INCORRECT_FILE_TYPE);
            }

            Reader reader = new FileReader(csvFilePath);

            CsvToBean<CSVStateCode> csvToBean =
                    new CsvToBeanBuilder<CSVStateCode>(reader)
                            .withType(CSVStateCode.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

            Iterator<CSVStateCode> iterator =
                    csvToBean.iterator();

            int count = 0;

            while (iterator.hasNext()) {
                iterator.next();
                count++;
            }

            return count;

        } catch (IOException e) {

            throw new CensusAnalyserException(
                    "File Problem",
                    CensusAnalyserException.ExceptionType
                            .NO_SUCH_FILE);

        } catch (RuntimeException e) {

            throw new CensusAnalyserException(
                    "CSV Parse Error",
                    CensusAnalyserException.ExceptionType
                            .UNABLE_TO_PARSE);
        }
    }
}