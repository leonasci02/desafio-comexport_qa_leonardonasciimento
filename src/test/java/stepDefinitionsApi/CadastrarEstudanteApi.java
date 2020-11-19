package stepDefinitionsApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

import core.api.BaseApi;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import log.LogSetup;
import modelApi.EstudanteMassa;

public class CadastrarEstudanteApi extends BaseApi {

	private static Logger logger = LogSetup.getLogger(CadastrarEstudanteApi.class);
	private HttpResponse<JsonNode> response;

	@Quando("optar por preencher os dados do estudante com livros")
	public void cadastrarEstudante() {
		logger.info("Preenchendo dados de estudante com livros");
		EstudanteMassa massa = new EstudanteMassa();
		massa.popularEstudanteComLivros();
		logger.info("Populando dados no json");
		this.response = postEstudante(massa.jsonEstudanteComLivros());
	}

	@Então("o sistema deve retornar o status code {int} com a mensagem de sucesso")
	public void validarMensagem(int statusCode) {
		logger.info("Validando o status code de sucesso");
		assertTrue(this.response.isSuccess());
		assertEquals(statusCode, this.response.getStatus());
		logger.info(this.response.getBody().toPrettyString());
	}

	@Quando("optar por preencher dados inválido de um estudante com livros")
	public void dadosInvalidosEstudante() {
		logger.info("Preenchendo dados de estudante inválido");
		EstudanteMassa massa = new EstudanteMassa();
		massa.popularEstudanteDadosInvalidos();;
		this.response = postEstudante(massa.jsonEstudanteComLivros().substring(0, 200)+"}");
	}
	
	@Então("o sistema deve retornar o status code {int} com a mensagem de erro")
	public void validarMensagemComErro(int statusCode) {
		logger.info("Validando o status code de retorno inválido");
		assertEquals(statusCode, this.response.getStatus());
		String resultado = this.response.getBody().getObject().toString();
		assertTrue(resultado.contains("Bad Request"));
		logger.info(this.response.getBody().toPrettyString());
	}
}
