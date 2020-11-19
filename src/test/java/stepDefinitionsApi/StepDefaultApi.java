package stepDefinitionsApi;

import org.apache.log4j.Logger;

import core.api.BaseApi;
import io.cucumber.java.pt.Dado;
import log.LogSetup;
import utils.Utils;

public class StepDefaultApi extends BaseApi{

	private static Logger logger = LogSetup.getLogger(StepDefaultApi.class);
	
	@Dado("que acesse a url do swagger")
	public void que_acesse_a_url_do_swagger() {
		logger.info("Definindo url base");
		Utils.propBaseUrl();
	}
}
