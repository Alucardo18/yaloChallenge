package com.yalo.core;

import cucumber.runtime.Env;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class RestClient {


    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;
    private Response response;
    private Request request;

    public RestClient(Response response, Request request) {
        this.response = response;
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        this.request = request;
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
        headers.add("X-Api-Key", Env.INSTANCE.get("ApiKey"));
    }

    public Response get(String uri) {
        ResponseEntity<String> responseEntity = null;
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        System.out.println(request.hostname + uri);
        try {
            responseEntity = rest.exchange(request.hostname + uri, HttpMethod.GET, requestEntity, String.class);
            response.setResponseCode(responseEntity.getStatusCode().value());
            response.setResponseBody(responseEntity.getBody());
            System.out.println("response: " + response.getResponseCode());
            System.out.println(response.getResponseBody());
        } catch (HttpClientErrorException ex) {
            response.setResponseBody(ex.getResponseBodyAsString());
            response.setResponseCode(ex.getStatusCode().value());
            System.out.println("response: " + response.getResponseCode());
            System.out.println(response.getResponseBody());
            return response;
        }

        return response;
    }

    public Response get() {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        System.out.println(request.hostname);
        try {
            ResponseEntity<String> responseEntity = rest.exchange(request.hostname, HttpMethod.GET, requestEntity, String.class);
            this.response.setResponseCode(responseEntity.getStatusCode().value());
            this.response.setResponseBody(responseEntity.getBody());
            System.out.println("response: " + response.getResponseCode());
            System.out.println(response.getResponseBody());
        } catch (HttpClientErrorException ex) {
            response.setResponseBody(ex.getResponseBodyAsString());
            response.setResponseCode(ex.getStatusCode().value());
            System.out.println("response: " + response.getResponseCode());
            System.out.println(response.getResponseBody());
            return response;
        }
        return response;
    }

    public Response post(String json) {
        HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
        try {
            ResponseEntity<String> responseEntity = rest.exchange(request.hostname, HttpMethod.POST, requestEntity, String.class);
            this.response.setResponseCode(responseEntity.getStatusCode().value());
            this.response.setResponseBody(responseEntity.getBody());
        } catch (HttpClientErrorException ex) {
            response.setResponseBody(ex.getResponseBodyAsString());
            response.setResponseCode(ex.getStatusCode().value());
            System.out.println("response: " + response.getResponseCode());
            System.out.println(response.getResponseBody());
            return response;
        } catch (HttpServerErrorException ex) {
            response.setResponseBody(ex.getResponseBodyAsString());
            response.setResponseCode(ex.getStatusCode().value());
            System.out.println("response: " + response.getResponseCode());
            System.out.println(response.getResponseBody());
        }

        return response;
    }

    public void put(String uri, String json) {
        //TODO implement put operation
    }

    public Response delete(String id) {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        try {
            ResponseEntity<String> responseEntity = rest.exchange(request.hostname + id, HttpMethod.DELETE, requestEntity, (Class<String>) null);
            this.response.setResponseCode(responseEntity.getStatusCode().value());
            this.response.setResponseBody(responseEntity.getBody());
            this.setStatus(responseEntity.getStatusCode());
        } catch (HttpClientErrorException ex) {
            response.setResponseBody(ex.getResponseBodyAsString());
            response.setResponseCode(ex.getStatusCode().value());
            System.out.println("response: " + response.getResponseCode());
            System.out.println(response.getResponseBody());
            return response;
        }
        return response;
    }


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}
