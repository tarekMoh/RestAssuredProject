package PetDemo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class getPetTest {

    @Test
    public void test_01(){
        int petId = 1; // Replace with an existing pet ID

        RestAssured.given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/" + petId)
                .then()
                .statusCode(200)
                .body("id", equalTo(petId));

    }
}
