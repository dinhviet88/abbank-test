package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiClient {

    private static final String BASE_URL = "https://api.github.com";

    public static Response get(String endpoint) {
        return given()
                .when()
                .get(BASE_URL + endpoint)
                .then()
                .extract()
                .response();
    }
}
