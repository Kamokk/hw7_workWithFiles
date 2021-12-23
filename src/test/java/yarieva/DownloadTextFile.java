package yarieva;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadTextFile

{

    @Test
    @DisplayName("Скачивание текстового файла и проверка его содержимого")
    void downloadSimpleTextFileTest() throws IOException {

            open("https://testpages.herokuapp.com/styled/download/download.html");

            File download = $("#direct-download-a").download();
            String fileContent = IOUtils.toString(new FileReader(download));


        assertTrue(fileContent.contains("This is a text file.\n" +
                "\n" +
                "Downloaded from https://testapps.heroku.com\n" +
                "\n" +
                "Remember to visit https://EvilTester.com for all your testing edufication."));
    }

}
