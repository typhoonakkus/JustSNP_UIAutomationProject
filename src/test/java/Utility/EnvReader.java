package Utility;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EnvReader {

    private static JSONObject envData;

    public static void loadEnv(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            envData = new JSONObject(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return envData.getJSONArray("values")
                .toList()
                .stream()
                .filter(item -> ((java.util.Map) item).get("key").equals(key))
                .map(item -> ((java.util.Map) item).get("value").toString())
                .findFirst()
                .orElse(null);
    }
}
