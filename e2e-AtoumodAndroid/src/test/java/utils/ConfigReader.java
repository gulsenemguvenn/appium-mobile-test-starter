package utils;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("configuration.properties")) {

            if (input == null) {
                throw new RuntimeException("configuration.properties not found under src/test/resources");
            }
            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration.properties", e);
        }
    }

    private ConfigReader() {}

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Missing config key: " + key);
        }
        return value.trim();
    }
}
