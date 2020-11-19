package page;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import core.web.WebBaseTest;
import elements.ElementosEstudante;
import utils.Utils;

public class EstudantePage extends WebBaseTest  {
	
	private ElementosEstudante campos = new ElementosEstudante();
	
	public void acessarSistema() {
		openUrl(Utils.propBaseUrlWeb());
	}
	
	public void modalTodosEstudante() {
		studentController();
		esperarSerClicavel(campos.getBtnGetAllStudent());
		clicar(campos.getBtnGetAllStudent());
	}
	
	public void selecionarTryItOut() {
		esperarSerClicavel(campos.getBtnTryItOut());
		clicar(campos.getBtnTryItOut());
	}
	
	public void executarTodosEstudante() {
		esperarSerClicavel(campos.getBtnExecute());
		clicar(campos.getBtnExecute());
		esperarPresencaDoElemento(campos.getLblResponse());
		assertEquals("Responses", obtemTexto(campos.getLblResponse()));
		String resultado = obtemTexto(campos.getMdResponse());
		assertTrue(resultado.contains("Roberto"));
	}

	public void preencherCpf(String cpf) {
		esperarSerClicavel(campos.getTxtCpf());
		escrever(campos.getTxtCpf(), cpf);
		esperarSerClicavel(campos.getBtnExecute());
		clicar(campos.getBtnExecute());
		esperarPresencaDoElemento(campos.getLblResponse());
	}
	
	public void validarEstudanteEspecifico() {
		assertEquals("Responses", obtemTexto(campos.getLblResponse()));
		String resultado = obtemTexto(campos.getMdResponse());
		assertTrue(resultado.contains("Roberto") && resultado.contains("Testes online"));
	}

	public void executarEstudanteEspecifico() {
		studentController();
		esperarSerClicavel(campos.getBtnGetStudent());
		clicar(campos.getBtnGetStudent());
	}

	public void validarMensagemDeErro(String mensagemDeErro) {
		assertEquals("Responses", obtemTexto(campos.getLblResponse()));
		String resultado = obtemTexto(campos.getMdResponse());
		assertTrue(resultado.contains(mensagemDeErro));
	}

	public void postEstudante() {
		studentController();
		esperarSerClicavel(campos.getBtnPostStudent());
		clicar(campos.getBtnPostStudent());
	}
	
	private void studentController() {
		esperarPresencaDoElemento(campos.getLblTitulo());
		assertEquals("Book Library", obtemTexto(campos.getLblTitulo()));
		esperarSerClicavel(campos.getBtnStudentController());
		clicar(campos.getBtnStudentController());
	}

	public void preencherDadosInclusao(String json) {
		esperarSerClicavel(campos.getTxtAreaPost());
		scrollJavaScript(500);
		escrever(campos.getTxtAreaPost(), json);
		clicar(campos.getBtnExecute());
	}

	public void patchEstudante() {
		studentController();
		esperarSerClicavel(campos.getBtnPatchStudent());
		clicar(campos.getBtnPatchStudent());
	}
	
	public void preencherPathInclusao(String cpf ,String json) {
		esperarSerClicavel(campos.getTxtCpf());
		escrever(campos.getTxtCpf(), cpf);
		scrollJavaScript(200);
		escrever(campos.getTxtAreaPost(), json);
		esperarSerClicavel(campos.getBtnExecute());
		clicar(campos.getBtnExecute());
	}
}
