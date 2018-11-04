import models.Song;
import services.ArtistService;

import java.sql.SQLException;

import static Functional.Functional.*;

public class Main {
    public static void main(String[] args) throws SQLException, NullPointerException {
//        addSong("H", "2017", "Imagine Dragons", "Pop", "Evolve", "2017", "-");
        printAllSongs();
        printAllArtists();

//        try {
//            Song song = getSong("Hello");
//            System.out.println(song.getName());
//        } catch (NullPointerException e) {
//            System.out.println("Song does not exist!");
//        }

//        printSong("Hallo");
//        printArtist("Imagine Dragons");
//        printGenre("Pop");
//
//        addCollectionToSong("Thunder", "ID");
//
//        printAlbum("Hello");
//        printCollection("My playlist");
//
//        songCustomSearch("2017", "Imagine Dragons", "-", "-", "-");



/* -------------------- Get song by name -------------------- */
//        Song s = songService.findSongByName("Hello");
//        System.out.println(s.getName());
//        System.out.println(s.getArtist().getName());

/* -------------------- First song -------------------- */
//        Artist LuisFonsi = new Artist("Luis Fonsi");
//        Song song1 = new Song();
//        song1.setName("Despacito");
//        song1.setYear("2017");
//        song1.setArtist(LuisFonsi);
//        LuisFonsi.addSong(song1);
//        artistService.saveArtist(LuisFonsi);
//        songService.saveSong(song1);
//        Song song1 = songService.findSongById(12);
//        song1.setGenre(pop);
//        Album despacito = new Album("Despacito","2017");
//        song1.setAlbum(despacito);
//        Genre genre1 = genreService.findGenreById(7);
//        genre1.addSong(song1);
//        genreService.updateGenre(genre1);
//        despacito.addSong(song1);
//        albumService.saveAlbum(despacito);
//        songService.updateSong(song1);

/* -------------------- Second song -------------------- */
//        Artist Drake = new Artist("Drake");
//        Song song2 = new Song();
//        song2.setName("In my feelings");
//        song2.setYear("2018");
//        song2.setArtist(Drake);
//        Drake.addSong(song2);
//        artistService.saveArtist(Drake);
//        songService.saveSong(song2);
//        Song song2 = songService.findSongById(13);
//        song2.setGenre(hip_hop);
//        Album scorpion = new Album("Scorpion","2017");
//        song2.setAlbum(scorpion);
//        Genre genre2 = genreService.findGenreById(4);
//        genre2.addSong(song2);
//        genreService.updateGenre(genre2);
//        scorpion.addSong(song2);
//        albumService.saveAlbum(scorpion);
//        songService.updateSong(song2);

/* -------------------- Third song -------------------- */
//        Song song3 = new Song();
//        song3.setName("Nonstop");
//        song3.setYear("2016");
//        song3.setArtist(artistService.findArtistById(12));
//        artistService.findArtistById(12).addSong(song3);
//        songService.saveSong(song3);
//        Song song3 = songService.findSongById(15);
//        song3.setGenre(genreService.findGenreById(4));
//        Album album = albumService.findAlbumById(2);
//        song3.setAlbum(album);
//        genreService.findGenreById(4).addSong(song3);
//        genreService.updateGenre(genreService.findGenreById(4));
//        album.addSong(song3);
//        albumService.updateAlbum(album);
//        songService.saveSong(song3);


/* -------------------- Fourth song -------------------- */
//        Song song4 = new Song("Hallo", "2017");
//        Artist Adele = new Artist("Adele");
//        Album hello = new Album("Hello","2017");
//        Genre pop = genreService.findGenreById(7);
//        Collection collection = collectionService.findCollectionById(1);
//
//        song4.setArtist(Adele);
//        song4.setGenre(pop);
//        song4.setAlbum(hello);
//        song4.setCollection(collection);
//        collection.addSong(song4);
//        pop.addSong(song4);
//        hello.addSong(song4);
//        Adele.addSong(song4);
//
//        genreService.updateGenre(pop);
//        albumService.saveAlbum(hello);
//        artistService.saveArtist(Adele);
//        collectionService.updateCollection(collection);
//        songService.saveSong(song4);

/* -------------------- Collection -------------------- */
//        Collection collection1 = new Collection("My playlist");
//        Collection collection1 = collectionService.findCollectionById(1);
//        collection1.setSongs(songService.findAllSongs());
//        song1.setCollection(collection1);
//        songService.updateSong(song1);
//        song2.setCollection(collection1);
//        songService.updateSong(song2);
//        song3.setCollection(collection1);
//        songService.updateSong(song3);
//        collectionService.updateCollection(collection1);

//        Set<Song> songs = collectionService.findCollectionById(1).getSong();
//        Iterator<Song> itr = songs.iterator();
//        while (itr.hasNext()) {
//            System.out.println(itr.next().getName());
//        }

//        System.out.println(songService.findSongById(12).getArtist().getName());

//        artistService.findSongsById(11).stream().map(Song::getName).forEach(System.out::println);

//        songService.deleteAllSongs(songService.findAllSongs());
//        artistService.deleteAllArtists(artistService.findAllArtists());
    }
}
