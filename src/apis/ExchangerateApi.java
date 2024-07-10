package apis;

import com.google.gson.GsonBuilder;
import excecoes.ConectaApiExchangerateException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ExchangerateApi {

    private String API_KEY = "SUA_API_KEY";

    public Double getCotacao(String moedaBase, String moedaAConverter) {

        URI uri = URI.create(
                String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", API_KEY, moedaBase));


        String json = conectaApiExchangerate(uri);

        Map<String, Double> conversoes = new GsonBuilder()
                .create()
                .fromJson(json, TaxasConversao.class)
                .taxasConversoes();

        return conversoes.get(moedaAConverter);

    }

    private String conectaApiExchangerate(URI uri) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new ConectaApiExchangerateException("Erro ao conectar a API da Exchangerate: " + e.getMessage());
        }
    }

}
