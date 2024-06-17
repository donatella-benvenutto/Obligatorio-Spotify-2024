package uy.edu.um;

import com.opencsv.CSVParserBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import uy.edu.um.CsvReader.QuotedMappingStrategy;
import uy.edu.um.CsvReader.bufferReader;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;

public class Main {
    public static void main(String[] args) {
        String csvFile = "CSV/universal_top_spotify_songs.csv";

        try {
            // Preprocess the CSV file
            String processedCSVFile = bufferReader.preprocessCSV(csvFile);

            // Now use the processed CSV file
            try (Reader reader = new FileReader(processedCSVFile)) {
                CSVReader csvReader = new CSVReaderBuilder(reader)
                        .withSkipLines(1)
                        .withCSVParser(new CSVParserBuilder()
                                .withSeparator(';')
                                .withQuoteChar(',')
                                .withIgnoreQuotations(false)
                                .build())
                        .build();

                QuotedMappingStrategy<spotifyTrack> strategy = new QuotedMappingStrategy<>();
                strategy.setType(spotifyTrack.class);

                CsvToBean<spotifyTrack> csvToBean = new CsvToBeanBuilder<spotifyTrack>(csvReader)
                        .withMappingStrategy(strategy)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                List<spotifyTrack> tracks = csvToBean.parse();
                System.out.print(tracks);
                for (spotifyTrack track : tracks) {
                    String name = track.getName();
                    if (name != null) {
                        track.setName(name.replace("\"<DOUBLE_QUOTE>", "\"\""));
                        track.setName(name.replace("<SEMICOLON>", ";"));
                    }
                    String albumName = track.getAlbumName();
                    if (albumName != null) {
                        track.setAlbumName(albumName.replace("\"<DOUBLE_QUOTE>", "\"\""));
                        track.setAlbumName(albumName.replace("<SEMICOLON>", ";"));
                    }
                }
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}