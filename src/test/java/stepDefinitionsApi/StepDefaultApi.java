package stepDefinitionsApi;

import core.api.BaseApi;
import io.cucumber.java.pt.Dado;
import utils.Utils;

public class StepDefaultApi extends BaseApi{

	@Dado("que acesse a url do swagger")
	public void que_acesse_a_url_do_swagger() {
		Utils.propBaseUrl();
	}
}
