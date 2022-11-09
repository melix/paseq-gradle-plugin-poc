package me.champeau.paseq;

import me.champeau.paseq.internal.DefaultPaseqExtension;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class PaseqPlugin implements Plugin<Project> {
    public void apply(Project p) {
        PaseqExtension paseq = p.getExtensions().create(PaseqExtension.class, "paseq", DefaultPaseqExtension.class);
        p.getTasks().register("paseq", PaseqRun.class, spec -> {
            spec.setDescription("Executes Paseq commands");
            spec.getCommands().convention(paseq.getCommands());
        });
    }
}
