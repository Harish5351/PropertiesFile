package test.PropertiesFile;

import test.java.StepDefinition.Steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
    public static void main(String[] args) throws IOException {
        getProperties();
    }

    public static void getProperties() throws IOException{
        Properties prop = new Properties();
        InputStream input = new FileInputStream("src/test/java/test/PropertiesFile/config.properties");
        prop.load(input);
        String browser = prop.getProperty("browser");
        System.out.println(browser);
        String url = prop.getProperty("Url");
        System.out.println(url);
        Steps.browserName = browser;
        Steps.URL = url;
    }
}
