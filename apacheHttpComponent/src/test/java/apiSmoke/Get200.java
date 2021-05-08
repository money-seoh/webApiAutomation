package apiSmoke;

import apiBase.apiBaseClass;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get200 extends apiBaseClass {

    @Test
    public void onBaseEndpoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test
    public void onRateLimitEndpoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/rate_limit");
        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test
    public void onSearchReposEndpoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/search/repositories?q=java");
        httpResponse = httpClient.execute(get);
        System.out.println(httpResponse);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test
    public void onOrgSpecificRepoEndpoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/orgs/octokit/repos");
        httpResponse = httpClient.execute(get);
        System.out.println(httpResponse);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }
}
