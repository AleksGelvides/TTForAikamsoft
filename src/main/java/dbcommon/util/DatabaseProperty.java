package dbcommon.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import file_manager.IOManager;

import java.io.File;
import java.io.IOException;

public class DatabaseProperty {

    private static final String propertyPath = "src/main/resources/db-connection.yaml";

    private String DB_URL;
    private String DB_USER;
    private String DB_PASS;

    public DatabaseProperty(String DB_URL, String DB_USER, String DB_PASS){
        this.DB_URL = DB_URL;
        this.DB_USER = DB_USER;
        this.DB_PASS = DB_PASS;
    }

    public DatabaseProperty(){}

    public static DatabaseProperty getConfigFile() {
        try {
            File file = new File(propertyPath);
            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            DatabaseProperty prop = om.readValue(file, DatabaseProperty.class);
            return prop;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public String getDB_USER() {
        return DB_USER;
    }

    public String getDB_PASS() {
        return DB_PASS;
    }

    public void setDB_URL(String DB_URL) {
        this.DB_URL = DB_URL;
    }

    public void setDB_USER(String DB_USER) {
        this.DB_USER = DB_USER;
    }

    public void setDB_PASS(String DB_PASS) {
        this.DB_PASS = DB_PASS;
    }
}
