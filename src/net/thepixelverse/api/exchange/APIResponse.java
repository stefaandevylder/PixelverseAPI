package net.thepixelverse.api.exchange;

import org.json.JSONObject;

public class APIResponse {
    
    private APIRequest query;
    private JSONObject response;
    
    public APIResponse(APIRequest query, JSONObject response) {
	this.query = query;
	this.response = response;
    }
    
    public APIRequest getRequest() {
	return query;
    }
    
    public JSONObject getResponse() {
	return response;
    }
    
}
