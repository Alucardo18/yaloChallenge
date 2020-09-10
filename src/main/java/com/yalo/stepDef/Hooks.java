package com.yalo.stepDef;

import com.jayway.jsonpath.JsonPath;
import com.yalo.core.Response;
import cucumber.api.java.After;
import org.springframework.web.client.HttpClientErrorException;
import java.util.HashMap;


public class Hooks {
    private Response response;
    private HashMap<String, String> entityId;
    private DeleteSteps deleteSteps;
    private String alias;

    public Hooks(Response response, HashMap<String, String> entityId, DeleteSteps deleteSteps) {
        this.response = response;
        this.entityId = entityId;
        this.deleteSteps = deleteSteps;

    }

    public void saveId(String alias) {
        this.alias = alias;
        String ID = JsonPath.parse(this.response.getResponseBody()).read(alias);
        System.out.println(alias + " " + ID);
        entityId.put(alias, ID);
    }

    @After
    public void deleteRecords() {
        try {
            this.deleteSteps.iRemoveACollectionWithUID(entityId.get(alias));
        } catch (HttpClientErrorException ex) {
           System.out.println(this.entityId.get(alias + "not found"));
        }
    }
}
