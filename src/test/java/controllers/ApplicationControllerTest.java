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

import mocks.services.BudgetServiceMock;
import mocks.services.UserFactoryMock;
import models.Budget;
import models.User;
import ninja.Result;
import org.junit.Before;
import org.junit.Test;
import providers.BudgetServiceProvider;
import providers.BudgetServiceProviderImpl;
import services.BudgetService;
import services.UserFactory;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class ApplicationControllerTest {
    ApplicationController controller;

    UserFactory userFactoryMock;
    BudgetService budgetServiceMock;

    UserFactory userFactorySpy;
    BudgetService budgetServiceSpy;

    BudgetServiceProvider budgetServiceProviderMock;

    @Before
    public void beforeEach() {
        userFactoryMock =  new UserFactoryMock();
        budgetServiceMock = new BudgetServiceMock();
        userFactorySpy = spy(userFactoryMock);
        budgetServiceSpy = spy(budgetServiceMock);
        budgetServiceProviderMock = mock(BudgetServiceProviderImpl.class);

        when(budgetServiceProviderMock.createBudgetService()).thenReturn(budgetServiceSpy);

        controller = new ApplicationController(userFactorySpy, budgetServiceProviderMock);
    }

    @Test
    public void testIndex() {
        Result result = this.controller.index();
        HashMap<String, String> resultMap = (HashMap<String, String>) result.getRenderable();

        assertEquals(200, result.getStatusCode());
        assertEquals("Welcome!", resultMap.get("title"));
    }

    @Test
    public void testUser() {
        Result result = this.controller.user();
        User user = (User) result.getRenderable();

        verify(userFactorySpy, times(1)).createDefaultUser();
        assertEquals(result.getContentType(), "application/json");
        assertEquals(200, result.getStatusCode());
        assertEquals("johncleese", user.username);
        assertEquals("John", user.firstName);
        assertEquals("Cleese", user.lastName);
        assertEquals("password", user.password);
    }

    @Test
    public void testCreateUser() {
        Result result = this.controller.createUser();
        User user = (User) result.getRenderable();

        assertEquals(200, result.getStatusCode());
        assertEquals("johncleese", user.username);
    }

    @Test
    public void testRetrieveBudget() {
        int id = 1;
        Result result = this.controller.retrieveBudget(id);
        Budget budget = (Budget) result.getRenderable();

        assertEquals(200, result.getStatusCode());
        assertEquals(1, budget.id);
        try {
            verify(budgetServiceSpy).retrieveBudget(id);
        }
        catch (Exception e) {
            fail("Should not throw exception");
        }
    }

    @Test
    public void testRetrieveBudgetInvalid() {
        int id = -1;
        Result result = this.controller.retrieveBudget(id);

        assertEquals(400, result.getStatusCode());
        assertEquals(id + " is less than 1", result.getRenderable());
    }

}
