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
package me.champeau.paseq;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.tasks.Nested;
import org.gradle.api.tasks.TaskAction;
import org.gradle.process.ExecOperations;

import javax.inject.Inject;
import java.util.List;

public abstract class PaseqRun extends DefaultTask {
    @Nested
    abstract ListProperty<PaseqCommand> getCommands();

    @Inject
    protected abstract ExecOperations getExecOperations();

    @TaskAction
    void execute() {
        List<PaseqCommand> commands = getCommands().get();
        commands.stream()
                .forEachOrdered(this::executeCommand);
    }

    private void executeCommand(PaseqCommand paseqCommand) {
        if (Boolean.TRUE.equals(paseqCommand.getAsync().getOrElse(false))) {
            new Thread(() -> doExec(paseqCommand)).start();
        } else {
            doExec(paseqCommand);
        }
    }

    private void doExec(PaseqCommand paseqCommand) {
        getExecOperations().exec(spec -> spec.commandLine(paseqCommand.getCommand().get()));
    }
}
