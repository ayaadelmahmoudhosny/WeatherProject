package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    public String readConfigValue(String KeyName) throws IOException {

        Properties prop = new Properties();
        String path = System.getProperty("user.dir")
                + "/src/test/resources/deviceConfiguration.properties";
        FileInputStream fis = new FileInputStream(path);
        prop.load(fis);
        return prop.getProperty(KeyName);
    }
}
