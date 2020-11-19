package stepDefinitionsApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import core.api.BaseApi;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

public class ConsultaEstudanteApi extends BaseApi {

	private HttpResponse<JsonNode> response;

	@Quando("optar por selecionar a operação do tipo get")
	public void operacaoGet() {
		this.response = getEstudantes();
	}

	@Então("o sistema deve retornar o status code {int} com a lista de estudante")
	public void statusCodeListaEstudante(int statusCode) {
		assertTrue(this.response.isSuccess());
		assertTrue(this.response.getBody().isArray());
		String resultado = this.response.getBody().getArray().toList().toString();
		System.out.println(resultado);
		assertEquals(statusCode, this.response.getStatus());
		assertTrue(resultado.contains("Roberto") && resultado.contains("Testes online"));
	}

	@Quando("optar por informar o cpf do estudante com a operação do tipo get")
	public void getComParametrosNaUrl() {
		this.response = getEstudantes("09705066618");
	}

	@Quando("optar por informar o cpf inválido do estudante com a operação do tipo get")
	public void consultaComCpfInvalido() {
		this.response = getEstudantes("097050666");
	}

	@Então("o sistema deve retornar o status code {int} com as informações do estudante")
	public void validarUmEstudante(int statusCode) {
		assertTrue(this.response.isSuccess());
		String resultado = this.response.getBody().getObject().toString();
		System.out.println(resultado);
		assertEquals(statusCode , this.response.getStatus());
		assertTrue(resultado.contains("Roberto") && resultado.contains("09705066618"));
	}
	
	@Então("o livros selecionados")
	public void validarLivro() {
		String resultado = this.response.getBody().getObject().get("books").toString();
		assertTrue(resultado.contains("Testes online"));
	}

	@Então("o sistema deve retornar o status code {int}")
	public void statusDeRetorno(int statusCode) {
		assertEquals(statusCode, this.response.getStatus());
		String resultado = this.response.getBody().getObject().toString();
		assertTrue(resultado.contains("Internal Server Error"));
		System.out.println(resultado);
	}
}
