import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "1.9.0"
    `maven-publish`
}

group = "world.estaria"
version = "1.0.7"

repositories {
    mavenCentral()
}

dependencies {
    // avionik dependencies
    compileOnly("world.avionik:config-kit:1.0.2")
    runtimeOnly("world.avionik:config-kit:1.0.2")

    // discord dependencies
    api("net.dv8tion:JDA:5.0.0-beta.23") {
        exclude("opus-java")
    }

    // log4j dependencies
    compileOnly("org.apache.logging.log4j:log4j-core:2.23.1")
    runtimeOnly("org.apache.logging.log4j:log4j-core:2.23.1")
    compileOnly("org.apache.logging.log4j:log4j-slf4j-impl:2.23.1")
    runtimeOnly("org.apache.logging.log4j:log4j-slf4j-impl:2.23.1")
}

tasks.named("shadowJar", ShadowJar::class) {
    mergeServiceFiles()
}

publishing {
    repositories {
        maven {
            name = "estaria"
            url = uri("https://repo.estaria.world/releases")
            credentials(PasswordCredentials::class.java)
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}