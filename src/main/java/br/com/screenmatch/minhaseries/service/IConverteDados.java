package br.com.screenmatch.minhaseries.service;

public interface IConverteDados {
    //esta interface vai receber uma string do json
    <T> T obterDados(String json, Class<T> classe);
}
