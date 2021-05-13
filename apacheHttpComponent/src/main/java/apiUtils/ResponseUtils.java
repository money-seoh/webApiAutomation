package apiUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ResponseUtils {

    public static String getHeader(CloseableHttpResponse response, String headerName) {

        //Get all headers from response
        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());
        String returnHeader = "";

        //Check if header list contain desired header
        for (Header header : httpHeaders) {
            if(headerName.equalsIgnoreCase(header.getName())) {
                returnHeader = header.getValue();
            }
        }

        // If do not contain header in header list --- Throw exception
        if(returnHeader.isEmpty()) {
            throw new RuntimeException("Did not find any header with name '" + headerName + "' in response.");
        }

        // If found -- return the header
        return returnHeader;
    }

    public static String getHeaderUsingLambda(CloseableHttpResponse response, String headerName) {

        //Get all headers from response
        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        Header matchedHeader = httpHeaders.stream()
                .filter(header -> headerName.equalsIgnoreCase(header.getName()))
                .findFirst().orElseThrow(() -> new RuntimeException("Did not find any header with name '" + headerName + "' in response."));

        return matchedHeader.getValue();
    }

    public static boolean isHeaderPresent(CloseableHttpResponse response, String headerName) {
        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        return httpHeaders.stream()
                .anyMatch(header -> headerName.equals(header.getName()));
    }

    public static <T> T unmarshall(CloseableHttpResponse response, Class<T> classType) throws IOException {
        String jsonBody = EntityUtils.toString(response.getEntity());

        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonBody, classType);
    }
}
