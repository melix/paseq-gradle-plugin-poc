/*
 * Copyright 2003-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.champeau.paseq.internal;

import me.champeau.paseq.PaseqCommand;
import me.champeau.paseq.PaseqExtension;
import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.model.ObjectFactory;

import javax.inject.Inject;

public class DefaultPaseqExtension implements PaseqExtension {
    private final NamedDomainObjectContainer<PaseqCommand> commands;

    @Inject
    public DefaultPaseqExtension(ObjectFactory objectFactory) {
        commands = objectFactory.domainObjectContainer(PaseqCommand.class);
    }

    @Override
    public NamedDomainObjectContainer<PaseqCommand> getCommands() {
        return commands;
    }

    @Override
    public void commands(Action<? super NamedDomainObjectContainer<PaseqCommand>> action) {
        action.execute(commands);
    }
}
