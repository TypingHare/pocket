plugins {
    kotlin("jvm") version "2.1.21"
    id("org.gradle.antlr")
}

group = "pocket"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain {
        this.languageVersion.set(JavaLanguageVersion.of(23))
    }
}

dependencies {
    testImplementation(kotlin("test"))

    antlr("org.antlr:antlr4:4.13.2")
    implementation("org.antlr:antlr4-runtime:4.13.2")
    implementation("info.picocli:picocli:4.7.7")
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.2.0")
    implementation("org.jgrapht:jgrapht-core:1.5.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.named<AntlrTask>("generateGrammarSource") {
    outputDirectory = file("src/main/java/pocket/antlr")
    arguments = listOf("-package", "pocket.antlr", "-visitor")
}

tasks.named("compileKotlin") {
    dependsOn(tasks.named("generateGrammarSource"))
}