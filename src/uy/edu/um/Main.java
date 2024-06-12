package uy.edu.um;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.*;
import com.opencsv.CSVReader;


import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;

import static uy.edu.um.adt.linkedlist.MyLinkedListImpl.parseFromJavaList;

public class Main {
    public static void main(String[] args) {
        String csvFile = "data.csv";

        try (Reader reader = new FileReader(csvFile)) {
            CsvToBean<spotifyTrack> csvToBean = new CsvToBeanBuilder<spotifyTrack>(reader)
                    .withType(spotifyTrack.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<spotifyTrack> tracks = csvToBean.parse();

            // Process each track to split the "artists" field
            for (spotifyTrack track : tracks) {
                String artists = track.getArtists();
                if (artists != null && !artists.isEmpty()) {
                    List<String> firstartistList = Arrays.asList(artists.split(",\\s*"));
                    MyList<String> artistList = parseFromJavaList(firstartistList);
                    track.setArtistList(artistList);
                }
                System.out.println(track);
            }
            MyList<spotifyTrack> Tracks = parseFromJavaList(tracks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
