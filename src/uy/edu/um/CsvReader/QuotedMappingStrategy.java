package uy.edu.um.CsvReader;

import com.opencsv.bean.HeaderColumnNameMappingStrategy;

public class QuotedMappingStrategy<T> extends HeaderColumnNameMappingStrategy<T> {
    @Override
    public String getColumnName(int col) {
        return super.getColumnName(col).replace("\"", "");
    }
}
