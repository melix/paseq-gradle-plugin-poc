# Proof-of-concept

Proof-of-concept demo of Paseq plugin for Gradle

See https://github.com/maciejwalkowiak/paseq-maven-plugin/
for the reference Maven implementation.

The `paseq-plugin` directory contains the Gradle plugin,
while the `demo-groovy-dsl` and `demo-kotlin-dsl` projects
show how the plugin can be configured using the respective
DSL implementations.

You can call :
   - `./gradlew :demo-groovy-dsl:paseq` to execute the Groovy version
   - `./gradlew :demo-kotlin-dsl:paseq` for the Kotlin DSL version
   - `./gradlew paseq` will execute both
