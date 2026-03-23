package com.automation.TestUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TestDataUtils {
    public String getPath(String jsondata)
    {
        return System.getProperty("user.dir")+"\\src\\test\\java\\com\\automation\\data\\"+jsondata+".json";

    }

    public String getJsonString(String filename, String key) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = mapper.readValue(new File(filename), Map.class);
        return (String) data.get(key);
    }
}
