package Demoblaze;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class DemoBlazeAPITests {

    @Test
    public void testLogin() {
        String baseUrl = "https://www.demoblaze.com";
        String loginEndpoint = "/api/login";

        String username = "username1";
        String password = "password1";

        // Assuming the API expects JSON for login
        String requestBody = "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }";

        RestAssured.given()
                .baseUri(baseUrl)
                .basePath(loginEndpoint)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200); // Replace with the expected status code
    }

    @Test
    public void testSignup() {
        String baseUrl = "https://www.demoblaze.com";
        String signupEndpoint = "/api/signup";

        String username = "test$214";
        String password = "p@ssw0rd";

        // Assuming the API expects JSON for signup
        String requestBody = "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }";

        RestAssured.given()
                .baseUri(baseUrl)
                .basePath(signupEndpoint)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200); // Replace with the expected status code
    }
}
