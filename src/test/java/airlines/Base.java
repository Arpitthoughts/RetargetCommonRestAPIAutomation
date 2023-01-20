package airlines;

import Utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class Base {
    public static Map<String, Object> dataFromJsonFile;
static {
    String env=System.getProperty("env") !=null ? System.getProperty("env")  :"qa";

    try {
         dataFromJsonFile= JsonUtils.getJsonDataAsMap("airlinesApiData.json",env);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
}
