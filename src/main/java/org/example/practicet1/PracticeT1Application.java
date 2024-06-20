package org.example.practicet1;

import org.example.practicet1.http.Requests;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PracticeT1Application {

    public static void main(String[] args) {
        SpringApplication.run(PracticeT1Application.class, args);
        try {
            Requests requests = new Requests();
            requests.getRoles();
            //requests.signUp("Konovalov", "Nikita", "nikkonovaloff2017@gmail.com", "разработчик Java");
            requests.getCode("nikkonovaloff2017@gmail.com");
        }
        catch (IOException e) {
            e.getMessage();
        }
    }
}
