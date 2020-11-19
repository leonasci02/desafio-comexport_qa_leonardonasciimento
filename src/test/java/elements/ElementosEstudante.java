package elements;

import org.openqa.selenium.By;

import core.web.WebBaseElements;

public class ElementosEstudante extends WebBaseElements{

	private By lblTitulo = css("h2.title");
	private By btnStudentController = css("button.expand-operation");
	private By btnExecute = css("button[class='btn execute opblock-control__btn']");
	private By btnTryItOut = css("button[class='btn try-out__btn']");
	private By mdResponse = css("pre[class=' microlight']");
	private By lblResponse = css("div.responses-wrapper > div.opblock-section-header > h4");
	
	/**
	 * ABA GETALL STUDENT
	 */
	private By btnGetAllStudent = css("div#operations-Student-getAll a");
	private By lblGetAllStudent = css("#operations-Student-getAll div.opblock-description-wrapper div.markdown");
	
	/**
	 * ABA GET STUDENT
	 */
	private By btnGetStudent = css("div#operations-Student-get a");
	private By txtCpf = css("input[placeholder='cpf - cpf']");
	
	/**
	 * ABA POST 
	 */
	private By btnPostStudent = css("div#operations-Student-create a");
	private By txtAreaPost = css("textarea[class='body-param__text']");
	
	/**
	 * ABA PATCH 
	 */
	private By btnPatchStudent = css("div#operations-Student-update a");

	public By getLblTitulo() {
		return lblTitulo;
	}

	public By getBtnStudentController() {
		return btnStudentController;
	}

	public By getBtnExecute() {
		return btnExecute;
	}

	public By getBtnTryItOut() {
		return btnTryItOut;
	}

	public By getMdResponse() {
		return mdResponse;
	}

	public By getLblResponse() {
		return lblResponse;
	}

	public By getBtnGetAllStudent() {
		return btnGetAllStudent;
	}

	public By getLblGetAllStudent() {
		return lblGetAllStudent;
	}

	public By getBtnGetStudent() {
		return btnGetStudent;
	}

	public By getTxtCpf() {
		return txtCpf;
	}

	public By getBtnPostStudent() {
		return btnPostStudent;
	}

	public By getTxtAreaPost() {
		return txtAreaPost;
	}

	public By getBtnPatchStudent() {
		return btnPatchStudent;
	}
	
	
}
