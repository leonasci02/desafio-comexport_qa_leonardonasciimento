package stepDefinitionsApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import core.api.BaseApi;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import modelApi.EstudanteMassa;

public class CadastrarEstudanteApi extends BaseApi {

	private HttpResponse<JsonNode> response;

	@Quando("optar por preencher os dados do estudante com livros")
	public void cadastrarEstudante() {
		EstudanteMassa massa = new EstudanteMassa();
		massa.popularEstudanteComLivros();
		this.response = postEstudante(massa.jsonEstudanteComLivros());
	}

	@Então("o sistema deve retornar o status code {int} com a mensagem de sucesso")
	public void validarMensagem(int statusCode) {
		assertTrue(this.response.isSuccess());
		assertEquals(statusCode, this.response.getStatus());
		System.out.println(this.response.getBody().toPrettyString());
	}

	@Quando("optar por preencher dados inválido de um estudante com livros")
	public void dadosInvalidosEstudante() {
		EstudanteMassa massa = new EstudanteMassa();
		massa.popularEstudanteDadosInvalidos();;
		this.response = postEstudante(massa.jsonEstudanteComLivros().substring(0, 200)+"}");
	}
	
	@Então("o sistema deve retornar o status code {int} com a mensagem de erro")
	public void validarMensagemComErro(int statusCode) {
		assertEquals(statusCode, this.response.getStatus());
		String resultado = this.response.getBody().getObject().toString();
		assertTrue(resultado.contains("Bad Request"));
		System.out.println(this.response.getBody().toPrettyString());
	}
}
