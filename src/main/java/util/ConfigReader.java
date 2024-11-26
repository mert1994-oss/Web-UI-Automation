package util;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = null;
    private final static String BASE_PATH = "./src/test/resources/configs/config-base.properties";
    private final static String OVERRIDE_PATH = "./src/test/resources/configs/config-override.properties";

    public static Properties getProperties() {

        if (properties == null) {
            properties = new Properties();
            properties.putAll(load(BASE_PATH));

            if (Files.exists(Paths.get(OVERRIDE_PATH))) {
                properties.putAll(load(OVERRIDE_PATH));
            }
        }
        return properties;
    }
    private static Properties load(String path) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}