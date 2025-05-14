plugins {
    id("java")
    kotlin("jvm")
    id("org.gradle.antlr")
    @Suppress("SpellCheckingInspection")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "pocket"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.antlr:antlr4-runtime:4.13.2")
    antlr("org.antlr:antlr4:4.13.2")
    implementation("org.jetbrains:annotations:26.0.2")
    implementation("info.picocli:picocli:4.7.7")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.named("compileJava") {
    dependsOn("generateGrammarSource")
}

tasks.named<AntlrTask>("generateGrammarSource") {
    outputDirectory = file("src/main/java/pocket/antlr")
    arguments = listOf("-package", "pocket.antlr", "-visitor")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "pocket.Pocket"
    }
}

tasks.named("compileKotlin") {
    dependsOn(tasks.named("generateGrammarSource"))
}

tasks.shadowJar {
    archiveBaseName.set("pocket")
    archiveClassifier.set("")
}

kotlin {
    jvmToolchain(23)
}