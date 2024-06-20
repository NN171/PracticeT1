package org.example.practicet1;

import org.example.practicet1.controllers.Requests;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Base64;

@SpringBootApplication
public class PracticeT1Application {

    public static void main(String[] args) {
        SpringApplication.run(PracticeT1Application.class, args);
        try {
            Requests requests = new Requests();
            requests.getRoles();
        }
        catch (IOException e) {
            e.getMessage();
        }
    }
}
