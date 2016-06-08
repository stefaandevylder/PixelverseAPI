package net.thepixelverse.api.queries;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import net.thepixelverse.api.exchange.APIRequest;
import net.thepixelverse.api.exchange.APIResponse;

public abstract class APIQuery {
    
    private Map<String, String> query;
    private APIRequest request;
    private APIResponse response;
    
    public APIQuery() {
	query = new HashMap<String, String>();
    }
    
    public final Map<String, String> getQuery() {
	return query;
    }
    
    public final boolean wasSuccessful() {
	return response != null && response.getResponse().getBoolean("success");
    }
    
    public final boolean hasParam(String param) {
	return query.containsKey(param);
    }
    
    public final String getMessage() {
	return response != null ? (response.getResponse().has("message") ? response.getResponse().getString("message") : null) : null;
    }
    
    public final String getParam(String param) {
	return query.containsKey(param) ? query.get(param) : null;
    }
    
    public final void setParam(String param, String value) {
	query.put(param, value);
    }
    
    public final void setParam(Entry<String, String> entry) {
	setParam(entry.getKey(), entry.getValue());
    }
    
    public abstract String getContext();
    
    public final APIQuery get(UUID key) {
	response = createRequest(key).get();
	return this;
    }
    
    private final APIRequest createRequest(UUID key) {
	request = new APIRequest(key, getContext());
	query.entrySet().forEach(e -> request.putParam(e));
	return request;
    }
    
    public final APIRequest getRequest() {
	return request;
    }
    
    public final APIResponse getResponse() {
	return response;
    }
}
