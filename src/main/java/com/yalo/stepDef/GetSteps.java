package com.yalo.stepDef;

import com.yalo.core.RestClient;
import cucumber.api.java.en.Given;


public class GetSteps {
    private RestClient restClient;

    public GetSteps(RestClient restClient) {
        this.restClient = restClient;
    }


    @Given("^I make a GET request to \"([^\"]*)\"$")
    public void i_make_a_GET_request_to(String url) {
        this.restClient.get(url);
    }

    @Given("^I make a GET request$")
    public void i_make_a_GET_request() {
        this.restClient.get();
    }

}
