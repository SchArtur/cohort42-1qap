package core;

import java.io.IOException;
import java.util.Properties;

public class AppProperties {
    private static AppProperties appProperties=null;
    private Properties properties;

    private AppProperties() {
        properties=new Properties();
        try {
            properties.load(AppProperties.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static AppProperties getInstance(){
        if (appProperties==null){
            appProperties=new AppProperties();
        }
        return appProperties;
    }
    public synchronized String getProperty(String key){
        return this.properties.getProperty(key);
    }
}
