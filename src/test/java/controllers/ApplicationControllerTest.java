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


import models.User;
import ninja.Result;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import services.UserFactory;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationControllerTest {
    ApplicationController controller;

    @Mock
    UserFactory userFactoryMock;

    @Before
    public void beforeEach() {
        controller = new ApplicationController(userFactoryMock);

        when(userFactoryMock.createUser()).thenReturn(new User());
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

        verify(userFactoryMock, times(2)).createUser();
        assertEquals(result.getContentType(), "application/json");
        assertEquals(200, result.getStatusCode());
        assertEquals("johncleese", user.username);
        assertEquals("John", user.firstName);
        assertEquals("Cleese", user.lastName);
        assertEquals("password", user.password);
        assertEquals("johncleese", user.parent.username);
    }

    @Test
    public void testRetrieveParent() {
        Result result = this.controller.retrieveParent("parent");
        User parent = (User) result.getRenderable();

        assertEquals("application/json", result.getContentType());;
        assertEquals(200, result.getStatusCode());
        assertEquals("parent", parent.username);
    }

    @Test
    public void testCreateUser() {
        User requestUser = new User();
        requestUser.username = "bob";

        Result result = this.controller.createUser(requestUser);
        User user = (User) result.getRenderable();

        assertEquals(200, result.getStatusCode());
        assertEquals(requestUser.username, user.username);
    }

}
