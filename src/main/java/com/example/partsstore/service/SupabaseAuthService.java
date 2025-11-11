package com.example.partsstore.service;

import java.net.URI;
import java.net.http.*;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public class SupabaseAuthService {
    private static final String SUPABASE_URL = "https://uarcxsotrpdnwabpgjhp.supabase.co";
    private static final String SUPABASE_ANON_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InVhcmN4c290cnBkbndhYnBnamhwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjI4NjU5OTMsImV4cCI6MjA3ODQ0MTk5M30.nR2JZDVWD3wtdVYehE6ps6x35NClNBw1niNEA42qKGc";

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static boolean register(String email, String password) {
        try {
            JSONObject data = new JSONObject()
                    .put("email", email)
                    .put("password", password);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(SUPABASE_URL + "/auth/v1/signup"))
                    .header("apikey", SUPABASE_ANON_KEY)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(data.toString(), StandardCharsets.UTF_8))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200 || response.statusCode() == 201) {
                return true;
            } else {
                System.err.println("Ошибка регистрации: HTTP Status = " + response.statusCode());
                System.err.println("Тело ответа: " + response.body());
                return false;
            }
        } catch (Exception e) {
            System.err.println("Исключение при регистрации: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean login(String email, String password) {
        try {
            JSONObject data = new JSONObject()
                    .put("email", email)
                    .put("password", password);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(SUPABASE_URL + "/auth/v1/token?grant_type=password"))
                    .header("apikey", SUPABASE_ANON_KEY)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(data.toString(), StandardCharsets.UTF_8))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return true;
            } else {
                System.err.println("Ошибка входа: HTTP Status = " + response.statusCode());
                System.err.println("Тело ответа: " + response.body());
                return false;
            }
        } catch (Exception e) {
            System.err.println("Исключение при входе: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
