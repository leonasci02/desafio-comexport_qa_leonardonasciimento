package core.api;

import org.apache.log4j.Logger;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import log.LogSetup;
import utils.Utils;

public abstract class BaseApi {

	private static Logger logger = LogSetup.getLogger(BaseApi.class);
	
	public BaseApi() {}

	public HttpResponse<JsonNode> getEstudantes() {
		logger.info("Realizando uma requisão do tipo get");
		return Unirest.get(Utils.propBaseUrl() + Utils.propRequest()).asJson();
	}

	public HttpResponse<JsonNode> getEstudantes(String parametros) {
		logger.info("Realizando uma requisão do tipo get");
		return Unirest.get(Utils.propBaseUrl() + Utils.propRequest()+"/" + parametros).asJson();
	}
	
	public HttpResponse<JsonNode> postEstudante(String json){
		logger.info("Realizando uma requisão do tipo post");
		return Unirest.post(Utils.propBaseUrl() + Utils.propRequest())
				.header("accept", Utils.propRequestAccept())
				.header("Content-type", Utils.propRequestContent())
				.body(json).asJson();
	}
	
	public HttpResponse<JsonNode> patchEstudante(String json, String cpf){
		logger.info("Realizando uma requisão do tipo patch");
		return Unirest.patch(Utils.propBaseUrl() + Utils.propRequest()+"/" + cpf)
				.header("accept", Utils.propRequestAccept())
				.header("Content-type", Utils.propRequestContent())
				.body(json).asJson();	
	}
}
