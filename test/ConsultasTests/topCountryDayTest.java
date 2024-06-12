package ConsultasTests;

import org.junit.Before;
import org.junit.Test;
import uy.edu.um.Consultas.topCountryDay;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class topCountryDayTest {

    private MyList<spotifyTrack> tracks;

    @Before
    public void setUp() {
        tracks = new MyLinkedListImpl<>();

        tracks.add(new spotifyTrack("1", "Song1", "Artist1", 1, 0, 0, "USA", "2023-10-15", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4, createArtistList("Artist1")));
        tracks.add(new spotifyTrack("2", "Song2", "Artist2", 2, 0, 0, "USA", "2023-10-15", 85, false, 210000, "Album2", "2023-02-01", 0.7, 0.8, 5, -5.0, 1, 0.1, 0.3, 0.0, 0.4, 0.6, 121.0, 4, createArtistList("Artist2")));
        tracks.add(new spotifyTrack("3", "Song3", "Artist3", 3, 0, 0, "USA", "2023-10-15", 80, false, 220000, "Album3", "2023-03-01", 0.6, 0.9, 5, -5.0, 1, 0.1, 0.4, 0.0, 0.5, 0.7, 122.0, 4, createArtistList("Artist3")));
        tracks.add(new spotifyTrack("4", "Song4", "Artist4", 4, 0, 0, "USA", "2023-10-15", 75, false, 230000, "Album4", "2023-04-01", 0.5, 1.0, 5, -5.0, 1, 0.1, 0.5, 0.0, 0.6, 0.8, 123.0, 4, createArtistList("Artist4")));
        tracks.add(new spotifyTrack("5", "Song5", "Artist5", 5, 0, 0, "USA", "2023-10-15", 70, false, 240000, "Album5", "2023-05-01", 0.4, 1.1, 5, -5.0, 1, 0.1, 0.6, 0.0, 0.7, 0.9, 124.0, 4, createArtistList("Artist5")));
        tracks.add(new spotifyTrack("6", "Song6", "Artist6", 6, 0, 0, "USA", "2023-10-15", 65, false, 250000, "Album6", "2023-06-01", 0.3, 1.2, 5, -5.0, 1, 0.1, 0.7, 0.0, 0.8, 1.0, 125.0, 4, createArtistList("Artist6")));
        tracks.add(new spotifyTrack("7", "Song7", "Artist7", 7, 0, 0, "USA", "2023-10-15", 60, false, 260000, "Album7", "2023-07-01", 0.2, 1.3, 5, -5.0, 1, 0.1, 0.8, 0.0, 0.9, 1.1, 126.0, 4, createArtistList("Artist7")));
        tracks.add(new spotifyTrack("8", "Song8", "Artist8", 8, 0, 0, "USA", "2023-10-15", 55, false, 270000, "Album8", "2023-08-01", 0.1, 1.4, 5, -5.0, 1, 0.1, 0.9, 0.0, 1.0, 1.2, 127.0, 4, createArtistList("Artist8")));
        tracks.add(new spotifyTrack("9", "Song9", "Artist9", 9, 0, 0, "USA", "2023-10-15", 50, false, 280000, "Album9", "2023-09-01", 0.05, 1.5, 5, -5.0, 1, 0.1, 1.0, 0.0, 1.1, 1.3, 128.0, 4, createArtistList("Artist9")));
        tracks.add(new spotifyTrack("10", "Song10", "Artist10", 10, 0, 0, "USA", "2023-10-15", 45, false, 290000, "Album10", "2023-10-01", 0.04, 1.6, 5, -5.0, 1, 0.1, 1.1, 0.0, 1.2, 1.4, 129.0, 4, createArtistList("Artist10")));
        tracks.add(new spotifyTrack("11", "Song11", "Artist11", 11, 0, 0, "USA", "2023-10-15", 40, false, 300000, "Album11", "2023-11-01", 0.03, 1.7, 5, -5.0, 1, 0.1, 1.2, 0.0, 1.3, 1.5, 130.0, 4, createArtistList("Artist11")));
        tracks.add(new spotifyTrack("12", "Song12", "Artist12", 12, 0, 0, "USA", "2023-10-15", 35, false, 310000, "Album12", "2023-12-01", 0.02, 1.8, 5, -5.0, 1, 0.1, 1.3, 0.0, 1.4, 1.6, 131.0, 4, createArtistList("Artist12")));
        tracks.add(new spotifyTrack("13", "Song13", "Artist13", 13, 0, 0, "USA", "2023-10-15", 30, false, 320000, "Album13", "2023-01-01", 0.01, 1.9, 5, -5.0, 1, 0.1, 1.4, 0.0, 1.5, 1.7, 132.0, 4, createArtistList("Artist13")));
        tracks.add(new spotifyTrack("14", "Song14", "Artist14", 14, 0, 0, "USA", "2023-10-15", 25, false, 330000, "Album14", "2023-02-01", 0.5, 1.0, 5, -5.0, 1, 0.1, 1.5, 0.0, 1.6, 1.8, 133.0, 4, createArtistList("Artist14")));
        tracks.add(new spotifyTrack("15", "Song15", "Artist15", 15, 0, 0, "USA", "2023-10-15", 20, false, 340000, "Album15", "2023-03-01", 0.5, 1.1, 5, -5.0, 1, 0.1, 1.6, 0.0, 1.7, 1.9, 134.0, 4, createArtistList("Artist15")));
        tracks.add(new spotifyTrack("16", "Song16", "Artist16", 16, 0, 0, "USA", "2023-10-15", 15, false, 350000, "Album16", "2023-04-01", 0.5, 1.2, 5, -5.0, 1, 0.1, 1.7, 0.0, 1.8, 2.0, 135.0, 4, createArtistList("Artist16")));
    }

    private MyList<String> createArtistList(String... artists) {
        MyList<String> artistList = new MyLinkedListImpl<>();
        for (String artist : artists) {
            artistList.add(artist);
        }
        return artistList;
    }

    @Test
    public void testFindTopSongs() {
        MyList<String> topSongs = topCountryDay.findTopSongs(tracks, "2023-10-15", "USA");

        assertNotNull(topSongs);
        assertEquals(3, topSongs.size());

        assertEquals("Rank: 1, Song: Song1, Artist(s): Artist1", topSongs.get(0));
        assertEquals("Rank: 2, Song: Song2, Artist(s): Artist2", topSongs.get(1));
        assertEquals("Rank: 3, Song: Song3, Artist(s): Artist3", topSongs.get(2));
    }

    @Test
    public void testFindTopSongsWithNoMatches() {
        MyList<String> topSongs = topCountryDay.findTopSongs(tracks, "2023-10-16", "USA");

        assertNotNull(topSongs);
        assertEquals(0, topSongs.size());
    }

    @Test
    public void testFindTopSongsWithDifferentCountry() {
        MyList<String> topSongs = topCountryDay.findTopSongs(tracks, "2023-10-15", "CAN");

        assertNotNull(topSongs);
        assertEquals(0, topSongs.size());
    }
}