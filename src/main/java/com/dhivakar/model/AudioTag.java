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

        final String[] keys = {"-StarMusiQ.Com", "- MassTamilan.fm", "-StarMusiQ.Top", "-StarMusiQ.Fun",
                "- MassTamilan.com", "- MassTamilan.io", "- Masstamilan.In", "-Masstamilan.in",
                "- MassTamilan.org", "MassTamilan.com", "MassTamilan.io", "Masstamilan.In",
                "Masstamilan.in", "MassTamilan.fm"
        };
        final String[] values = {"", "", "", "", "","", "", "", "", "","", "", "", ""};

        return StringUtils.replaceEach(input, keys, values);

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
