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

        statement.executeUpdate(sqlCreate);
        conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static void createTablePost(String tableName) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
                    + "  (postID           INTEGER,"
                    + "   userID            VARCHAR(255),"
                    + "   questionID         VARCHAR(255),"
                    + "   questionContent          VARCHAR(255),"
                    + "   likes           INTEGER,"
                    + "   dislikes     INTEGER,"
                    + "   date DATE,"
                    + "   category VARCHAR(255) )";

            statement.executeUpdate(sqlCreate);
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static void createTableComment(String tableName) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
                    + "  (commentID           INTEGER,"
                    + "   userID            VARCHAR(255),"
                    + "   parentPostID        INTEGER,"
                    + "   parentCommID         INTEGER,"
                    + "   content VARCHAR(255),"
                    + "   likes           INTEGER,"
                    + "   dislikes     INTEGER,"
                    + "   date DATE )";

            statement.executeUpdate(sqlCreate);
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static void createTableFavorite(String tableName) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
                    + "  (idFav           VARCHAR(255),"
                    + "   postID            INTEGER,"
                    + "   userID VARCHAR(255)"
                    +  ")";

            statement.executeUpdate(sqlCreate);
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static void createTableBadges(String tableName) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
                    + "  (idBadges          VARCHAR(255),"
                    + "   userID            VARCHAR(255),"
                    + "   badgeType VARCHAR(255)"
                    +  ")";

            statement.executeUpdate(sqlCreate);
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}