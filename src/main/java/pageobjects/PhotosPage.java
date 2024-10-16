package pageobjects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class PhotosPage {
    private String jsonUrl = "https://jsonplaceholder.typicode.com/albums/1/photos";

    public PhotosPage(WebDriver driver) {
    }

    // Método para buscar o JSON da API
    public List<Map<String, Object>> getPhotosJson() throws IOException, InterruptedException {
        // Configurando o HttpClient para realizar a requisição
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(jsonUrl))
                .build();

        // Enviando a requisição e recebendo a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verifica se o status da resposta é 200 (OK)
        if (response.statusCode() == 200) {
            // Converte a resposta JSON em uma lista de mapas (cada mapa é um objeto JSON)
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.body(), new TypeReference<List<Map<String, Object>>>() {});
        } else {
            throw new RuntimeException("Erro ao obter dados JSON. Código de resposta: " + response.statusCode());
        }
    }

    // Método para buscar um item específico pelo ID
    public Map<String, Object> getPhotoById(int id) throws IOException, InterruptedException {
        List<Map<String, Object>> photosList = getPhotosJson();

        // Itera sobre a lista para encontrar o item com o ID específico
        for (Map<String, Object> photo : photosList) {
            if (photo.get("id").equals(id)) {
                return photo; // Retorna o objeto encontrado
            }
        }

        // Se o ID não for encontrado, lança uma exceção
        throw new RuntimeException("Foto com ID " + id + " não encontrada.");
    }
}
