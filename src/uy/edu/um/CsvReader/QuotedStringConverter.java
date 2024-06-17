package uy.edu.um.CsvReader;

import com.opencsv.bean.AbstractBeanField;
import uy.edu.um.entities.spotifyTrack;

public class QuotedStringConverter extends AbstractBeanField<spotifyTrack, String> {
    @Override
    protected Object convert(String value) {
        System.out.println("Converting value: " + value);
        String unquotedValue = value.substring(1, value.length() - 1);
        System.out.println("Unquoted value: " + unquotedValue);
        return unquotedValue;
    }
}