package org.example.practicet1;

import org.example.practicet1.http.Requests;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class PracticeT1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PracticeT1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String testEmail = "NY-Konovalov-4@example.ru";
        Requests requests = new Requests();

        System.out.println();
        System.out.println("get-roles\n" + requests.getRoles() + "\n");
        System.out.println("sign-up\n" + requests.signUp(
                "Коновалов",
                "Никита",
                testEmail,
                "Разработчик Java")
                + "\n");

        String response = requests.getCode(testEmail);
        String token = Encoder.encode(testEmail, response);

        System.out.println("get-code\n" + requests.getCode(testEmail) + "\n");
        System.out.println("encode\n" + Encoder.encode(testEmail, response) + "\n");
        System.out.print("set-status\n" + requests.setStatus(token, "increased") + "\n");
    }
}
