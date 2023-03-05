package org.example;

import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ExampleTest {

    @Test
    public void firstTest() {
        Assert.assertNotEquals("Two values are equal! ", 4, 2 + 2);
    }

    @Test
    public void statusCodeTest() {
        given()
                .when()
                .get("https://www.google.com")
                .then()
                .statusCode(200);
    }

    @Test
    public void detailedTest(){
        ResponseBody responseBody = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .getBody();
        responseBody.prettyPrint();
        Assert.assertTrue("Response body does not contain the expected value !", responseBody.asString().contains("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }

    @Test
    public void responseTimeTest(){
         given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .time(Matchers.lessThan(2000L));
    }

}
