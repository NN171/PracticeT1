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
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }

            br.close();
            responseString = response.toString();

            return responseString.replace("\"", "");
        } else return "Ошибка " + responseCode;
    }

    public static HttpURLConnection httpConnectionCfg(URL url, String method) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod(method);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        return con;
    }

    public static String postUrlConnection(HttpURLConnection con, Object copy) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(copy);

        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        byte[] input = requestBody.getBytes();
        os.write(input);
        os.flush();
        os.close();

        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        } else {
            return "Ошибка " + responseCode;
        }
    }
}
