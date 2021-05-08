package apiResponseTests;

import apiBase.apiBaseClass;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class BodyTestWithSimpleMap extends apiBaseClass {

    @Test
    public void returnsCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/andrejss88");

        httpResponse = httpClient.execute(get);

        String jsonBody = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(jsonBody);
    }
}
