package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "collection")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int collectionID;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "collection")
    private Set<Song> songs = new HashSet<>();

    public Collection() {
    }

    public Set<Song> getSong() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        Set<Song> song = new HashSet<>(songs);
        this.songs = song;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public Collection(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCollectionID() {
        return collectionID;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
