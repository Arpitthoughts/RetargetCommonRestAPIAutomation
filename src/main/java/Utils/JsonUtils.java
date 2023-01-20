package Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static Map<String, Object> getJsonDataAsMap(String jsonFileName,String env) throws IOException {
        //String completeJsonFilePath = "D:\\RetargetCommonRestAPIAutomation\\src\\test\\Resources\\qa\\" + jsonFileName;

        String completeJsonFilePath = "./"+"/src/test/Resources/"+env+"/" + jsonFileName;
        Map<String,Object> data=objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<>(){});

        return data;
    }
}

