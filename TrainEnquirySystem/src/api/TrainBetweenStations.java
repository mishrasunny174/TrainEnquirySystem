package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import data.TrainBetweenStationsData;

public class TrainBetweenStations {
	public static TrainBetweenStationsData getTrainsBetweenStations(String from, String to, String date, String apiKey)
			throws UnableToConnectToServerException, EmptyArgumentsException {
		if(from.equals("")||to.equals("")||date.equals(""))
			throw new EmptyArgumentsException("Input fields are empty");
		String urlString = "https://api.railwayapi.com/v2/between/source/"+from+"/dest/"+to+"/date/"+date+"/apikey/"+apiKey+"/";
		StringBuffer response = new StringBuffer();
		TrainBetweenStationsData data = null;
		try {
			URL url = new URL(urlString);
			URLConnection urlConnection = url.openConnection();
			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(urlConnection.getInputStream(), "UTF-8"))) {
				String tempString;
				while ((tempString = reader.readLine()) != null) {
					response.append(tempString + "\n");
				}
			} catch (IOException e) {
				System.err.println("[Debug] " + e.getMessage());
			}
		} catch (MalformedURLException e) {
			System.err.println("[Debug] " + e.getMessage());
		} catch (IOException e) {
			throw new UnableToConnectToServerException("Unable to connect to server");
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			data = mapper.readValue(response.toString(), TrainBetweenStationsData.class);
		} catch (JsonParseException e) {
			System.out.println("[Debug] unable to parse response");
		} catch (JsonMappingException e) {
			System.out.println("[Debug] " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Debug] " + e.getMessage());
		}
		return data;
	}
}
