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
 
    public static String uri() throws IOException,URISyntaxException, InterruptedException
    {
        Json mJson = new Json();
        String novaUri;
        Scanner scan;
        while(true)
        {

            scan = new Scanner(System.in);
            System.out.printf("Digite o nome da pessoa que quer buscar: ");
            String user = scan.nextLine(); 

            novaUri = "https://api.github.com/users/"+user.toLowerCase()+"/events";
            if (mJson.requisicao(novaUri).equals("404"))
            {
                System.out.println("Nome invalido! ");
                continue;
            }
            scan.close();
            break;
        }
        
        
        return novaUri;
 

    }
 
}
