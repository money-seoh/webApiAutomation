package apiSmoke;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class apiTests {

    @Test
    public void getCategories() {
        String endpoint = "http://localhost:81/api_testing/product/read.php";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void getProduct() {
        String endpoint = "http://localhost:81/api_testing/product/read_one.php";
        var response = given().queryParam("id", 18).
                        when().get(endpoint).
                        then();
        response.log().body();
    }

    @Test
    public void createProduct() {
        String endpoint = "http://localhost:81/api_testing/product/create.php";
        String bodyPayload = "{\n" +
                "\"name\": \"Test Data\",\n" +
                "\"description\": \"a call to http://localhost:81/api_testing/product/create.php.\",\n" +
                "\"price\": 10,\n" +
                "\"category_id\": 4\n" +
                "}";
        var response = given().body(bodyPayload).when().post(endpoint).then();
        response.log().body();
    }

    @Test
    public void updateProduct() {
        String endpoint = "http://localhost:81/api_testing/product/update.php";
        String bodyPayload = "{\n" +
                "\"id\": \"19\",\n" +
                "\"name\": \"Test Data --- updated \",\n" +
                "\"description\": \"a call to http://localhost:81/api_testing/product/create.php.\",\n" +
                "\"price\": 12,\n" +
                "\"category_id\": 4,\n" +
                "\"category_name\": \"Supplements\"\n" +
                "}";
        var response = given().body(bodyPayload).when().put(endpoint).then();
        response.log().body();
    }

    @Test
    public void deleteProduct() {
        String endpoint = "http://localhost:81/api_testing/product/delete.php";
        String bodyPayload = "{\n" +
                "\"id\": 19\n" +
                "}";
        var response = given().body(bodyPayload).when().delete(endpoint).then();
        response.log().body();
    }
}
