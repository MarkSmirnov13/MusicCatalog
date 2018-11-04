package models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreID;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "genre")
    private Set<Song> songs = new HashSet<>();

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }

    public Set<Song> getSong() {
        return songs;
    }

    public void setSong(List<Song> songs) {
        Set<Song> song = new HashSet<>(songs);
        this.songs = song;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGenreID() {
        return genreID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
