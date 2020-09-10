package com.yalo.stepDef;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.yalo.core.Response;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AssertJsonSteps {
    private Response response;


    public AssertJsonSteps(Response response) {
        this.response = response;
    }

    @Then("^the response has a field of \"([^\"]*)\"$")
    public void the_response_has_a_field_of(String key) {
        try {
            Assert.assertNotNull(JsonPath.parse(response.getResponseBody()).read(key));
        } catch (PathNotFoundException ex) {
            Assert.fail(key + " Key not found");
        }
    }

    @Then("^the response body has the following attributes$")
    public void the_response_body_has_the_following_attributes(List<String> keys) {
        for (String key : keys) {
            try {
                Assert.assertNotNull(JsonPath.parse(response.getResponseBody()).read(key));
            } catch (PathNotFoundException ex) {
                Assert.fail(key + " Not found");
            }
        }
    }

    @Then("^the response body has the following attributes with values$")
    public void the_response_body_has_the_following_attributes_with_values(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                Assert.assertEquals(entry.getValue(), JsonPath.parse(response.getResponseBody()).read(entry.getKey().toString()));
                Assert.assertNotEquals(0, map.size());
            } catch (PathNotFoundException ex) {
                Assert.fail(entry.getKey() + " path not found");
            }
        }
    }

    @When("^the response Http code is \"([^\"]*)\"$")
    public void theResponseHttpCodeIs(int code) {
        try {
            Assert.assertEquals(response.getResponseCode(), code);
        } catch (AssertionError ex) {
            Assert.fail("Actual code: " + code);
        }
    }


}
