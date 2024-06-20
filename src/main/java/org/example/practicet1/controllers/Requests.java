package org.example.practicet1.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.practicet1.entities.Candidate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requests {

    private static final String BASE_URL = "http://193.19.100.32:7000/api";

    public void getRoles() throws IOException {
        URL url = new URL(BASE_URL.concat("/get-roles"));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");

        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response);
        }
        else System.out.println("Ошибка " + responseCode);
    }

    public void signUp(String lastName, String firstName, String email, String role) throws IOException {
        Candidate candidate = new Candidate(
                lastName,
                firstName,
                email,
                role);
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(candidate);

        URL url = new URL(BASE_URL.concat("/sign-up"));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept", "application/json");

        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();

        os.write(requestBody.getBytes());

        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("Регистрация прошла успешно");
        }
        else System.out.println("Ошибка " + responseCode);
    }

    public void getCode(String email) throws IOException {
        URL url = new URL(BASE_URL.concat("/get-code?email=" + email));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");

        OutputStream os = con.getOutputStream();

        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("Регистрация прошла успешно");
        }
        else System.out.println("Ошибка " + responseCode);
    }
}

