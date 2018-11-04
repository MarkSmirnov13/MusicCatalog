package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumID;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private String year;

    @OneToMany(mappedBy = "album")
    private Set<Song> songs = new HashSet<>();

    public Album() {
    }

    public Album(String name, String year) {
        this.name = name;
        this.year = year;
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

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public int getAlbumID() {
        return albumID;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
