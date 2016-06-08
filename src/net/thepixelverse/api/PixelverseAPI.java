package net.thepixelverse.api;

import java.util.UUID;

import net.thepixelverse.api.queries.APIQuery;

public class PixelverseAPI {
    
    private UUID apiKey;
    
    public PixelverseAPI(UUID key) {
	this.apiKey = key;
    }
    
    public APIQuery createQuery(APIQuery query) {
	return query.get(apiKey);
    }
    
}
