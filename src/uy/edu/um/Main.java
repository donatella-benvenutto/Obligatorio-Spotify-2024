package uy.edu.um;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;

public class Main {
    public static void main(String[] args) {
        String csvFile = "CSV/universal_top_spotify_songs.csv";

        try (Reader reader = new FileReader(csvFile);
             CSVReader csvReader = new CSVReader(reader)) {
            // Read the header row
            String[] headers = csvReader.readNext();
            HeaderColumnNameMappingStrategy<spotifyTrack> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(spotifyTrack.class);

            CsvToBean<spotifyTrack> csvToBean = new CsvToBeanBuilder<spotifyTrack>(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1) // Skip the header row
                    .build();

            List<spotifyTrack> tracks = csvToBean.parse();
            System.out.print(tracks);

            // Process each track to split the "artists" field
            for (spotifyTrack track : tracks) {
                String artists = track.getArtists();
                if (artists != null && !artists.isEmpty()) {
                    List<String> firstartistList = Arrays.asList(artists.split(",\\s*"));
                    MyList<String> artistList = new MyLinkedListImpl<>();
                    artistList = artistList.parseFromJavaList(firstartistList);
                    track.setArtistList(artistList);
                }
            }

            MyList<spotifyTrack> Tracks = new MyLinkedListImpl<>();
            Tracks = Tracks.parseFromJavaList(tracks);
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}