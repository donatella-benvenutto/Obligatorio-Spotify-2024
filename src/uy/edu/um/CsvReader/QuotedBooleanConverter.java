package uy.edu.um.CsvReader;

import com.opencsv.bean.AbstractBeanField;
import uy.edu.um.entities.spotifyTrack;

public class QuotedBooleanConverter extends AbstractBeanField<spotifyTrack, Boolean> {
    @Override
    protected Object convert(String value) {
        return Boolean.parseBoolean(value.replace("\"", ""));
    }
}