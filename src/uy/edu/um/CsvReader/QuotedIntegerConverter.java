package uy.edu.um.CsvReader;

import com.opencsv.bean.AbstractBeanField;
import uy.edu.um.entities.spotifyTrack;

public class QuotedIntegerConverter extends AbstractBeanField<spotifyTrack, Integer> {
    @Override
    protected Object convert(String value) {
        return Integer.parseInt(value.replace("\"", ""));
    }
}
