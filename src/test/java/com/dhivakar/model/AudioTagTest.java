package com.dhivakar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudioTagTest {

    @Test
    void validReplaceMethod() {

        AudioTag tag = new AudioTag();

        tag.setGenre("Tamil- MassTamilan.so");
        tag.setArtist("Test Artist - MassTamilan.so");
        tag.setTitle("Test song - MassTamilan.so");
        tag.setAlbum("Test Album - MassTamilan.so");
        tag.setLyrics("No Lyrics");

        System.out.println(tag);

        assertEquals("Tamil", tag.getGenre());
    }
}