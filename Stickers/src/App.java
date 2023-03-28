import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // fazer uma conexão HTTP e importar a API
        String urlTopMovies = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI enderecoTopMovies = URI.create(urlTopMovies);
        HttpClient clientTopMovies = HttpClient.newHttpClient();
        HttpRequest requestTopMovies = HttpRequest.newBuilder(enderecoTopMovies).GET().build();
        HttpResponse<String> responseTopMovies = clientTopMovies.send(requestTopMovies, BodyHandlers.ofString());
        String bodyTopMovies = responseTopMovies.body();

        String urlPopularMovies = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI enderecoPopularMovies = URI.create(urlPopularMovies);
        HttpClient clientPopularMovies = HttpClient.newHttpClient();
        HttpRequest requestPopularMovies = HttpRequest.newBuilder(enderecoPopularMovies).GET().build();
        HttpResponse<String> responsePopularMovies = clientPopularMovies.send(requestPopularMovies, BodyHandlers.ofString());
        String bodyPopularMovies = responsePopularMovies.body();

        String urlPopularTV = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
        URI enderecoPopularTV = URI.create(urlPopularTV);
        HttpClient clientPopularTV = HttpClient.newHttpClient();
        HttpRequest requestPopularTV = HttpRequest.newBuilder(enderecoPopularTV).GET().build();
        HttpResponse<String> responsePopularTV = clientPopularTV.send(requestPopularTV, BodyHandlers.ofString());
        String bodyPopularTV = responsePopularTV.body();
        
        // extrair os dados de interesse (titulo, poster, rating)
        JsonParser parserTopMovies = new JsonParser();
        List<Map<String, String>> listTopMovies = parserTopMovies.parse(bodyTopMovies);

        JsonParser parserPopularMovies = new JsonParser();
        List<Map<String, String>> listPopularMovies = parserPopularMovies.parse(bodyPopularMovies);

        JsonParser parserPopularTV = new JsonParser();
        List<Map<String, String>> listPopularTV = parserPopularTV.parse(bodyPopularTV);

        // exibir e manipular os dados
        System.out.println("#####################################");
        System.out.println("\u001b[30m \u001b[47mTopMovies\u001b[m");
        System.out.println("#####################################");

        for (Map<String,String> filme : listTopMovies) {
            System.out.println("\u001b[1m" + filme.get("title") + "\u001b[m");
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            double rank = Double.parseDouble(filme.get("imDbRating"));
            int starNumber = (int) rank;
            for (int index = 0; index <= starNumber; index++) {
                System.out.print("⭐");
            }
            System.out.println("\n");
        }

        System.out.println("#####################################");
        System.out.println("\u001b[30m \u001b[47mPopularMovies\u001b[m");
        System.out.println("#####################################");

        for (Map<String,String> filme : listPopularMovies) {
            System.out.println("\u001b[1m" + filme.get("title") + "\u001b[m");
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            double rank = Double.parseDouble(filme.get("imDbRating"));
            int starNumber = (int) rank;
            for (int index = 0; index <= starNumber; index++) {
                System.out.print("⭐");
            }
            System.out.println("\n");
        }

        System.out.println("#####################################");
        System.out.println("\u001b[30m \u001b[47mPopularTV\u001b[m");
        System.out.println("#####################################");

        for (Map<String,String> filme : listPopularTV) {
            System.out.println("\u001b[1m" + filme.get("title") + "\u001b[m");
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            double rank = Double.parseDouble(filme.get("imDbRating"));
            int starNumber = (int) rank;
            for (int index = 0; index <= starNumber; index++) {
                System.out.print("⭐");
            }
            System.out.println("\n");
        }
    }
}
