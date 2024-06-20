package org.example.practicet1.http;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {
    public static String getUrlConnection(HttpURLConnection con) throws IOException {
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String responseString;
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            responseString = response.toString();

            return responseString;
        }
        else return "Ошибка " + responseCode;
    }

    public static HttpURLConnection httpConnectionCfg(URL url, String method) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod(method);
        con.setRequestProperty("Accept", "application/json");

        return con;
    }

    public static String postUrlConnection(HttpURLConnection con, Object copy) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(copy);

        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();

        os.write(requestBody.getBytes());

        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            return"Регистрация прошла успешно";
        }
        else return "Ошибка " + responseCode;
    }
}
