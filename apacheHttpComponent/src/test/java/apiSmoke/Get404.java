package apiSmoke;

import apiUtils.apiBaseClass;
import entities.Credentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class Get404 extends apiBaseClass {

    @BeforeMethod
    private void localSetup(Method testMethod){
        String value = testMethod.getAnnotation(Test.class).description();

        System.out.println("Starting test: "+testMethod.getName()+ " with description: \n**** " + value + " ****");
    }

    @Test(description = "Response code should be 404 on invalid endpoint of API.")
    public void onInvalidEndPoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/invalidUrl");

        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 404);
    }

    @Test(description = "Response code should be 404 if accessing private repository without authentication.")
    public void privateRepositoryWithoutToken() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/repos/" + Credentials.ID +"/"+Credentials.PRIVATE_REPO);

        httpResponse = httpClient.execute(get);
        String json = EntityUtils.toString(httpResponse.getEntity());

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 404);
    }
}
