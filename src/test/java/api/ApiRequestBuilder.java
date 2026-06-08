package api;

import java.util.HashMap;
import java.util.Map;

public class ApiRequestBuilder {

    private Map<String,String> headers = new HashMap<>();
    private String body;

    public ApiRequestBuilder addHeader(String key,String value){

        headers.put(key,value);
        return this;
    }

    public ApiRequestBuilder setBody(String body){

        this.body = body;
        return this;
    }

    public Map<String,String> getHeaders(){

        return headers;
    }

    public String getBody(){

        return body;
    }
}