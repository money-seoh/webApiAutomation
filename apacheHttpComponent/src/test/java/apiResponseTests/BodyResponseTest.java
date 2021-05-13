package apiResponseTests;

import apiUtils.ResponseUtils;
import apiUtils.apiBaseClass;
import entities.*;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class BodyResponseTest extends apiBaseClass {

    @Test
    public void returnsCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/"+Credentials.ID);
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        User user = ResponseUtils.unmarshall(httpResponse, User.class);

        assertEquals(user.getLogin(), Credentials.ID);
    }

    @Test
    public void returnsCorrectId() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/"+Credentials.ID);
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        User user = ResponseUtils.unmarshall(httpResponse, User.class);

        assertEquals(user.getId(), "3132767");
    }

    @Test
    public void notFoundMessageIsCorrect() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/invalidUrl");
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        NotFound notFound = ResponseUtils.unmarshall(httpResponse, NotFound.class);

        assertEquals(notFound.getMessage(), "Not Found");
    }

    @Test
    public void correctRateLimitIsSet() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/rate_limit");
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        RateLimit rateLimit = ResponseUtils.unmarshall(httpResponse, RateLimit.class);

        assertEquals(rateLimit.getCoreLimit(), 5000);
    }

    @Test
    public void correctSearchLimitIsSet() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/rate_limit");
        get.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        httpResponse = httpClient.execute(get);

        RateLimit rateLimit = ResponseUtils.unmarshall(httpResponse, RateLimit.class);

        assertEquals(rateLimit.getSearchLimit(), "30");
    }
}
