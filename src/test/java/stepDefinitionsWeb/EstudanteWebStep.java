package stepDefinitionsWeb;

import core.web.DriverWeb;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import page.EstudantePage;
import utils.Utils;

public class EstudanteWebStep {

	private EstudantePage estudante = new EstudantePage();
	
	@Before("@Web")
	public void setUp() {
		DriverWeb.getDriver(Utils.propNavegador(), Utils.propIsHeadless());
	}

	@After("@Web")
	public void tearDown(Scenario cenario) {
		DriverWeb.finalizarDriver();
	}
	
	@Dado("que acesse o sistema de estudante")
	public void acessarSistemaWeb() {
		estudante.acessarSistema();
	}

	@Quando("optar por selecionar a opcao student getAll")
	public void consultaTodosEstudantes() {
		estudante.modalTodosEstudante();
	}

	@Quando("selecionar a opcao try it out")
	public void opcaoTryItOut() {
		estudante.selecionarTryItOut();
	}

	@Então("o sistema apresenta a aba de response com a lista de estudantes")
	public void validarEstudante() {
		estudante.executarTodosEstudante();
	}

	@Quando("optar por selecionar a opcao student get")
	public void opcaoGetEstudante() {
		estudante.executarEstudanteEspecifico();
	}

	@Quando("opto por preencher o cpf")
	public void preencherCpf() {
		estudante.preencherCpf("09705066618");
	}

	@Então("o sistema apresenta a aba de response com estudante especifico")
	public void validarEstudanteEspecifico() {
		estudante.validarEstudanteEspecifico();
	}

	@Quando("opto por preencher o cpf inválido")
	public void preencherCpfInvalido() {
		estudante.preencherCpf("00");
	}

	@Então("o sistema apresenta a aba de response com mensagem de erro")
	public void validarMensagemDeErro() {
		estudante.validarMensagemDeErro("Internal Server Error");
	}

	
	
}
