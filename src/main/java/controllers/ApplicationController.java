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

import com.google.inject.Inject;
import com.google.inject.Singleton;
import models.Budget;
import models.User;
import ninja.Result;
import ninja.Results;
import ninja.params.PathParam;
import providers.BudgetServiceProvider;
import providers.UserFactoryProvider;
import services.BudgetService;
import services.UserFactory;

import java.util.HashMap;


@Singleton
public class ApplicationController {
    private UserFactory userFactory;
    private BudgetService budgetService;
    private HashMap<String, String> errorMap;

    @Inject
    public ApplicationController(UserFactoryProvider userFactoryProvider,
                                 BudgetServiceProvider budgetServiceProvider) {
        this.userFactory = userFactoryProvider.createUserFactory();
        this.budgetService = budgetServiceProvider.createBudgetService();
        this.errorMap = new HashMap<>();
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

    public Result retrieveBudget(@PathParam("id") int id) {
        try {
            Budget budget = this.budgetService.retrieveBudget(id);

            return Results.json().render(budget);
        }
        catch (Exception e) {
            this.errorMap.put("text", e.getMessage());

            return Results.badRequest().json().render(this.errorMap);
        }
    }

}
