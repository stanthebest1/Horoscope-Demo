package com.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionManager {

    public static ConnectionManager connectionManager;
    public static Connection connection;


    private ConnectionManager(){

    }

    private ConnectionManager getConnectionManager(){
        if(connectionManager == null){
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }

    public static Connection getConnection(){
        if(connection == null){
            connection = connect();
        }
        return connection;
    }

    public static Connection connect(){

        try{
            Properties props = new Properties();
            FileReader fileReader = new FileReader("/Users/stan1/Documents/HoroscopeDemo" + "/src/main/resources/jdbc.properties");

            props.load(fileReader);

            String connectionURL;

            StringBuilder sb = new StringBuilder();
            sb.append("jdbc:postgresql://");
            sb.append(props.get("hostname"));
            sb.append(":");
            sb.append(props.get("port"));
            sb.append("/");
            sb.append(props.get("database"));

            connectionURL = sb.toString();

            String user = String.valueOf(props.getProperty("user"));
            String password = String.valueOf(props.getProperty("password"));

            System.out.println(connectionURL);

            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(connectionURL,user,password);
            System.out.println(connection.getClientInfo().toString() + "This is to confirm the connection was made");





        }catch (Exception e){
            System.out.println("Error in the connection: " + e.getMessage());

        }
        return connection;
    }
//    public static void main(String[] args){
//
//        connectionManager.getConnection();
//    }




}

