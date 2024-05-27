package uy.edu.um.entities;

import com.opencsv.bean.CsvBindByName;

import java.util.List;

public class SpotifyTrack {
    @CsvBindByName(column = "spotify_id")
    private String spotifyId;

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "artists")
    private String artists;  // This will initially store the artists as a single string

    @CsvBindByName(column = "daily_rank")
    private int dailyRank;

    @CsvBindByName(column = "daily_movement")
    private int dailyMovement;

    @CsvBindByName(column = "weekly_movement")
    private int weeklyMovement;

    @CsvBindByName(column = "country")
    private String country;

    @CsvBindByName(column = "snapshot_date")
    private String snapshotDate;

    @CsvBindByName(column = "popularity")
    private int popularity;

    @CsvBindByName(column = "is_explicit")
    private boolean isExplicit;

    @CsvBindByName(column = "duration_ms")
    private int durationMs;

    @CsvBindByName(column = "album_name")
    private String albumName;

    @CsvBindByName(column = "album_release_date")
    private String albumReleaseDate;

    @CsvBindByName(column = "danceability")
    private double danceability;

    @CsvBindByName(column = "energy")
    private double energy;

    @CsvBindByName(column = "key")
    private int key;

    @CsvBindByName(column = "loudness")
    private double loudness;

    @CsvBindByName(column = "mode")
    private int mode;

    @CsvBindByName(column = "speechiness")
    private double speechiness;

    @CsvBindByName(column = "acousticness")
    private double acousticness;

    @CsvBindByName(column = "instrumentalness")
    private double instrumentalness;

    @CsvBindByName(column = "liveness")
    private double liveness;

    @CsvBindByName(column = "valence")
    private double valence;

    @CsvBindByName(column = "tempo")
    private double tempo;

    @CsvBindByName(column = "time_signature")
    private int timeSignature;

    // Additional field to store the split artists
    private List<String> artistList;

    public SpotifyTrack(String spotifyId, String name, String artists, int dailyRank, int dailyMovement, int weeklyMovement, String country, String snapshotDate, int popularity, boolean isExplicit, int durationMs, String albumName, String albumReleaseDate, double danceability, double energy, int key, double loudness, int mode, double speechiness, double acousticness, double instrumentalness, double liveness, double valence, double tempo, int timeSignature, List<String> artistList) {
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

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
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

    public List<String> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<String> artistList) {
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
