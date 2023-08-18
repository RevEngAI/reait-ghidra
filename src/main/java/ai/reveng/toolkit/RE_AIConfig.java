package ai.reveng.toolkit;

import java.io.File;

import com.moandjiezana.toml.Toml;

import ai.reveng.toolkit.model.ModelInfo;

/**
 * Object for representing settings
 */
public class RE_AIConfig {
	private String apiKey;
	private String host;
	private ModelInfo model;
	private String analysisHash;

	/**
	 * Constructor for when we have the API Key and a host url, but don't know what
	 * models are available
	 * 
	 * @param apikey
	 * @param host
	 */
	public RE_AIConfig(String apikey, String host) {
		this.apiKey = apikey;
		this.host = host;
	}

	public RE_AIConfig(String tomlFilePath) {
		File tomlFile = new File(tomlFilePath);
		Toml toml = new Toml().read(tomlFile);
		this.apiKey = toml.getString("apikey");
		this.host = toml.getString("host");
		this.model = new ModelInfo(toml.getString("model"));
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public ModelInfo getModel() {
		return model;
	}

	public void setModel(ModelInfo model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "REAITConfig [apiKey=" + apiKey + ", host=" + host + ", model=" + model + "]";
	}

	public String getAnalysisHash() {
		return analysisHash;
	}

	public void setAnalysisHash(String analysisHash) {
		this.analysisHash = analysisHash;
	}

}