package PetDemo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class deletePet {

    @Test
    public void test_4(){
        int petId = 1; // Replace with an existing pet ID

        RestAssured.given()
                .when()
                .delete("https://petstore.swagger.io/v2/pet/" + petId)
                .then()
                .statusCode(200);
    }
}
