package stepDefinitionsApi;

import static modelApi.EstudanteMassa.getNovoNome;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import core.api.BaseApi;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import modelApi.EstudanteMassa;

public class AtualizarEstudanteApi extends BaseApi {

	private HttpResponse<JsonNode> response;

	@Quando("optar por atualizar os dados obrigatórios na operação do tipo patch")
	public void dadosObrigatorioPatch() {
		EstudanteMassa massa = new EstudanteMassa();
		this.response = patchEstudante(massa.jsonAtualizaEstudante(), "09705066619");
	}

	@Quando("optar por não informar os dados obrigatórios na operação do tipo patch")
	public void dadosNaoObrigatorio() {
		this.response = patchEstudante("{}", "09705066619");
	}

	@Então("o sistema deve retornar o status code {int} com a mensagem de atualizacao")
	public void validarAtualizacao(int statusCode) {
		assertEquals(statusCode, this.response.getStatus());
		String resultado = this.response.getBody().toPrettyString();
		assertTrue(resultado.contains(getNovoNome()));
	}

	@Então("o sistema não deve atualizar o estudante e apresentar o status code {int}")
	public void naoDeveAtualizar(int statusCode) {
		assertEquals(statusCode, this.response.getStatus());
		assertTrue(this.response.getBody().toPrettyString().contains("Bad Request"));
	}

}
