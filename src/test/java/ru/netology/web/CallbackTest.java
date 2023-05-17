package ru.netology.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CallbackTest {
    @BeforeEach
    void setUpTests() {
        open("http://localhost:9999/");
    }

    @Test
    void shouldSendForm() {

        $("[data-test-id=name] input").setValue("Олежка");
        $("[data-test-id=phone] input").setValue("+78888888888");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}