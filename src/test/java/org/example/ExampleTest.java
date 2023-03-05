package org.example;

import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.junit.*;

import static io.restassured.RestAssured.given;

public class ExampleTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Using @BeforeClass , executed before all test cases ");
    }

    @Before
    public void m2() {
        System.out.println("Using @Before annotations ,executed before each test cases ");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Using @AfterClass ,executed after all test cases");
    }

    @After
    public void after() {
        System.out.println("Using @After ,executed after each test cases");
    }

    @Ignore
    public void ignored() {
        System.out.println("Using @Ignore , this execution is ignored");
    }

    @Test
    @Ignore
    public void firstTest() {
        Assert.assertNotEquals("Two values are equal! ", 4, 2 + 2);
    }

    @Test(timeout = 100)
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
