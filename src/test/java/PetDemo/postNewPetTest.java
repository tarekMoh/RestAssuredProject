package PetDemo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

public class postNewPetTest {

    @Test
    public void test_02(){
        String requestBody = "{ \"id\": 1, \"name\": \"samplePet\", \"status\": \"available\" }";

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .body("category.name", equalTo("samplePet"));
    }
}
