package com.dhivakar.model;

import lombok.Data;
import lombok.Getter;

@Getter
public class AudioTag {

    private String Title;
    private String Artist;
    private String Album;
    private String Genre;

    public void setTitle(String title) {
        Title = replaceAll(title);
    }

    public void setArtist(String artist) {
        Artist = replaceAll(artist);
    }

    public void setAlbum(String album) {
        Album = replaceAll(album);
    }

    public void setGenre(String genre) {
        Genre = replaceAll(genre);
    }

    private String replaceAll(String input) {

        input = input.replace("-StarMusiQ.Com", "");
        input = input.replace("- MassTamilan.fm", "");
        input = input.replace(" -StarMusiQ.Top", "");

        return input;
    }
}
