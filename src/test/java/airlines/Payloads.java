package airlines;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Payloads {

    public static String getCreateAirlinePayloadFromString(int id, String name, String country, String logo, String slogan,
                                                           String head_quaters, String website, String established){

        String Payload="{\n" +
                "    \"id\": "+id+",\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"country\": \""+country+"\",\n" +
                "    \"logo\": \""+logo+"\",\n" +
                "    \"slogan\": \""+slogan+"\",\n" +
                "    \"head_quaters\": \""+head_quaters+"\",\n" +
                "    \"website\": \""+website+"\",\n" +
                "    \"established\": \""+established+"\"\n" +
                "}";

        return Payload;
    }


    public static Map<String, Object> getCreateAirlinePayloadFromMap(String id, String name, String country, String logo, String slogan,
                                                                     String head_quaters, String website, String established){

        Map<String, Object> payload= new HashMap<String,Object>();
        payload.put("id",id);
        payload.put("name",name);
        payload.put("country",country);
        payload.put("logo",logo);
        payload.put("slogan",slogan);
        payload.put("head_quaters",head_quaters);
        payload.put("website",website);
        payload.put("established",established);

        return payload;
    }
}
