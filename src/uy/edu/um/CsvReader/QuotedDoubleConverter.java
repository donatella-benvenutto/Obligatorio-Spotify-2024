package uy.edu.um.CsvReader;

import com.opencsv.bean.AbstractBeanField;
import uy.edu.um.entities.spotifyTrack;

public class QuotedDoubleConverter extends AbstractBeanField<spotifyTrack, Double> {
    @Override
    protected Object convert(String value) {
        return Double.parseDouble(value.replace("\"", ""));
    }
}
