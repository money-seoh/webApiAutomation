package apiSmoke;

import apiBase.apiBaseClass;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get404 extends apiBaseClass {

    @Test
    public void onInvalidEndPoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/invalidUrl");
        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 404);
    }

}
