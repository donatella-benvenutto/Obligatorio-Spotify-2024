package uy.edu.um;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.IterableCSVToBeanBuilder;
import com.opencsv.CSVReader;


import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;

public class Main {
    public static void main(String[] args) {
        String csvFile = "data.csv";

        try (Reader reader = new FileReader(csvFile)) {
            HeaderColumnNameMappingStrategy<spotifyTrack> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(spotifyTrack.class);

            CsvToBean<spotifyTrack> csvToBean = new CsvToBean<>();
            List<spotifyTrack> tracks = csvToBean.parse(strategy, new CSVReader(reader));

            // Process each track to split the "artists" field
            for (spotifyTrack track : tracks) {
                String artists = track.getArtists();
                if (artists != null && !artists.isEmpty()) {
                    List<String> firstartistList = Arrays.asList(artists.split(",\\s*"));
                    MyList<String> artistList= new MyLinkedListImpl<>();
                    artistList = artistList.parseFromJavaList(firstartistList);
                    track.setArtistList(artistList);
                }
                System.out.println(track);
            }
            MyList<spotifyTrack> Tracks = new MyLinkedListImpl<>();
            Tracks=Tracks.parseFromJavaList(tracks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
