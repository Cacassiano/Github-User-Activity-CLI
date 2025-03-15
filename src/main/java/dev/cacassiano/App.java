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
        if (events.length >=1) {
            
        
            int comentIssue = 0;
            int issueCriado = 0;
            int repoCriado = 0;
            int pushs = 0;
            for (GitHubEvent e : events) {
                if(e.type.equals("IssuesEvent"))
                {
                    if(e.payload.action.equals("opened"))
                    {
                        issueCriado++;
                    }
                }

                if(e.type.equals("PushEvent"))
                {
                    pushs++;
                }

                if(e.type.equals("IssueCommentEvent"))
                {
                    comentIssue++;
                }

                if(e.type.equals("CreateEvent"))
                {
                    if(e.payload.ref_type.equals("repository"))
                    {
                        repoCriado++;
                    }
                    
                    
                }
            }
            System.out.println("O usuario "+events[0].actor.login+":\n\tCriou "+repoCriado+" repositorios\n\tCriou "+issueCriado+" Issues\n\tComentou em "+comentIssue+" Issues\n\tE fez "+pushs+" Pushes este ano");
    
        } else{
            System.out.println("Não encontrei nenhuma atividade!");
        }
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
