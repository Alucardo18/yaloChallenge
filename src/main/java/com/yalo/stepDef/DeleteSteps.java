package com.yalo.stepDef;

import com.yalo.core.Response;
import com.yalo.core.RestClient;
import cucumber.api.java.en.Given;

public class DeleteSteps {
    private Response response;
    private RestClient restClient;

    public DeleteSteps(Response response, RestClient restClient) {
        this.response = response;
        this.restClient=restClient;
    }


    @Given("^I remove a collection with UID \"([^\"]*)\"$")
    public void iRemoveACollectionWithUID(String uid) {
        restClient.delete(uid);
    }
}
