/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import models.Budget;
import models.User;
import ninja.Result;
import ninja.Results;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import services.UserFactory;

import java.util.HashMap;


@Singleton
public class ApplicationController {

    private UserFactory userFactory;
    private String agbizAddress = "http://agbizdev.cosine.oregonstate.edu";
    private ObjectMapper objectMapper = new ObjectMapper();

    @Inject
    public ApplicationController(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    public Result index() {
        HashMap<String, String> response = new HashMap<String, String>();
        response.put("title", "Welcome!");

        return Results.json().render(response);
    }

    public Result user() {
        User user = this.userFactory.createDefaultUser();

        return Results.json().render(user);
    }

    public Result createUser() {
        User user = this.userFactory.createDefaultUser();

        return Results.json().render(user);
    }

    public Result retrieveBudget() {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(agbizAddress + "/budget/api/budgets/1/");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            Budget budget = objectMapper.readValue(entity.getContent(), Budget.class);

            return Results.json().render(budget);
        }
        catch (Exception e) {
            return Results.json().render(e.getMessage());
        }
    }

}
