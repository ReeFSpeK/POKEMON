import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PokeAPI {

	private static String url = "https://pokeapi.co/api/v2/";
	
    //HashMap to cache (URL, JSONObject)
    protected static HashMap<String, JSONObject> cache = new HashMap<>();
    protected static HashMap<String, String> types = initTypes();
    
	/*
	 * Function the initialize the HashTable of the types using PokeAPI.
	 */
	private static HashMap<String, String> initTypes() {
		
		HashMap<String, String> types = new HashMap<String, String>();
		
		JSONObject json = request(url+"type/");
		JSONArray array = json.getJSONArray("results");
		
		Iterator<Object> iterator = array.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObject = (JSONObject) iterator.next();
            
            types.put(jsonObject.get("name").toString(), jsonObject.get("url").toString());
        }
		
		return types;
	}
	
    @SuppressWarnings("deprecation")
	protected static JSONObject request(String url) {
    	
    	// Try first to search given url in the cache
    	Set<String> urls = cache.keySet();
    	for(String cachedUrl : urls) {
    		if(cachedUrl.equals(url)) {
    			return cache.get(url);
    		}
    	}
    	
		try {
	        HttpResponse response;
	        DefaultHttpClient httpClient = new DefaultHttpClient();
	        HttpGet getConnection = new HttpGet(url);
	        try {
	            response = httpClient.execute(getConnection);
	            String JSONString = EntityUtils.toString(response.getEntity(),
	                    "UTF-8");
	            JSONObject jsonObject = new JSONObject(JSONString); //Assuming it's a JSON Object
	            
	            // Adding the json result to the cache.
	            addToCache(url, jsonObject);
	            
	            return jsonObject;

	        } catch (ClientProtocolException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (JSONException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        finally {
				httpClient.close();
			}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}

    private static void addToCache(String url, JSONObject jsonObject) {
    	cache.put(url, jsonObject);
    }
    
}
