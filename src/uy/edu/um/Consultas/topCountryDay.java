package uy.edu.um.Consultas;

import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.entities.spotifyTrack;
import uy.edu.um.adt.linkedlist.MyList;

public class topCountryDay {
    public static MyList<String> findTopSongs(MyList<spotifyTrack> tracks, String date, String country) {
        MyList<spotifyTrack> filteredTracks = new MyLinkedListImpl<>();

        for (int i = 0; i < tracks.size(); i++) {
            spotifyTrack track = tracks.get(i);
            if (track.getSnapshotDate().equals(date) && track.getCountry().equalsIgnoreCase(country)) {
                filteredTracks.add(track);
            }
        }

        MyList<spotifyTrack> sortedTracks = sortTracksByRank(filteredTracks);

        MyList<String> topSongs = new MyLinkedListImpl<>();
        for (int i = 0; i < Math.min(10, sortedTracks.size()); i++) {
            spotifyTrack track = sortedTracks.get(i);
            topSongs.add("Rank: " + track.getDailyRank() + ", Song: " + track.getName() + ", Artist(s): "+ track.getArtistList().parseMylisttoString());
        }
        return topSongs;
    }

    private static MyList<spotifyTrack> sortTracksByRank(MyList<spotifyTrack> tracks) {
        int n = tracks.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tracks.get(j).getDailyRank() > tracks.get(j + 1).getDailyRank()) {
                    spotifyTrack temp = tracks.get(j);
                    tracks.remove(temp);
                    tracks.addToPosition(temp, j + 1);
                }
            }
        }
        return tracks;
    }
}