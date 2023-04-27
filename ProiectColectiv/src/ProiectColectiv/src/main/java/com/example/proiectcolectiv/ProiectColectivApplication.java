package com.example.proiectcolectiv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;

@SpringBootApplication
public class ProiectColectivApplication {

    public static void main( String [] args)
    {
        SpringApplication.run(ProiectColectivApplication.class, args);
        DataBase.createTableUser("User");
        DataBase.createTableFavorite("Favorite");
        DataBase.createTableBadges("Badges");
        DataBase.createTablePost("Post");
        DataBase.createTableComment("Comment");
    }

}
