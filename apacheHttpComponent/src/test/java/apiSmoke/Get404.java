package apiSmoke;

import apiUtils.apiBaseClass;
<<<<<<< HEAD
import entities.Credentials;
import org.apache.http.HttpHeaders;
=======
>>>>>>> parent of e1f2918 (basic learning complete)
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get404 extends apiBaseClass {

    @Test
    public void onInvalidEndPoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/invalidUrl");
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 404);
    }

<<<<<<< HEAD
    @Test
    public void privateRepositoryWithoutToken() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/repos/" + Credentials.ID +"/"+Credentials.PRIVATE_REPO);

        httpResponse = httpClient.execute(get);
        String json = EntityUtils.toString(httpResponse.getEntity());

        System.out.println(json);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 404);
    }

=======
>>>>>>> parent of e1f2918 (basic learning complete)
}
