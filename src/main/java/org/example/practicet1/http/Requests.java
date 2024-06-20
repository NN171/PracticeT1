package org.example.practicet1.http;

import org.example.practicet1.entities.Candidate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.example.practicet1.http.Connection.*;

public class Requests {

    private static final String BASE_URL = "http://193.19.100.32:7000/api";

    public void getRoles() throws IOException {
        URL url = new URL(BASE_URL.concat("/get-roles"));
        HttpURLConnection connection = httpConnectionCfg(url, "GET");

        System.out.println(getUrlConnection(connection));
    }

    public void signUp(String lastName, String firstName, String email, String role) throws IOException {
        Candidate candidate = new Candidate(
                lastName,
                firstName,
                email,
                role);

        URL url = new URL(BASE_URL.concat("/sign-up"));
        HttpURLConnection connection = httpConnectionCfg(url, "POST");
        System.out.println(postUrlConnection(connection, candidate));
    }

    public void getCode(String email) throws IOException {
        URL url = new URL(BASE_URL.concat("/get-code?email=" + email));
        HttpURLConnection connection = httpConnectionCfg(url, "GET");

        System.out.println(getUrlConnection(connection));
    }


}

