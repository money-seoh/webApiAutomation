package apiUtils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class apiBaseClass {

    protected final static String BASE_ENDPOINT = "https://api.github.com";
    protected CloseableHttpClient httpClient;
    protected CloseableHttpResponse httpResponse;

    @BeforeMethod
    protected void setup() {
        System.out.println("Running tests for "+this.getClass().toString() + " class.");
        httpClient = HttpClientBuilder.create().build();
    }

    @AfterMethod
    protected void tearDown() throws IOException {
        httpClient.close();
        httpResponse.close();
    }

}
