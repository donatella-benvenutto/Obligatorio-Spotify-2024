import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.CSVReader;
import org.junit.Before;
import org.junit.Test;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class mainTest {

    private static final String CSV_DATA = "\"spotify_id\",\"name\",\"artists\",\"daily_rank\",\"daily_movement\",\"weekly_movement\",\"country\",\"snapshot_date\",\"popularity\",\"is_explicit\",\"duration_ms\",\"album_name\",\"album_release_date\",\"danceability\",\"energy\",\"key\",\"loudness\",\"mode\",\"speechiness\",\"acousticness\",\"instrumentalness\",\"liveness\",\"valence\",\"tempo\",\"time_signature\"\n" +
            "\"1\",\"Song 1\",\"Artist 1, Artist 2\",\"1\",\"0\",\"0\",\"US\",\"2024-06-15\",\"85\",\"false\",\"210000\",\"Album 1\",\"2023-01-01\",\"0.8\",\"0.6\",\"5\",\"-5.0\",\"1\",\"0.05\",\"0.1\",\"0.0\",\"0.2\",\"0.5\",\"120.0\",\"4\"";

    private List<spotifyTrack> tracks;

    @Before
    public void setUp() throws Exception {
        Reader reader = new StringReader(CSV_DATA);
        HeaderColumnNameMappingStrategy<spotifyTrack> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(spotifyTrack.class);

        CsvToBean<spotifyTrack> csvToBean = new CsvToBeanBuilder<spotifyTrack>(reader)
                .withMappingStrategy(strategy)
                .withSkipLines(1) // Skip the header row
                .build();

        List<spotifyTrack> parsedTracks = csvToBean.parse();
        if (parsedTracks != null && !parsedTracks.isEmpty()) {
            this.tracks = parsedTracks;
        } else {
            this.tracks = new ArrayList<>();
        }
    }



    @Test
    public void testCsvParsing() {
        assertEquals(1, tracks.size());

        spotifyTrack track = tracks.get(0);
        assertEquals("1", track.getSpotifyId());
        assertEquals("Song 1", track.getName());
        assertEquals("Artist 1, Artist 2", track.getArtists());
        assertEquals("US", track.getCountry());
    }

    @Test
    public void testArtistSplitting() {
        spotifyTrack track = tracks.get(0);
        String artists = track.getArtists();
        List<String> firstArtistList = Arrays.asList(artists.split(",\\s*"));
        MyList<String> artistList = new MyLinkedListImpl<>();
        artistList = artistList.parseFromJavaList(firstArtistList);

        assertEquals(2, artistList.size());
        assertEquals("Artist 1", artistList.get(0));
        assertEquals("Artist 2", artistList.get(1));
    }

    @Test
    public void testTrackConversion() {
        MyList<spotifyTrack> trackList = new MyLinkedListImpl<>();
        trackList = trackList.parseFromJavaList(tracks);

        assertEquals(1, trackList.size());
        spotifyTrack track = trackList.get(0);
        assertEquals("1", track.getSpotifyId());
    }
}