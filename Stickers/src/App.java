import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // fazer uma conexão HTTP e importar a API
        
        // String urlConteudo = "https://api.nasa.gov/planetary/apod?api_key=3mZoDwnbRMyGoO95prxsrWovVrwv9L2mj9XCCr9G&start_date=2022-05-17&end_date=2022-05-21";
        // ExtratorDeConteudo extrator = new NasaExtrator();

        // String urlConteudo = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String urlConteudo = "http://localhost:8080/Linguagens";
        ExtratorDeConteudo extrator = new IMDBExtrator();

        ClienteHTTP http = new ClienteHTTP();
        String json = http.buscaDados(urlConteudo);
        
        // exibir e manipular os dados
        System.out.println("\u001b[30m \u001b[47mStickers\u001b[m");
        List<conteudo> conteudos = extrator.extraiConteudos(json);

        for (int i = 0; i < 4; i++) {
            conteudo conteudo = conteudos.get(i);
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "Imersão-Java\\Imersao-Java\\Stickers\\saida\\" + conteudo.getTitulo().replace(":", "-")  + ".png";
            String textoString = conteudo.getTitulo();
            StickerGenerator gerador = new StickerGenerator();
            gerador.create(inputStream, nomeArquivo, textoString);
            System.out.println("\u001b[1m" + conteudo.getTitulo() + "\u001b[m");
            }
            System.out.println("\n");
        }
}
