package apiResponseTests;

import apiUtils.apiBaseClass;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;
import apiUtils.ResponseUtils;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResponseHeaders extends apiBaseClass {

    @Test
    public void contentTypeIsJson() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        Header contentType = httpResponse.getEntity().getContentType();
        assertEquals(contentType.getValue(), "application/json; charset=utf-8");

        ContentType ct =  ContentType.getOrDefault(httpResponse.getEntity());
        assertEquals(ct.getMimeType(), "application/json");
    }

    @Test
    public void serverIsGithub() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        String headerValue = ResponseUtils.getHeader(httpResponse, "Server");

        assertEquals(headerValue, "GitHub.com");
    }

    @Test
    public void serverIsGithubUsingLambda() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        String headerValue = ResponseUtils.getHeaderUsingLambda(httpResponse, "Server");

        assertEquals(headerValue, "GitHub.com");
    }

    @Test
    public void xRateLimitIsSixty() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        String headerValue = ResponseUtils.getHeaderUsingLambda(httpResponse, "X-RateLimit-Limit");

        assertEquals(headerValue, "5000");
    }

    @Test
    public void eTagIsPresentInHeader() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        boolean presence = ResponseUtils.isHeaderPresent(httpResponse, "ETag");

        assertTrue(presence);
    }
<<<<<<< HEAD

    @Test
    public void correctOptionsPresentInHeader() throws IOException {
        String header = "access-control-allow-methods";
        String expectedValue = "GET, POST, PATCH, PUT, DELETE";
        HttpOptions get = new HttpOptions(BASE_ENDPOINT+"/users/"+Credentials.ID);
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        String actualValue = ResponseUtils.getHeaderUsingLambda(httpResponse, header);

        int actualStatus = httpResponse.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 204);

        assertEquals(actualValue, expectedValue);
    }
=======
>>>>>>> parent of e1f2918 (basic learning complete)
}
