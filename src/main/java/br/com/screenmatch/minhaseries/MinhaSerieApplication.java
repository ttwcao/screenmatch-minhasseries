package br.com.screenmatch.minhaseries;

import br.com.screenmatch.minhaseries.model.DadosSerie;
import br.com.screenmatch.minhaseries.service.ConsumoApi;
import br.com.screenmatch.minhaseries.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//necessário informar que será usando linha de comando, implementar a interface
public class MinhaSerieApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MinhaSerieApplication.class, args);
	}

	//por ser uma interface implementada é preciso implementar também o método run
	// run, terá o mesmo papel do método main em O.O.
	@Override
	public void run(String... args) throws Exception {
		//instanciar a classe para uso
		ConsumoApi consumoApi = new ConsumoApi();

		//variavel que recebe o endereço
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=bd2ee099");
		//imprimir o resultado da consulta
		System.out.println(json);

		/*uma vez implementado serviço de consumir uma API, é possível utiliza para qualquer
		* tipo de API, exemplo abaixo
		*json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		*System.out.println(json);
		*/

		//instaciado conversor
		ConverteDados conversor = new ConverteDados();

		//transformados para DadosSerie
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}
}
