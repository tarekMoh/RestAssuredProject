package PetDemo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class updateExistingPet {

    @Test
    public void test_03(){
        int petId = 1; // Replace with an existing pet ID
        String requestBody = "{ \"id\": " + petId + ", \"name\": \"updatedPet\", \"status\": \"sold\" }";

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .body("category.name", equalTo("updatedPet"));
    }
}
