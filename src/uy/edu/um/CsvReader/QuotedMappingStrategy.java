package uy.edu.um.CsvReader;

import com.opencsv.bean.HeaderColumnNameMappingStrategy;

public class QuotedMappingStrategy<T> extends HeaderColumnNameMappingStrategy<T> {
    @Override
    public String getColumnName(int col) {
        // Fetch the column name using the parent class method
        String columnName = super.getColumnName(col);

        // Remove surrounding quotes if present
        if (columnName != null && columnName.startsWith("\"") && columnName.endsWith("\"")) {
            columnName = columnName.substring(1, columnName.length() - 1);
        }
        System.out.println("Column name: " + columnName);
        // Return the cleaned column name
        return columnName;
    }
}
