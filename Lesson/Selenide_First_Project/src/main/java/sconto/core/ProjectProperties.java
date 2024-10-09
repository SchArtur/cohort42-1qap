package sconto.core;

import java.io.IOException;
import java.util.Properties;

//Singleton
public class ProjectProperties {

    private static ProjectProperties projectProperties = null;
    private  Properties properties;

    private ProjectProperties() {
        properties = new Properties();
        try {
            properties.load(ProjectProperties.class.getClassLoader().getResourceAsStream("project.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ProjectProperties getInstance() {
        if (projectProperties == null) {
            projectProperties = new ProjectProperties();
        }
        return projectProperties;
    }

    public synchronized String getProperty(String key) {
        return this.properties.getProperty(key);
    }
}
