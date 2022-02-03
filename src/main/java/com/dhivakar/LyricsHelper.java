package com.dhivakar;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

@Slf4j
public class LyricsHelper {

    public static String fetchLyrics(String songName,boolean needTamilLyrics) {

        songName = songName.replaceAll(" ", "-");

        String targetTemplate = "https://www.tamil2lyrics.com/lyrics/$input$-song-lyrics/";

        String target = targetTemplate.replace("$input$", songName);

        String input = null;
        try {
            Document targetHtml = Jsoup.connect(target).get();

            log.debug("Page Name : {} \n Page Contents : \n {}", targetHtml.title(), targetHtml.html());


            Element requiredElement;
            if (needTamilLyrics) {
                requiredElement = targetHtml.getElementById("Tamil");
            } else {
                requiredElement = targetHtml.getElementById("English");
            }

            log.debug(requiredElement.html());

            String[] lineOfLyrics = requiredElement.html().split("\n");

            StringBuilder builder = new StringBuilder(" ");

            for (int i = 2; i < lineOfLyrics.length - 1; i++) {
                builder.append(replaceHtmlTags(lineOfLyrics[i]));

            }

            return builder.toString();

        } catch (HttpStatusException ex) {
            log.error("No Lyrics Found for the Song", ex);

            return "No Lyrics Found";
        } catch (IOException e) {
            log.error("IO Exception Occured while fetching {} song", input, e);
            return "no Lyrics Found";
        }


    }

    private static String replaceHtmlTags(final String text) {
        final String[] keys = {"<p style=\"text-align: center;\"><strong>", "</p>", "</strong>",
                "<br>", "<strong>", "<p style=\"text-align: center;\">"};
        final String[] values = {"", "\n", "", "\n", "", ""};

        return StringUtils.replaceEach(text, keys, values);
    }
}
