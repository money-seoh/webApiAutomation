package apiSmoke;

import io.restassured.response.ValidatableResponse;
import models.Product;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class apiTests {

    @Test()
    @Order(1)
    public void getCategories() {
        String endpoint = "http://localhost:81/api_testing/product/read.php";
        // To demo how to log response body content
        ValidatableResponse response = given().when().get(endpoint).then();
        response.log().body();

        // TO demo assertion for list of records in the response body
        given().
        when().get(endpoint).
        then().log().headers().
                assertThat().
                statusCode(200).
                header("Content-Type", equalTo("application/json; charset=UTF-8")).
                body("records.size()", greaterThanOrEqualTo(1)).
                body("records.id", everyItem(notNullValue())).
                body("records.name", everyItem(notNullValue())).
                body("records.description", everyItem(notNullValue())).
                body("records.price", everyItem(notNullValue())).
                body("records.category_id", everyItem(notNullValue())).
                body("records.category_name", everyItem(notNullValue())).
                body("records.id[0]",greaterThanOrEqualTo("15"));
    }

    @Test()
    @Order(2)
    public void getProduct() {
        String endpoint = "http://localhost:81/api_testing/product/read_one.php";

        //Another way to log body content
        given().queryParam("id", 9).
                when().get(endpoint).
                then().log().body();

        //To demo how to add assertion
        given().queryParam("id", 9).
                when().get(endpoint).
                then().
                assertThat().
                statusCode(200). // verifying response code
                body("id", equalTo("9")).  // Verifying multiple fields of response body
                body("name", equalTo("Polo Shirt")).
                body("description", equalTo("Our pre-shrunk organic cotton polo shirt is perfect for weekend activities," +
                        " lounging around the house, and casual days at the office. With its triple-stitched sleeves and waistband, our polo has maximum durability.")).
                body("price", equalTo("35.00")).
                body("category_id", equalTo("1")).
                body("category_name", equalTo("Active Wear - Men"));
    }

    @Test()
    @Order(3)
    public void createProduct() {
        String endpoint = "http://localhost:81/api_testing/product/create.php";
        Product bodyPayload = Product.createProduct("Test Product", "Test product description",
                12.02, 4);
        ValidatableResponse response = given().body(bodyPayload).when().post(endpoint).then();
        response.log().body();
    }

    @Test()
    @Order(4)
    public void updateProduct() {
        String endpoint = "http://localhost:81/api_testing/product/update.php";
        String bodyPayload = "{\n" +
                "\"id\": 19,\n" +
                "\"name\": \"Test Data --- updated \",\n" +
                "\"description\": \"a call to http://localhost:81/api_testing/product/create.php.\",\n" +
                "\"price\": 12,\n" +
                "\"category_id\": 4,\n" +
                "\"category_name\": \"Supplements\"\n" +
                "}";
        ValidatableResponse response = given().body(bodyPayload).when().put(endpoint).then();
        response.log().body();
    }

    @Test()
    @Order(5)
    public void deleteProduct() {
        String endpoint = "http://localhost:81/api_testing/product/delete.php";
        String bodyPayload = "{\n" +
                "\"id\": 19\n" +
                "}";
        ValidatableResponse response = given().body(bodyPayload).when().delete(endpoint).then();
        response.log().body();
    }
}
