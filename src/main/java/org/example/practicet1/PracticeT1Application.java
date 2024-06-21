package org.example.practicet1;

import org.example.practicet1.http.Requests;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeT1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PracticeT1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String testEmail = "NY-Konovalov-5@example.ru";
        Requests requests = new Requests();

        output("get-roles", requests.getRoles());
        output("sign-up", requests.signUp(
                "Коновалов",
                "Никита",
                testEmail,
                "Разработчик Java"));

        String response = requests.getCode(testEmail);
        String token = Encoder.encode(testEmail, response);

        output("get-code", requests.getCode(testEmail));
        output("encode", Encoder.encode(testEmail, response));
        output("set-status", requests.setStatus(token, "increased"));
    }

    public void output(String endpoint, String request) {
        System.out.printf("\n%s\n%s\n", endpoint, request);
    }
}
