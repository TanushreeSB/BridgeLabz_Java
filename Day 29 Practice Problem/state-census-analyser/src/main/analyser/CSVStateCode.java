package analyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCode {

    @CsvBindByName(column = "SrNo")
    public int srNo;

    @CsvBindByName(column = "State Name")
    public String stateName;

    @CsvBindByName(column = "TIN")
    public int tin;

    @CsvBindByName(column = "StateCode")
    public String stateCode;
}