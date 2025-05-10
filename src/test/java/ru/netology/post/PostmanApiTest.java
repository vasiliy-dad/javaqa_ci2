package ru.netology.post;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanApiTest {
    @Test
    void shouldPostOnPostmanEcho() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("{\"args\": \"Vasya\", \"form\": 30}") // отправляемые данные (заголовки и query можно выставлять аналогично)
                .contentType("text/plain; charset=UTF-8")
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("{\"args\": \"Vasya\", \"form\": 33}"))
        ;
    }
}
