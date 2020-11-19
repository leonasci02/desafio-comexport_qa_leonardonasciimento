package stepDefinitionsWeb;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import modelApi.EstudanteMassa;
import page.EstudantePage;

public class CadastrarEstudanteWebStep {

	private EstudantePage estudante = new EstudantePage();

	@Quando("optar por selecionar a opcao student post")
	public void postEstudante() {
		estudante.postEstudante();
	}

	@Quando("opto por preencher os dados de inclusão")
	public void preencheDadosInclusao() {
		EstudanteMassa massa = new EstudanteMassa();
		massa.popularEstudanteComLivros();
		estudante.preencherDadosInclusao(massa.jsonEstudanteComLivros());
	}

	@Quando("optar por selecionar a opcao student patch")
	public void patchEstudante() {
		estudante.patchEstudante();
	}

	@Quando("opto por preencher cpf e dados de alteracao")
	public void preencherPatchInclusao() {
		EstudanteMassa massa = new EstudanteMassa();
		estudante.preencherPathInclusao("09705066618", massa.jsonAtualizaEstudante());
	}

	@Então("o sistema apresenta a aba de response com erro na atualização")
	public void erroDeAtualizacao() {
		estudante.validarMensagemDeErro("Bad Request");
	}
	
	@Então("o sistema apresenta a aba de response com erro no cadastro")
	public void validarMensagemDeErroCadastro() {
		estudante.validarMensagemDeErro("Bad Request");
	}

}
