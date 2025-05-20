package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

    public static Properties readProperties(Env env) {
        Properties properties = new Properties();
        File propFile = new File(System.getProperty("user.dir") + "/config/" + env + ".properties");

        try (FileReader fileReader = new FileReader(propFile)) {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    public static String getProperty(Env env, String key) {
        Properties properties = readProperties(env);
        return properties.getProperty(key.toUpperCase());
    }
}


