package net.thepixelverse.api.queries;

import java.util.UUID;

import org.json.JSONObject;

import net.thepixelverse.api.server.ServerType;

public class PlayerStatsQuery extends APIQuery {
    
    @Override
    public String getContext() {
	return "stats";
    }
    
    public void setParamName(String name) {
	setParam("name", name);
    }
    
    public void setParamUUID(UUID uuid) {
	setParam("uuid", uuid.toString());
    }
    
    public String getParamName() {
	return getParam("name");
    }
    
    public UUID getParamUUID() {
	return UUID.fromString(getParam("uuid"));
    }
    
    private JSONObject getStats(ServerType type) {
	return getResponse().getResponse().getJSONObject("stats").getJSONObject(type.getName());
    }
    
    public int getKills(ServerType serverType) {
	return getStats(serverType).getInt("kills");
    }
    
    public int getWins(ServerType serverType) {
	return getStats(serverType).getInt("wins");    }
    
    public int getLosses(ServerType serverType) {
	return getStats(serverType).getInt("losses");
    }
    
    public int getDeaths(ServerType serverType) {
	return getStats(serverType).getInt("deaths");
    }
    
}
