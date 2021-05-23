package apiSmoke;

import apiUtils.apiBaseClass;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class Get401 extends apiBaseClass {

    @BeforeMethod
    private void localSetup(Method testMethod){
        String value = testMethod.getAnnotation(Test.class).description();

        System.out.println("Starting test: "+testMethod.getName()+ " with description: \n**** " + value + " ****");
    }

    @DataProvider
    private Object[][] endpoints() {
        return new Object[][]{
                {"/user"},
                {"/user/followers"},
                {"/notifications"},
        };
    }

    @Test(dataProvider = "endpoints", description = "Endpoints response code 401 if unauthenticated.")
    public void onUserEndPoint(String endpoint) throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT.concat(endpoint));

        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 401);
    }
}
