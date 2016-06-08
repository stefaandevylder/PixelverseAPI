package net.thepixelverse.api.queries;

public class ServerStatusQuery extends APIQuery {
    
    @Override
    public String getContext() {
	return "server";
    }
    
    public void setServer(String server) {
	setParam("server", server);
    }
    
    public String getServer() {
	return getParam("server");
    }
    
    public String getServerType() {
	return getResponse().getResponse().getJSONObject("return").getString("type");
    }
    
    public String getServerStatus() {
	return getResponse().getResponse().getJSONObject("return").getString("status");
    }
    
    public String getServerMap() {
	return getResponse().getResponse().getJSONObject("return").getString("map");
    }
    
    public int getServerPlayerAmount() {
	return getResponse().getResponse().getJSONObject("return").getInt("players");
    }
    
    public int getServerMaxPlayerAmount() {
	return getResponse().getResponse().getJSONObject("return").getInt("maxPlayers");
    }
    
    public int getServerRequiredPlayerAmount() {
	return getResponse().getResponse().getJSONObject("return").getInt("requiredPlayers");
    }
}
