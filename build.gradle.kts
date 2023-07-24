import net.ltgt.gradle.errorprone.errorprone

plugins {
    id("com.diffplug.spotless") version "6.20.0"
    id("net.ltgt.errorprone") version "3.1.0"
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "com.diffplug.spotless")
    apply(plugin = "net.ltgt.errorprone")

    group = "org.zaproxy"

    version = "1.13.0-SNAPSHOT"
    extra["versionBC"] = "1.12.0"

    repositories {
        mavenCentral()
    }

    java {
        val javaVersion = JavaVersion.VERSION_11
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    spotless {
        java {
            licenseHeaderFile("$rootDir/gradle/spotless/license.java")

            googleJavaFormat("1.17.0").aosp()
        }

        kotlin {
            ktlint()
        }

        kotlinGradle {
            ktlint()
        }
    }

    dependencies {
        "errorprone"("com.google.errorprone:error_prone_core:2.20.0")
    }

    tasks.withType<JavaCompile> {
        options.encoding = "utf-8"
        options.compilerArgs = listOf("-Xlint:all", "-Werror")
        options.errorprone {
            disable("EmptyBlockTag", "InlineMeSuggester")
        }
    }
}

fun Project.java(configure: JavaPluginExtension.() -> Unit): Unit =
    (this as ExtensionAware).extensions.configure("java", configure)
