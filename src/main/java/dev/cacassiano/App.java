package dev.cacassiano;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
    public static void main( String[] args ) throws IOException,URISyntaxException, InterruptedException
    {
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest req = HttpRequest.newBuilder()
        .uri(new URI("https://api.github.com/users/cacassiano/events"))
        .GET()
        .build();

        // REquisicao feita
        HttpResponse resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        String json = resp.body();
    }   
}
