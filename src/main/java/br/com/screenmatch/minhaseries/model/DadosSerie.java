package br.com.screenmatch.minhaseries.model;

//classe utilizada para serealizar os dados retornados pela API
//classe do tipo record, pois os dados não serão tratados
//escolhidos dados para modelagem conforme a API
//json alias daz um apelido para informar qual parâmetro será armazenado na variável
//json properties serve para serializaçã e deserialização

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;

//ignorar demais parametros não mapeados
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avalicao){
                        // @JsonProperty("imdbVotes") String votos) {
}

// é possível informar um array de nomes para pesquisa no retorno da API, caso utilize outras fontes