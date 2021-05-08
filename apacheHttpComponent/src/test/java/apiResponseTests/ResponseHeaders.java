package apiResponseTests;

import apiBase.apiBaseClass;
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
        httpResponse = httpClient.execute(get);

        Header contentType = httpResponse.getEntity().getContentType();
        assertEquals(contentType.getValue(), "application/json; charset=utf-8");

        ContentType ct =  ContentType.getOrDefault(httpResponse.getEntity());
        assertEquals(ct.getMimeType(), "application/json");
    }

    @Test
    public void serverIsGithub() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        httpResponse = httpClient.execute(get);

        String headerValue = ResponseUtils.getHeader(httpResponse, "Server");

        assertEquals(headerValue, "GitHub.com");
    }

    @Test
    public void serverIsGithubUsingLambda() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        httpResponse = httpClient.execute(get);

        String headerValue = ResponseUtils.getHeaderUsingLambda(httpResponse, "Server");

        assertEquals(headerValue, "GitHub.com");
    }

    @Test
    public void xRateLimitIsSixty() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        httpResponse = httpClient.execute(get);

        String headerValue = ResponseUtils.getHeaderUsingLambda(httpResponse, "X-RateLimit-Limit");

        assertEquals(headerValue, "60");
    }

    @Test
    public void eTagIsPresentInHeader() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        httpResponse = httpClient.execute(get);

        boolean presence = ResponseUtils.isHeaderPresent(httpResponse, "ETag");

        assertTrue(presence);
    }
}
