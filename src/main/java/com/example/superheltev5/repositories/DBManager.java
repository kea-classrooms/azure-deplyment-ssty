package com.example.superheltev5.repositories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    private static Connection con = null;

    public static Connection getConnection(){
        if (con != null) return con;
        String user = null, password= null, url = null;
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")){
            Properties properties = new Properties();
            properties.load(input);
            url = properties.getProperty("spring.datasource.url");
            user = properties.getProperty("spring.datasource.username");
            password = properties.getProperty("spring.datasource.password");
        }catch(IOException ex){
            ex.printStackTrace();
        }
        try{
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
