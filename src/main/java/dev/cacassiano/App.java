package dev.cacassiano;

import java.io.IOException;
import java.net.URISyntaxException;

public class App 
{
    public static void main( String[] args ) throws IOException,URISyntaxException, InterruptedException
    {
        String uri = "https://api.github.com/users/cacassiano/events";
        Json meuJson = new Json();
        GitHubEvent[] events = meuJson.criarObjetoEventos(uri);
        
        System.out.println(events[0].id);
    }   
}
