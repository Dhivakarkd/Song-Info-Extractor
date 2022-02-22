package com.dhivakar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudioTagTest {

    @Test
    void validReplaceMethod() {

        AudioTag tag = new AudioTag();

        tag.setGenre("Tamil");
        tag.setArtist("Test Artist");
        tag.setTitle("Test song");
        tag.setAlbum("Test Album");
        tag.setLyrics("No Lyrics");

        System.out.println(tag);

        assertEquals("Tamil", tag.getGenre());
    }
}