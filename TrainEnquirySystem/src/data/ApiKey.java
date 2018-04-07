package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ApiKey {
	private String apiKey;
	
	public ApiKey() throws IOException {
		try(FileReader reader = new FileReader(new File("res//apikey.key"));
				BufferedReader buffereReader = new BufferedReader(reader)){
			apiKey = buffereReader.readLine();
		} 
	}
	
	public String getApiKey() {
		return apiKey;
	}
}
