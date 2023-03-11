package org.example;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class WeatherTest {

    public static final String API_KEY = "27b4103fa74d41ae8d183446231103";

    public static final String API_URL = "http://api.weatherapi.com/v1/current.json";

    @Test
    public void weatherTest() {

        ResponseBody responseBody = given()
                .when()
                .queryParam("key", API_KEY)
                .queryParam("q", "London")
                .get(API_URL)
                .getBody();

        responseBody.prettyPrint();
        JsonPath jsonPath = responseBody.jsonPath();
        String country = jsonPath.get("location.country");
        Assert.assertEquals("Turkey", country);

    }
}
