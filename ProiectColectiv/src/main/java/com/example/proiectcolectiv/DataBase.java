package com.example.proiectcolectiv;

import java.sql.*;

public class DataBase {
    private static String  url = "jdbc:mysql://localhost:3306/team-project";
    private static String user="root";
    private static String password="";
    public static void createTableUser(String tableName) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
                    + "  (userID           VARCHAR(255),"
                    + "   displayName            VARCHAR(255),"
                    + "   url          VARCHAR(255),"
                    + "   email          VARCHAR(255),"
                    + "   password           VARCHAR(255),"
                    + "   joinDate     DATE,"
                    + "   position VARCHAR(255))";


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String []args){
        createTableUser("User");
    }
}