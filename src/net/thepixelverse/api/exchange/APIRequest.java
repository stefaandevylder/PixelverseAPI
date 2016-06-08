package net.thepixelverse.api.exchange;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.json.JSONObject;

import net.thepixelverse.api.exchange.APIRequest;

public class APIRequest {
    
    private static String host = "localhost:8250"; // "srv.thepixelverse.net:8250";
    
    private Map<String, String> query;
    private String context;
    
    public APIRequest(UUID apiKey, String context) {
	this.query = new HashMap<String, String>();
	
	query.put("key", apiKey.toString());
	this.context = context;
    }
    
    public void putParam(String param, String value) {
	query.put(param, value);
    }
    
    public void putParam(Entry<String, String> entry) {
	putParam(entry.getKey(), entry.getValue());
    }
    
    public String getParam(String param) {
	return query.containsKey(param) ? query.get(param) : null;
    }
    
    public APIResponse get() {
	return createResponse(host);
    }
    
    private APIResponse createResponse(String host) {
	try {
	    URL url = new URL("http://" + host + "/" + context + "?" + queryToString());
	    System.out.println(url.toString());
	    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	    
	    InputStream in = urlConnection.getResponseCode() == 200 ? urlConnection.getInputStream() : urlConnection.getErrorStream();
	    BufferedReader read = new BufferedReader(new InputStreamReader(in));
	    String json = read.readLine();
	    read.close();
	    
	    return new APIResponse(this, new JSONObject(json));
	} catch (Exception exception) {
	    exception.printStackTrace();
	    return null;
	}
	
    }
    
    private String queryToString() {
	StringBuilder queryStringBuilder = new StringBuilder();
	query.forEach((param, value) -> queryStringBuilder.append(param + "=" + value + "&"));
	String queryString = queryStringBuilder.toString();
	
	return queryString.substring(0, queryString.length() - 1);
    }
    
}
