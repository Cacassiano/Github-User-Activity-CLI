package dev.cacassiano;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
public class App 
{
    public static void main( String[] args ) throws IOException,URISyntaxException, InterruptedException
    {
        
        String uri = uri();
        Json meuJson = new Json();
        GitHubEvent[] events = meuJson.criarObjetoEventos(uri);
        
        System.out.println(events[0].id);
        
    }   

    public static String uri()
    {
        Scanner scan = new Scanner();
        System.out.printf("Digite o nome da pessoa que quer buscar: ");
        String user = scan.nextLine(); 

        return "https://api.github.com/users/"+user+"/events";
    }
}
