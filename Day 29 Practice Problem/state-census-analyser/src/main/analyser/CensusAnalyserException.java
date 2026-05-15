package analyser;

public class CensusAnalyserException extends Exception {

    public enum ExceptionType {
        NO_SUCH_FILE,
        INCORRECT_FILE_TYPE,
        UNABLE_TO_PARSE,
        INCORRECT_DELIMITER,
        INCORRECT_HEADER
    }

    ExceptionType type;

    public CensusAnalyserException(
            String message,
            ExceptionType type) {

        super(message);
        this.type = type;
    }
}