package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    private static Properties properties;

    public static void loadPropertiesFile() throws IOException {
        properties = new Properties();
        FileInputStream stream = new FileInputStream("src/test/resources/qa_configs.properties");
        properties.load(stream);
    }

    public static String getBrowserType(){
        try {
            loadPropertiesFile();
        } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Failed to load the file at path: src/test/resources/qa_configs.properties");
        }
        return properties.getProperty("browserType");
    }


}
