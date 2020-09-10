package com.yalo.stepDef;


import com.yalo.core.Request;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class SetUpSteps {
    private Request request;
    private Hooks hooks;

    public SetUpSteps(Request request, Hooks hooks) {
        this.request = request;
        this.hooks=hooks;
    }


    @Given("^the path has a key \"([^\"]*)\"$")
    public void thePathHasAKey(String key){
        this.request.hostname = request.hostname + key;
    }

    @When("^I save the \"([^\"]*)\" identifier$")
    public void iSaveThe(String id)  {
        hooks.saveId(id);


    }
}
