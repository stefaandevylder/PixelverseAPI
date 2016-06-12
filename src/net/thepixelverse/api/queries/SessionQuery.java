package net.thepixelverse.api.queries;

import java.util.UUID;

import org.json.JSONObject;

import net.thepixelverse.api.server.ServerType;

public class SessionQuery extends APIQuery {
    
    @Override
    public String getContext() {
	return "session";
    }
    
    public void setParamName(String name) {
	setParam("name", name);
    }
    
    public String getParamName() {
	return getParam("name");
    }
    
    public void setParamUUID(UUID uuid) {
	setParam("uuid", uuid.toString());
    }
    
    public UUID getParamUUID() {
	return hasParam("uuid") ? UUID.fromString(getParam("uuid")) : null;
    }
    
    public boolean isPlayerOnline() {
	return getResponse().getResponse().getJSONObject("return").getBoolean("online");
    }
    
    public String getResponsePlayerName() {
	JSONObject r = getResponse().getResponse().getJSONObject("return");
	
	return r.has("name") ? r.getString("name") : null;
    }
    
    public UUID getResponsePlayerUUID() {
	JSONObject r = getResponse().getResponse().getJSONObject("return");
	
	return r.has("uuid") ? UUID.fromString(r.getString("uuid")) : null;
    }
    
    public String getResponsePlayerServer() {
	if (!isPlayerOnline())
	    return null;
	    
	return getResponse().getResponse().getJSONObject("return").getString("server");
    }
    
    public ServerType getResponsePlayerServerType() {
	if (!isPlayerOnline())
	    return null;
	    
	return ServerType.fromName(getResponse().getResponse().getJSONObject("return").getString("serverType"));
    }
    
}
