package com.yalo.stepDef;

import com.yalo.core.Request;
import com.yalo.core.Response;
import com.yalo.core.RestClient;
import cucumber.api.java.en.When;

public class PostSteps {

    private RestClient restClient;
    private Response response;
    private Request request;

    public PostSteps(Response response, Request request, RestClient restClient) {
        this.response = response;
        this.request = request;
        this.restClient = restClient;
    }


    @When("^I create a new (?:\\w+) with body:$")
    public void iCreateANewWithBody(String body) {
        System.out.println(request.hostname);
        this.restClient.post(body);
    }
}
