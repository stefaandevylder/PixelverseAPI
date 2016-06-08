package net.thepixelverse.api.server;

public enum ServerType {
    
    HUB("Hub"), BRIDGES("Bridges"), TUNNELERS("Tunnelers"), SKYWARS("Skywars"), BEWITCHED("Bewitched");
    
    private String name;
    
    private ServerType(String name) {
	this.name = name;
    }
    
    public String getName() {
	return name;
    }
    
    public static ServerType fromName(String name) {
	for (ServerType type : values())
	    if (type.getName().equals(name))
		return type;
	return null;
    }
    
}
