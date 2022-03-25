package com.dhivakar.model;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class AudioTag {

    private String Title;
    private String Artist;
    private String Album;
    private String Genre;
    private String Lyrics;
    private String AlbumArtist;
    private String Composer;

    public void setTitle(String title) {
        if (title != null) {
            Title = replaceAll(title);
        } else {
            Title = "";
        }
    }

    public void setArtist(String artist) {
        if (artist != null) {
            Artist = replaceAll(artist);
        } else {
            Artist = "";
        }
    }

    public void setAlbum(String album) {
        if (album != null) {
            Album = replaceAll(album);
        } else {
            Album = "";
        }
    }

    public void setGenre(String genre) {
        if (genre != null) {
            Genre = replaceAll(genre);
        } else {
            Genre = "Tamil";
        }
    }

    public void setLyrics(String lyrics) {

        if(lyrics != null){
            Lyrics = lyrics;
        }else{
            Lyrics = "No Lyrics Found";
        }
    }

    private String replaceAll(String input) {

        int index= StringUtils.lastIndexOf(input,"-");

        return StringUtils.substring(input,0,index);

    }

    public void setAlbumArtist(String albumArtist) {
        if (albumArtist != null) {
            AlbumArtist = replaceAll(albumArtist);
        } else {
            AlbumArtist = "";
        }
    }

    public void setComposer(String composer) {
        if (composer != null) {
            Composer = replaceAll(composer);
        } else {
            Composer = "";
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n");
        sb.append("Title='").append(Title).append("'\n");
        sb.append("Artist='").append(Artist).append("'\n");
        sb.append("Album='").append(Album).append("'\n");
        sb.append("Genre='").append(Genre).append("'\n");
        sb.append("Lyrics='").append(Lyrics).append("'\n");
        return sb.toString();
    }
}
