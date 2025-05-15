pluginManagement {
    plugins {
        kotlin("jvm") version "2.1.21"
    }
}
plugins {
    @Suppress("SpellCheckingInspection")
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "pocket"