/**
 * Copyright (C) 2012 the original author or authors.
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

package conf;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import providers.BudgetServiceProvider;
import providers.BudgetServiceProviderImpl;
import providers.UserFactoryProvider;
import providers.UserFactoryProviderImpl;
import services.UserFactory;
import services.UserFactoryImpl;

@Singleton
public class Module extends AbstractModule {

    protected void configure() {
        bind(UserFactory.class).to(UserFactoryImpl.class);
        bind(BudgetServiceProvider.class).to(BudgetServiceProviderImpl.class);
        bind(UserFactoryProvider.class).to(UserFactoryProviderImpl.class);
    }

}
