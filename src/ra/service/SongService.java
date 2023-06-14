package ra.service;

import ra.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongService {
    private List<Song> songs;

    public SongService() {
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void updateSong(Song song) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getSongId().equals(song.getSongId())) {
                songs.set(i, song);
                break;
            }
        }
    }

    public void deleteSong(String songId) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getSongId().equals(songId)) {
                songs.remove(i);
                break;
            }
        }
    }

    public Song findSongById(String songId) {
        for (Song song : songs) {
            if (song.getSongId().equals(songId)) {
                return song;
            }
        }
        return null;
    }

    public List<Song> getAllSongs() {
        return songs;
    }
}