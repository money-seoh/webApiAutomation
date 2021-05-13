package apiSmoke;

import apiUtils.apiBaseClass;
import entities.Credentials;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get200 extends apiBaseClass {

    @Test
    public void onBaseEndpoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test
    public void onRateLimitEndpoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/rate_limit");
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test
    public void onSearchReposEndpoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/search/repositories?q=java");
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test
    public void onOrgSpecificRepoEndpoint() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/orgs/octokit/repos");
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test
    public void privateRepositoryWithToken() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/repos/" + Credentials.ID +"/"+Credentials.PRIVATE_REPO);
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);
        String json = EntityUtils.toString(httpResponse.getEntity());

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test
    public void publicRepoAccess() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/repos/" + Credentials.ID +"/"+Credentials.REPO);
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);
        String json = EntityUtils.toString(httpResponse.getEntity());

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }
}
