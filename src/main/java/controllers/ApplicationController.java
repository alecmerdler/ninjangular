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
import models.User;
import ninja.Result;
import ninja.Results;
import ninja.params.PathParam;
import services.UserFactory;


@Singleton
public class ApplicationController {
    private UserFactory userFactory;

    @Inject
    public ApplicationController(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    public Result index() {
        return Results.json().render("");
    }

    public Result user() {
        User user = this.userFactory.createUser();
        User parent = this.userFactory.createUser();
        user.giveParent(parent);

        return Results.json().render(user);
    }

    public Result createUser(User requestUser) {
        User user = this.userFactory.createUser();
        user.username = requestUser.username;

        return Results.json().render(user);
    }

    public Result parent(@PathParam("parent-name") String parentName) {
        User user = this.userFactory.createUser();
        User parent = this.userFactory.createUser();
        parent.username = parentName;
        user.giveParent(parent);

        return Results.json().render(user);
    }

}
