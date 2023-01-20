package airlines;

import Utils.JsonUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import RestAssutils.RestUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AirlineTests extends AirlineAPIs{

    @Test
    public void createAirlineTest() throws IOException {
        System.out.println(System.getProperty("env"));


Map<String,Object> requestPayload=Payloads.getCreateAirlinePayloadFromMap("637392","British Lankan Airways","UK",
        "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png","from UK",
        "London UK", "www.british airways.com","1997");

     Response response=createAirline(requestPayload);
     Assert.assertEquals(response.getStatusCode(),200);

    }




}
