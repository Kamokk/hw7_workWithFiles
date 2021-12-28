package yarieva;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadXlsFile {


    @Test
    @DisplayName("Скачивание XLS файла")
    void xlsFileDownloadTest() throws IOException {
        open("http://www.planetatorg.ru/pricelist/");
        File file = $(".size15 a").download();

        XLS parsedXls = new XLS(file);
        boolean checkPassed = parsedXls.excel
                .getSheetAt(0)
                .getRow(11)
                .getCell(0)
                .getStringCellValue()
                .contains("БЛ Бальзам оттеночный д/волос тон 08.1 теплый каштан/20шт/7705");
        assertTrue(checkPassed);
    }
}
