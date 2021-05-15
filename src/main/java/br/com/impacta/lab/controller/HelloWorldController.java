package br.com.impacta.lab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atividades")
public class HelloWorldController {

	@GetMapping("hello")
	public ResponseEntity<String> helloWorld(@RequestParam(name="nome", required=false) String nome) {
		//a variável nome, contém o valor passado no browser na sua chamada
		//Exemplo http://localhost:8080/atividades/hello?nome=felipe
		//Considerando o exemplo acima a variável nome virá preenchida com o texto "felipe"
		
		//Considerando a dica acima, implemente seu código para que o programa retorne a 
		//palavra Hello world concatenada com o nome.
		//Exmeplo de resposta: Hello world felipe !
		String retorno = new String("Hello world " + nome + "!");
	
		return ResponseEntity.ok(retorno);
	}

	@GetMapping("numeros")
	public ResponseEntity<String> helloNumero(@RequestParam(name="numero", required=false) int numero) {
		//Exemplo http://localhost:8080/atividades/numeros?numero=15

		int numeroHardCode = 50;
	
		return ResponseEntity.ok(numero != numeroHardCode ? "Diferente": "Igual" );
	}

	@GetMapping("numerosif")
	public ResponseEntity<String> helloNumeroIf(@RequestParam(name="numero", required=false) int numero) {
		//Exemplo http://localhost:8080/atividades/numeros?numero=15
				
		int numeroHardCode = 50;
		var retorno = "Diferente";

		if (numeroHardCode == numero){
			retorno = "Igual";
		}
		return ResponseEntity.ok(retorno);
	}

	@GetMapping("numeroscondiicionalif")
	public ResponseEntity<String> helloNumeroCondicionalif(@RequestParam(name="numero", required=false) int numero) {
		//http://localhost:8080/atividades/helloNumeroCondicionalif?numero=15
				
		int numeroHardCode = 50;
		var retorno = new String();

		if (numeroHardCode != numero && numeroHardCode > numero){
			retorno = "Número diferente e menor";
		}else if (numeroHardCode != numero && numeroHardCode < numero){
			retorno = "Número diferente e maior";
		}else if (numeroHardCode == numero){
			retorno = "Número exatamente igual";
		}
		return ResponseEntity.ok(retorno);
	}

	
	@GetMapping("swithcase")
	public ResponseEntity<String> swithcase(@RequestParam(name="nome", required=false) String nome) {
		//http://localhost:8080/atividades/swithcase?nome=Thiago
		var retorno = new String();

		switch (nome){
			case "Thiago":
				retorno = "Escreveu um nome de um aluno";
				break;
			case "Felipe":
				retorno = "Escreveu um Nome do Professor";
				break;
			case "Brasileiro":
				retorno = "Escreveu um nome de um aluno";
				break;
			default:
				retorno = "Nome não reconhecido";
				break;
		}
		
		return ResponseEntity.ok(retorno);
	}

	
	
}
