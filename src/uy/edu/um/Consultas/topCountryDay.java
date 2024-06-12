package uy.edu.um.Consultas;

import uy.edu.um.adt.hash.MyHash;
import uy.edu.um.adt.hash.MyHashImpl;
import uy.edu.um.entities.spotifyTrack;
import uy.edu.um.adt.linkedlist.MyList;

public class topCountryDay {
    public static String findTopArtist(MyList<spotifyTrack> tracks, String date, String country) {
        MyHash<String, Integer> artistCountMap = new MyHashImpl<>();

        MyList<String> artists = null;
        int i;
        for (i = 0; i < tracks.size(); i++) {
            spotifyTrack track = tracks.get(i);
            if (track.getSnapshotDate().equals(date) && track.getCountry().equalsIgnoreCase(country)) {
                artists = track.getArtistList();
                for (int j = 0; j < artists.size(); j++) {
                    String artist = artists.get(i);
                    artistCountMap.put(artist, artistCountMap.getOrDefault(artist, 0) + 1);
                }
            }
        }

        String topArtist = null;
        int maxCount = 0;
        i = 0;
        while (artistCountMap.getsize() >= i) {
            if (entry.getValue() > maxCount) {
                topArtist = entry.getKey();
                maxCount = entry.getValue();
            }
            i++;
        }

        return topArtist;
    }
}
}
