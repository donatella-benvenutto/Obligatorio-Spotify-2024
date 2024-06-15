package uy.edu.um;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import uy.edu.um.CsvReader.bufferReader;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvFile = "CSV/universal_top_spotify_songs.csv";

        try {
            // Preprocess the CSV file
            String processedCSVFile = bufferReader.preprocessCSV(csvFile);

            // Now use the processed CSV file
            try (Reader reader = new FileReader(processedCSVFile)) {
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim()
                        .withIgnoreSurroundingSpaces()
                        .withDelimiter(';') // Specify the delimiter
                        .withIgnoreEmptyLines() // Ignore empty lines
                        .withAllowMissingColumnNames() // Allow missing column names
                        .withQuote('\0')); // Set the quote character to a non-existing character

                List<spotifyTrack> tracks = new ArrayList<>();

                for (CSVRecord csvRecord : csvParser) {
                    spotifyTrack track = new spotifyTrack();
                    track.setSpotifyId(csvRecord.get("spotify_id").replace("\"", ""));
                    track.setName(csvRecord.get("name").replace("\"", ""));
                    track.setArtists(csvRecord.get("artists").replace("\"", ""));
                    track.setDailyRank(Integer.parseInt(csvRecord.get("daily_rank").replace("\"", "")));
                    track.setDailyMovement(Integer.parseInt(csvRecord.get("daily_movement").replace("\"", "")));
                    track.setWeeklyMovement(Integer.parseInt(csvRecord.get("weekly_movement").replace("\"", "")));
                    track.setCountry(csvRecord.get("country").replace("\"", ""));
                    track.setSnapshotDate(csvRecord.get("snapshot_date").replace("\"", ""));
                    track.setPopularity(Integer.parseInt(csvRecord.get("popularity").replace("\"", "")));
                    track.setExplicit(Boolean.parseBoolean(csvRecord.get("is_explicit").replace("\"", "")));
                    track.setDurationMs(Integer.parseInt(csvRecord.get("duration_ms").replace("\"", "")));
                    track.setAlbumName(csvRecord.get("album_name").replace("\"", ""));
                    track.setAlbumReleaseDate(csvRecord.get("album_release_date").replace("\"", ""));
                    track.setDanceability(Double.parseDouble(csvRecord.get("danceability").replace("\"", "")));
                    track.setEnergy(Double.parseDouble(csvRecord.get("energy").replace("\"", "")));
                    track.setKey(Integer.parseInt(csvRecord.get("key").replace("\"", "")));
                    track.setLoudness(Double.parseDouble(csvRecord.get("loudness").replace("\"", "")));
                    track.setMode(Integer.parseInt(csvRecord.get("mode").replace("\"", "")));
                    track.setSpeechiness(Double.parseDouble(csvRecord.get("speechiness").replace("\"", "")));
                    track.setAcousticness(Double.parseDouble(csvRecord.get("acousticness").replace("\"", "")));
                    track.setInstrumentalness(Double.parseDouble(csvRecord.get("instrumentalness").replace("\"", "")));
                    track.setLiveness(Double.parseDouble(csvRecord.get("liveness").replace("\"", "")));
                    track.setValence(Double.parseDouble(csvRecord.get("valence").replace("\"", "")));
                    track.setTempo(Double.parseDouble(csvRecord.get("tempo").replace("\"", "")));
                    track.setTimeSignature(Integer.parseInt(csvRecord.get("time_signature").replace("\"", "")));
                    tracks.add(track);
                }

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