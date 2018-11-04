package Functional;

import models.*;
import services.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Functional {

    public static void addSong(String songName, String songYear, String artistName, String genreName,
                     String albumName, String albumYear, String collectionName) throws SQLException {
        SongService songService = new SongService();
        ArtistService artistService = new ArtistService();
        GenreService genreService = new GenreService();
        AlbumService albumService = new AlbumService();
        CollectionService collectionService = new CollectionService();

        Song song = new Song(songName, songYear);

        if (artistService.findArtistByName(artistName) == null) {
            Artist artist = new Artist(artistName);
            song.setArtist(artist);
            artist.addSong(song);
            artistService.saveArtist(artist);
        } else {
            Artist artist = artistService.findArtistByName(artistName);
            song.setArtist(artist);
            artist.addSong(song);
            artistService.updateArtist(artist);
        }

        Genre genre = genreService.findGenreByName(genreName);
        song.setGenre(genre);
        genre.addSong(song);

        if (albumService.findAlbumByName(albumName) == null) {
            Album album = new Album(albumName, albumYear);
            song.setAlbum(album);
            album.addSong(song);
            albumService.saveAlbum(album);
        } else {
            Album album = albumService.findAlbumByName(albumName);
            song.setAlbum(album);
            album.addSong(song);
            albumService.updateAlbum(album);
        }

        if (!collectionName.equals("-")) {
            if (collectionService.findCollectionByName(collectionName) == null) {
                Collection collection = new Collection(collectionName);
                song.setCollection(collection);
                collection.addSong(song);
                collectionService.saveCollection(collection);
            } else {
                Collection collection = collectionService.findCollectionByName(collectionName);
                song.setCollection(collection);
                collection.addSong(song);
                collectionService.updateCollection(collection);
            }
        }

        genreService.updateGenre(genre);
        songService.saveSong(song);
    }

    public static void addCollectionToSong(String songName, String collectionName) {
        SongService songService = new SongService();
        CollectionService collectionService = new CollectionService();

        try {
            Song song = songService.findSongByName(songName);

            if (collectionService.findCollectionByName(collectionName) == null) {
                Collection collection = new Collection(collectionName);
                song.setCollection(collection);
                collection.addSong(song);
                collectionService.saveCollection(collection);
            } else {
                Collection collection = collectionService.findCollectionByName(collectionName);
                song.setCollection(collection);
                collection.addSong(song);
                collectionService.updateCollection(collection);
            }

            songService.updateSong(song);
        } catch (NullPointerException e) {
            System.out.println("Song is not found!");
        }
    }

    public static List<Song> getAllSongs() {
        SongService songService = new SongService();
        return songService.findAllSongs();
    }

    public static List<Artist> getAllArtists() {
        ArtistService artistService = new ArtistService();
        return artistService.findAllArtists();
    }

    public static void printAllSongs() {
        int i = 1;
        SongService songService = new SongService();
        List<Song> songs = songService.findAllSongs();
        String collection, output ="";

        for (Song song : songs) {
            collection = "";

            if (song.getCollection() != null)
                collection = "\n   " + "Collection name: " + song.getCollection().getName();

            output = output + i + ") " + "Song name: " + song.getName() +
                    "\n   " + "Artist name: " + song.getArtist().getName() +
                    "\n   " + "Album name: " + song.getAlbum().getName() +
                    "\n   " + "Year: " + song.getYear() +
                    "\n   " + "Genre: " + song.getGenre().getName() +
                    collection + "\n";
            i++;
        }
        JOptionPane.showMessageDialog(null, output, "All songs:", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void printAllArtists() {
        int i = 1;
        ArtistService artistService = new ArtistService();
        List<Artist> artists = artistService.findAllArtists();
        String name, output = "";

        for (Artist artist : artists) {
            name = "";
            for (Song song : artistService.findSongsById(artist.getArtistID())) {
                name = name + song.getName() + "\n   ";
            }

            output = output + i + ") " + "Atrist name: " + artist.getName() +
                    "\n   " + name + "\n";
            i++;
        }
        JOptionPane.showMessageDialog(null, output, "All artists:", JOptionPane.INFORMATION_MESSAGE);
    }

    public static Song getSong(String name) {
        SongService songService = new SongService();
        try {
            Song song = songService.findSongByName(name);
        } catch (NullPointerException e) {
            System.out.println("Song is not found!");
        }
        return songService.findSongByName(name);
    }

    public static void printSong(String name) {
        try {
            Song song = getSong(name);
            String collection = "";

            if (song.getCollection() != null)
                collection = "Collection name: " + song.getCollection().getName();

            JOptionPane.showMessageDialog(null, "Song name: " + song.getName() + "\n" +
                    "Artist name: " + song.getArtist().getName() + "\n" +
                    "Genre: " + song.getGenre().getName() + "\n" +
                    "Album: " + song.getAlbum().getName() + "\n" +
                    "Year: " + song.getYear() + "\n" +
                    collection, name, JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) {
            System.out.println("Song does not exist!");
        }
    }

    public static Artist getArtist(String name) {
        ArtistService artistService = new ArtistService();
        try {
            Artist artist = artistService.findArtistByName(name);
        } catch (NullPointerException e) {
            System.out.println("Artist is not found!");
        }
        return artistService.findArtistByName(name);
    }

    public static void printArtist(String name) {
        ArtistService artistService = new ArtistService();
        try {
            Artist artist = getArtist(name);
            String output = "";
            name = "";

            for (Song song : artistService.findSongsById(artist.getArtistID())) {
                name = name + song.getName() + "\n   ";
            }

            output = "Atrist name: " + artist.getName() +
                    "\n   " + name + "\n";

            JOptionPane.showMessageDialog(null, output, artist.getName(), JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) {
            System.out.println("Artist does not exist!");
        }
    }

    public static Genre getGenre(String name) {
        GenreService genreService = new GenreService();
        try {
            Genre genre = genreService.findGenreByName(name);
        } catch (NullPointerException e) {
            System.out.println("Genre is not found!");
        }
        return genreService.findGenreByName(name);
    }

    public static void printGenre(String name) {
        SongService songService = new SongService();
        GenreService genreService = new GenreService();
        try {
            Genre genre = getGenre(name);
            String output = "";
            name = "";

            for (Song song : genre.getSong()) {
                name = name + song.getName() + "\n   ";
            }

            output = "Genre name: " + genre.getName() +
                    "\n   " + name + "\n";

            JOptionPane.showMessageDialog(null, output, genre.getName(), JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) {
            System.out.println("Genre does not exist!");
        }
    }

    public static Album getAlbum(String name) {
        AlbumService albumService = new AlbumService();
        try {
            Album album = albumService.findAlbumByName(name);
        } catch (NullPointerException e) {
            System.out.println("Album is not found!");
        }
        return albumService.findAlbumByName(name);
    }

    public static void printAlbum(String name) {
        SongService songService = new SongService();
        AlbumService albumService = new AlbumService();
        try {
            Album album = getAlbum(name);
            String output = "";
            name = "";

            for (Song song : album.getSong()) {
                name = name + song.getName() + "\n   ";
            }

            output = "Album name: " + album.getName() +
                    "\n   " + name + "\n";

            JOptionPane.showMessageDialog(null, output, album.getName() + " - " + album.getSong().stream().findAny().get().getArtist().getName(), JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) {
            System.out.println("Genre does not exist!");
        }
    }

    public static Collection getCollection(String name) {
        CollectionService collectionService = new CollectionService();
        try {
            Collection collection = collectionService.findCollectionByName(name);
        } catch (NullPointerException e) {
            System.out.println("Collection is not found!");
        }
        return collectionService.findCollectionByName(name);
    }

    public static void printCollection(String name) {
        SongService songService = new SongService();
        CollectionService collectionService = new CollectionService();

        try {
            Collection collection = getCollection(name);
            String output = "";
            name = "";

            for (Song song : collection.getSong()) {
                name = name + song.getName() + " - " + song.getArtist().getName() + "\n   ";
            }

            output = "Collection name: " + collection.getName() +
                    "\n   " + name + "\n";

            JOptionPane.showMessageDialog(null, output, collection.getName(), JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) {
            System.out.println("Collection does not exist!");
        }
    }

    public static void songCustomSearch(String songYear, String artistName, String genreName,
                                    String albumName, String collectionName) {
        SongService songService = new SongService();
        ArtistService artistService = new ArtistService();
        GenreService genreService = new GenreService();
        AlbumService albumService = new AlbumService();
        CollectionService collectionService = new CollectionService();

        Stream<Song> songStream = null;
        String output = "";

        List<Song> songs = songService.findAllSongs();

        if (songYear != "-") {
            songStream = songs.stream().filter((song) -> song.getYear().contains(songYear));
        }

        if (albumName != "-") {
            songStream = songs.stream().filter((song) -> song.getAlbum().getName().contains(artistName));
        }

        if (genreName != "-") {
            songStream = songs.stream().filter((song) -> song.getGenre().getName().contains(genreName));
        }

        if (artistName != "-") {
            songStream = songs.stream().filter((song) -> song.getArtist().getName().contains(artistName));
        }

        if (collectionName != "-") {
            songStream = songs.stream().filter((song) -> song.getCollection().getName().contains(collectionName));
        }

        songs = songStream.collect(Collectors.toList());

        for (Song song : songs) {
            output = output + song.getName() + " - " + song.getArtist().getName() + "\n";
        }
        if (songs.size() == 0)
            output = "Wrong search parameters!";

        JOptionPane.showMessageDialog(null, output, "Custom Search", JOptionPane.INFORMATION_MESSAGE);
    }
}
