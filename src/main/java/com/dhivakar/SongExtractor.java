package com.dhivakar;

import com.dhivakar.exception.NoArgumentException;
import com.dhivakar.helper.LyricsHelper;
import com.dhivakar.model.AudioTag;
import lombok.extern.slf4j.Slf4j;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.logging.LogManager;

@Slf4j
public class SongExtractor {

    public static void main(String[] args) throws CannotReadException, TagException, InvalidAudioFrameException, ReadOnlyFileException, IOException, NoArgumentException {

        // To disable unnecessary logging of JAudioTagger Library
        LogManager.getLogManager().reset();

        if (args.length == 1) {

            log.info("Song Extractor Starting with Input : {}", args[0]);
            initializeFileExtraction(args[0], "N");

        } else if (args.length == 2) {
            initializeFileExtraction(args[0], args[1]);
        } else {

            throw new NoArgumentException("No Arguments were Provided for Reading the File");
        }

    }

    private static void initializeFileExtraction(String filePath, String needLyrics) {

        File file = new File(filePath);

        boolean lyricsStatus = needLyrics.equalsIgnoreCase("y");


        if (file.isFile()) {
            processFile(file, lyricsStatus);

        } else if (file.isDirectory()) {
            processDirectory(file, lyricsStatus);
        }

    }

    private static void processDirectory(File file, boolean needTamilLyrics) {

        FilenameFilter filter = (dir, name) -> name.endsWith(".mp3");

        File[] files = file.listFiles(filter);

        for (File eachFile : files) {
            processFile(eachFile, needTamilLyrics);
        }
    }

    private static void processFile(File file, boolean needTamilLyrics) {
        AudioFile audioFile = null;
        try {
            audioFile = AudioFileIO.read(file);
        } catch (CannotReadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TagException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            e.printStackTrace();
        } catch (InvalidAudioFrameException e) {
            e.printStackTrace();
        }
        Tag audioTag = audioFile.getTag();

        AudioTag processedTagInfo = processTags(audioTag, needTamilLyrics);

        try {
            updateTagValues(audioTag, processedTagInfo);
            AudioFileIO.write(audioFile);
        } catch (CannotWriteException e) {
            e.printStackTrace();
        } catch (FieldDataInvalidException e) {
            e.printStackTrace();
        }
    }

    private static void updateTagValues(Tag audioTag, AudioTag processedTagInfo) throws FieldDataInvalidException {

        audioTag.setField(FieldKey.ALBUM, processedTagInfo.getAlbum());
        audioTag.setField(FieldKey.TITLE, processedTagInfo.getTitle());
        audioTag.setField(FieldKey.ARTIST, processedTagInfo.getArtist());
        audioTag.setField(FieldKey.GENRE, processedTagInfo.getGenre());
        audioTag.setField(FieldKey.LYRICS, processedTagInfo.getLyrics());

    }

    private static AudioTag processTags(Tag audioTag, boolean needTamilLyrics) {

        AudioTag inputTag = new AudioTag();

        inputTag.setAlbum(audioTag.getFirst(FieldKey.ALBUM));
        inputTag.setTitle(audioTag.getFirst(FieldKey.TITLE));
        inputTag.setArtist(audioTag.getFirst(FieldKey.ARTIST));
        inputTag.setGenre(audioTag.getFirst(FieldKey.GENRE));

        String lyrics = null;
        if (needTamilLyrics) {

            lyrics = LyricsHelper.fetchLyrics(inputTag.getTitle(), true);
        } else {
            lyrics = LyricsHelper.fetchLyrics(inputTag.getTitle(), false);
        }

        inputTag.setLyrics(lyrics);

        log.info(inputTag.toString());
        return inputTag;
    }

}
