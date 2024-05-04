package br.com.screenmatch.minhaseries.service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    //método público que retorna uma string com os dados da consulta na API
    public String obterDados(String endereco) {


        //pode ser considerado o cliente
        HttpClient client = HttpClient.newHttpClient();

        // onde criamos uma URI para especificar para qual endereço faremos a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;

        //tratamento das exceções
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //devolver o retorno da string
        String json = response.body();
        return json;
    }
}
