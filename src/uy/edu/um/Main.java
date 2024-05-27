package uy.edu.um;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.IterableCSVToBeanBuilder;

import java.io.FileReader;
import java.io.Reader;
import uy.edu.um.adt.*;
import uy.edu.um.entities.SpotifyTrack;

public class Main {
    public static void main(String[] args) {
        String csvFile = "data.csv";

        try (Reader reader = new FileReader(csvFile)) {
            CsvToBean<SpotifyTrack> csvToBean = new CsvToBeanBuilder<SpotifyTrack>(reader)
                    .withType(SpotifyTrack.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<SpotifyTrack> tracks = csvToBean.parse();

            // Process each track to split the "artists" field
            for (SpotifyTrack track : tracks) {
                String artists = track.getArtists();
                if (artists != null && !artists.isEmpty()) {
                    List<String> artistList = Arrays.asList(artists.split(",\\s*"));
                    track.setArtistList(artistList);
                }
                System.out.println(track);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
