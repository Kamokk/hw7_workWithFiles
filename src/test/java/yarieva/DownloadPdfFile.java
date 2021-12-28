package yarieva;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.*;

public class DownloadPdfFile {

    @Test
    @DisplayName("Скачивание PDF файла")
    void pdfFileDownloadTest() throws IOException {
        open("https://git-scm.com/book/ru/v2");
        File pdf = $$(".ebooks a").get(0).download();
        PDF parsedPdf = new PDF(pdf);
        Assertions.assertEquals(557, parsedPdf.numberOfPages);
    }

}
