import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHTTP {
    
    public String buscaDados(String url) {
        
        try {

            URI enderecoConteudo = URI.create(url);
            HttpClient clientConteudo = HttpClient.newHttpClient();
            HttpRequest requestConteudo = HttpRequest.newBuilder(enderecoConteudo).GET().build();
            HttpResponse<String> responseConteudo = clientConteudo.send(requestConteudo, BodyHandlers.ofString());
            String bodyConteudo = responseConteudo.body();
    
            return bodyConteudo;
                
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);       
        }


    }

}
