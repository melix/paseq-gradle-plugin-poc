plugins {
    id("me.champeau.paseq")
}

paseq {
    commands {
        create("hello") {
            command.set(listOf("ls", "-al"))
        }
        create("world") {
            async.set(true)
            command.set(listOf(file("long.sh").absolutePath))
        }
    }
}
