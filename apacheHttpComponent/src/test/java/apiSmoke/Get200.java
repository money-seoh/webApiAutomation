package apiSmoke;

import apiUtils.apiBaseClass;
import entities.Credentials;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class Get200 extends apiBaseClass {

    @BeforeMethod
    private void localSetup(Method testMethod){
        String value = testMethod.getAnnotation(Test.class).description();

        System.out.println("Starting test: "+testMethod.getName()+ " with description: \n**** " + value + " ****");
    }

    @Test(description = "Response code should be 200 on base endpoint of API.")
    public void onBaseEndpoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);

        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test(description = "Response code should be 200 on rate limit endpoint of API.")
    public void onRateLimitEndpoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/rate_limit");

        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test(description = "Response code should be 200 on search repository endpoint of API.")
    public void onSearchReposEndpoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/search/repositories?q=java");

        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test(description = "Response code should be 200 while accessing organisation specific repositories.")
    public void onOrgSpecificRepoEndpoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/orgs/octokit/repos");

        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test(description = "Response code should be 200 on while accessing private repository with credentials.")
    public void privateRepositoryWithToken() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/repos/" + Credentials.ID +"/"+Credentials.PRIVATE_REPO);
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);
        String json = EntityUtils.toString(httpResponse.getEntity());

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test(description = "Response code should be 200 on while accessing public repository with credentials.")
    public void publicRepoAccess() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/repos/" + Credentials.ID +"/"+Credentials.REPO);
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);
        String json = EntityUtils.toString(httpResponse.getEntity());


        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }
}
