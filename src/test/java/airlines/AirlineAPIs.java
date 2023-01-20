package airlines;

import RestAssutils.RestUtils;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {

    public Response createAirline(Map<String, Object> requestPayload){
      String endPoint= (String) Base.dataFromJsonFile.get("createAirLineEndpoint");
        Response response =  RestUtils.performPost(endPoint,requestPayload,new HashMap<>());
        return response;
    }
}
