package dev.cacassiano;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Json
{
    public GitHubEvent[] criarObjetoEventos(String uri) throws IOException,URISyntaxException, InterruptedException
    {
        String resposta = requisicao(uri);
        // criando o mapper
        ObjectMapper map = new ObjectMapper();
        // cria uma lista de objetos a partir de uma string [{...}]
        GitHubEvent[] json = map.readValue(resposta, GitHubEvent[].class);

        return json;
    }

    public String requisicao(String uri)throws IOException,URISyntaxException, InterruptedException
    {
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest req = HttpRequest.newBuilder()
        .uri(new URI(uri))
        .GET()
        .build();

        // REquisicao feita
        HttpResponse resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        if (resp.statusCode() == 404)
        {
            return "404";
        }
        return resp.body().toString();
    }
}
