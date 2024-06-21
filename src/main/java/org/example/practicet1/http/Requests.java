package org.example.practicet1.http;

import org.example.practicet1.entities.Candidate;
import org.example.practicet1.entities.Status;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.example.practicet1.http.Connection.*;

public class Requests {

    private static final String BASE_URL = "http://193.19.100.32:7000/api";

    public String getRoles() throws IOException {
        URL url = new URL(BASE_URL.concat("/get-roles"));
        HttpURLConnection connection = httpConnectionCfg(url, "GET");

        return getUrlConnection(connection);
    }

    public String signUp(String lastName, String firstName, String email, String role) throws IOException {
        Candidate candidate = new Candidate(
                lastName,
                firstName,
                email,
                role);

        URL url = new URL(BASE_URL.concat("/sign-up"));
        HttpURLConnection connection = httpConnectionCfg(url, "POST");

        return postUrlConnection(connection, candidate);
    }

    public String getCode(String email) throws IOException {
        URL url = new URL(BASE_URL.concat("/get-code?email=".concat(email)));
        HttpURLConnection connection = httpConnectionCfg(url, "GET");

        return getUrlConnection(connection);
    }

    public String setStatus(String token, String textStatus) throws IOException {
        Status status = new Status(token, textStatus);
        URL url = new URL(BASE_URL.concat("/set-status"));
        HttpURLConnection connection = httpConnectionCfg(url, "POST");

        return postUrlConnection(connection, status);
    }
}
