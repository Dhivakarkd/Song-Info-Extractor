package com.dhivakar.model;

import lombok.Getter;

@Getter
public class AudioTag {

    private String Title;
    private String Artist;
    private String Album;
    private String Genre;

    public void setTitle(String title) {
        if(title != null) {
            Title = replaceAll(title);
        }else{
            Title = "";
        }
    }

    public void setArtist(String artist) {
        if(artist != null) {
            Artist = replaceAll(artist);
        }else{
            Artist = "";
        }
    }

    public void setAlbum(String album) {
        if(album != null) {
            Album = replaceAll(album);
        }else{
            Album = "";
        }
    }

    public void setGenre(String genre) {
        if(genre != null) {
            Genre = replaceAll(genre);
        }else{
            Genre = "Tamil";
        }
    }

    private String replaceAll(String input) {

        input = input.replace("-StarMusiQ.Com", "");
        input = input.replace("- MassTamilan.fm", "");
        input = input.replace("-StarMusiQ.Top", "");
        input = input.replace("-StarMusiQ.Fun", "");
        input = input.replace("- MassTamilan.com", "");
        input = input.replace("- MassTamilan.io", "");
        input = input.replace("- Masstamilan.In", "");
        input = input.replace("-Masstamilan.in", "");
        input = input.replace("- MassTamilan.org", "");
        input = input.replace("MassTamilan.com", "");
        input = input.replace("MassTamilan.io", "");
        input = input.replace("Masstamilan.In", "");
        input = input.replace("Masstamilan.in", "");
        input = input.replace("MassTamilan.org", "");

        return input;
    }
}
