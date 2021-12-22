package yarieva;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class UploadFileText {
    private static final String REPOSITORY="/styled/file-upload-test.html";
    @Test
    @DisplayName("Загрузка файла")
    public void uploadFileText() {
        step("Открываем страницу", () -> {
            open("https://testpages.herokuapp.com/styled/file-upload-test.html");
        });
        step("Выбираем файл", () -> {
            $("input[type='file']").uploadFromClasspath("randomText.txt");
        });
        step("Загружаем файл", () -> {
            $(".styled-click-button").click();
        });
        step("Проверяем, что файл загрузился", () -> {
            $("#uploadedfilename").shouldHave(Condition.text("randomText.txt"));
        });


    }

}
