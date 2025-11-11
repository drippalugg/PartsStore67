package com.example.partsstore.service;

import java.net.URI;
import java.net.http.*;
import org.json.JSONObject;

public class SupabaseClient {
    public static final String SUPABASE_API_URL = "https://your-project-ref.supabase.co";
    public static final String SUPABASE_API_KEY = "public-anon-key";

    public static boolean register(String email, String password) {
        try {
            JSONObject data = new JSONObject().put("email", email).put("password", password);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(SUPABASE_API_URL + "/auth/v1/signup"))
                    .header("apikey", SUPABASE_API_KEY)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.statusCode() == 200;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public static boolean login(String email, String password) {
        try {
            JSONObject data = new JSONObject().put("email", email).put("password", password);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(SUPABASE_API_URL + "/auth/v1/token?grant_type=password"))
                    .header("apikey", SUPABASE_API_KEY)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.statusCode() == 200;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }
}
