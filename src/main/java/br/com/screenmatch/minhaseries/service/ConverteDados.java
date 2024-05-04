package br.com.screenmatch.minhaseries.service;

import br.com.screenmatch.minhaseries.model.DadosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//classe utilizada para converter os dados retornados da API
// Jackson, precisamos de uma classe chamada ObjectMapper
// na classe converte-dados declaramos ObjectMapper mapper igual à new ObjectMapper()


//aqui implementamos a interface criada
public class ConverteDados implements IConverteDados{

    private ObjectMapper mapper = new ObjectMapper();

    // o método é implementado e tratado
    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
