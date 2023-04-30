package com.example.proiectcolectiv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProiectColectivApplication {

    public static void main( String [] args)
    {
        SpringApplication.run(ProiectColectivApplication.class, args);
         System.out.println(5);
         DataBase.createTableUser("User");
         DataBase.createTablePost("Post");
         DataBase.createTableFavorite("Favorite");
         DataBase.createTableBadges("Badges");
         DataBase.createTableComment("Comment");
         DataBase.createTableQuestionLabel("Label");
    }

}
