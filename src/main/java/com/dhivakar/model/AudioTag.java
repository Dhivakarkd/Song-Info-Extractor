package com.dhivakar.model;

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
        Genre = "Tamil";
    }

    private String replaceAll(String input) {

        input = input.replace("-StarMusiQ.Com", "");
        input = input.replace("- MassTamilan.fm", "");
        input = input.replace(" -StarMusiQ.Top", "");
        input = input.replace("- MassTamilan.com", "");
        input = input.replace("- MassTamilan.io", "");
        input = input.replace("- Masstamilan.In", "");
        input = input.replace("- MassTamilan.org", "");

        return input;
    }
}
