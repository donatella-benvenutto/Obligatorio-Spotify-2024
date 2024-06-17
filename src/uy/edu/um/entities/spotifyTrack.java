package uy.edu.um.entities;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByName;
import uy.edu.um.CsvReader.QuotedBooleanConverter;
import uy.edu.um.CsvReader.QuotedDoubleConverter;
import uy.edu.um.CsvReader.QuotedIntegerConverter;
import uy.edu.um.CsvReader.QuotedStringConverter;
import uy.edu.um.adt.linkedlist.MyList;

public class spotifyTrack {
    @CsvBindByPosition(position = 0)
    private String spotifyId;

    @CsvCustomBindByName(column = "name", converter = QuotedStringConverter.class)
    private String name;

    @CsvCustomBindByName(column = "\"artists\"", converter = QuotedStringConverter.class)
    private String artists;

    @CsvCustomBindByName(column = "\"daily_rank\"", required = false, converter = QuotedIntegerConverter.class)
    private Integer dailyRank;

    @CsvCustomBindByName(column = "\"daily_movement\"", required = false, converter = QuotedIntegerConverter.class)
    private Integer dailyMovement;

    @CsvCustomBindByName(column = "\"weekly_movement\"", required = false, converter = QuotedIntegerConverter.class)
    private Integer weeklyMovement;

    @CsvCustomBindByName(column = "\"country\"", required = false, converter = QuotedStringConverter.class)
    private String country;

    @CsvCustomBindByName(column = "\"snapshot_date\"", converter = QuotedStringConverter.class)
    private String snapshotDate;

    @CsvCustomBindByName(column = "\"popularity\"", required = false, converter = QuotedIntegerConverter.class)
    private Integer popularity;

    @CsvCustomBindByName(column = "\"is_explicit\"", required = false, converter = QuotedBooleanConverter.class)
    private Boolean isExplicit;

    @CsvCustomBindByName(column = "\"duration_ms\"", required = false, converter = QuotedIntegerConverter.class)
    private Integer durationMs;

    @CsvCustomBindByName(column = "\"album_name\"", converter = QuotedStringConverter.class)
    private String albumName;

    @CsvCustomBindByName(column = "\"album_release_date\"", converter = QuotedStringConverter.class)
    private String albumReleaseDate;

    @CsvCustomBindByName(column = "\"danceability\"", required = false, converter = QuotedDoubleConverter.class)
    private Double danceability;

    @CsvCustomBindByName(column = "\"energy\"", required = false, converter = QuotedDoubleConverter.class)
    private Double energy;

    @CsvCustomBindByName(column = "\"key\"", required = false, converter = QuotedIntegerConverter.class)
    private Integer key;

    @CsvCustomBindByName(column = "\"loudness\"", required = false, converter = QuotedDoubleConverter.class)
    private Double loudness;

    @CsvCustomBindByName(column = "\"mode\"", required = false, converter = QuotedIntegerConverter.class)
    private Integer mode;

    @CsvCustomBindByName(column = "\"speechiness\"", required = false, converter = QuotedDoubleConverter.class)
    private Double speechiness;

    @CsvCustomBindByName(column = "\"acousticness\"", required = false, converter = QuotedDoubleConverter.class)
    private Double acousticness;

    @CsvCustomBindByName(column = "\"instrumentalness\"", required = false, converter = QuotedDoubleConverter.class)
    private Double instrumentalness;

    @CsvCustomBindByName(column = "\"liveness\"", required = false, converter = QuotedDoubleConverter.class)
    private Double liveness;

    @CsvCustomBindByName(column = "\"valence\"", required = false, converter = QuotedDoubleConverter.class)
    private Double valence;

    @CsvCustomBindByName(column = "\"tempo\"", required = false, converter = QuotedDoubleConverter.class)
    private Double tempo;

    @CsvCustomBindByName(column = "\"time_signature\"", required = false, converter = QuotedIntegerConverter.class)
    private Integer timeSignature;

    // Additional field to store the split artists
    private MyList<String> artistList;

    public spotifyTrack(String spotifyId, String name, String artists, int dailyRank, int dailyMovement, int weeklyMovement, String country, String snapshotDate, int popularity, boolean isExplicit, int durationMs, String albumName, String albumReleaseDate, double danceability, double energy, int key, double loudness, int mode, double speechiness, double acousticness, double instrumentalness, double liveness, double valence, double tempo, int timeSignature, MyList<String> artistList) {
        this.spotifyId = spotifyId;
        this.name = name;
        this.artists = artists;
        this.dailyRank = dailyRank;
        this.dailyMovement = dailyMovement;
        this.weeklyMovement = weeklyMovement;
        this.country = country;
        this.snapshotDate = snapshotDate;
        this.popularity = popularity;
        this.isExplicit = isExplicit;
        this.durationMs = durationMs;
        this.albumName = albumName;
        this.albumReleaseDate = albumReleaseDate;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.mode = mode;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.timeSignature = timeSignature;
        this.artistList = artistList;
    }

    public spotifyTrack() {
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        System.out.println("Setting spotifyId: " + spotifyId);
        this.spotifyId = spotifyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public int getDailyRank() {
        return dailyRank;
    }

    public void setDailyRank(int dailyRank) {
        this.dailyRank = dailyRank;
    }

    public int getDailyMovement() {
        return dailyMovement;
    }

    public void setDailyMovement(int dailyMovement) {
        this.dailyMovement = dailyMovement;
    }

    public int getWeeklyMovement() {
        return weeklyMovement;
    }

    public void setWeeklyMovement(int weeklyMovement) {
        this.weeklyMovement = weeklyMovement;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(String snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isExplicit() {
        return isExplicit;
    }

    public void setExplicit(boolean explicit) {
        isExplicit = explicit;
    }

    public int getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(int durationMs) {
        this.durationMs = durationMs;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumReleaseDate() {
        return albumReleaseDate;
    }

    public void setAlbumReleaseDate(String albumReleaseDate) {
        this.albumReleaseDate = albumReleaseDate;
    }

    public double getDanceability() {
        return danceability;
    }

    public void setDanceability(double danceability) {
        this.danceability = danceability;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public double getLoudness() {
        return loudness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public double getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(double speechiness) {
        this.speechiness = speechiness;
    }

    public double getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }

    public double getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public double getLiveness() {
        return liveness;
    }

    public void setLiveness(double liveness) {
        this.liveness = liveness;
    }

    public double getValence() {
        return valence;
    }

    public void setValence(double valence) {
        this.valence = valence;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public int getTimeSignature() {
        return timeSignature;
    }

    public void setTimeSignature(int timeSignature) {
        this.timeSignature = timeSignature;
    }

    public MyList<String> getArtistList() {
        return artistList;
    }

    public void setArtistList(MyList<String> artistList) {
        this.artistList = artistList;
    }

    @Override
    public String toString() {
        return "SpotifyTrack{" +
                "spotifyId='" + spotifyId + '\'' +
                ", name='" + name + '\'' +
                ", artists='" + artists + '\'' +
                ", artistList=" + artistList +
                ", dailyRank=" + dailyRank +
                ", dailyMovement=" + dailyMovement +
                ", weeklyMovement=" + weeklyMovement +
                ", country='" + country + '\'' +
                ", snapshotDate='" + snapshotDate + '\'' +
                ", popularity=" + popularity +
                ", isExplicit=" + isExplicit +
                ", durationMs=" + durationMs +
                ", albumName='" + albumName + '\'' +
                ", albumReleaseDate='" + albumReleaseDate + '\'' +
                ", danceability=" + danceability +
                ", energy=" + energy +
                ", key=" + key +
                ", loudness=" + loudness +
                ", mode=" + mode +
                ", speechiness=" + speechiness +
                ", acousticness=" + acousticness +
                ", instrumentalness=" + instrumentalness +
                ", liveness=" + liveness +
                ", valence=" + valence +
                ", tempo=" + tempo +
                ", timeSignature=" + timeSignature +
                '}';
    }
}