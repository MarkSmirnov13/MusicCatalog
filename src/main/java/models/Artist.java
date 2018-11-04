package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artistID;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "artist")
    private Set<Song> songs = new HashSet<>();

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        Set<Song> song = new HashSet<>(songs);
        this.songs = song;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getArtistID() {
        return artistID;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
