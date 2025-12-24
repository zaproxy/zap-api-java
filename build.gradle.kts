import net.ltgt.gradle.errorprone.errorprone

plugins {
    id("com.diffplug.spotless")
    id("net.ltgt.errorprone") version "4.0.0"
    id("org.zaproxy.common")
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "com.diffplug.spotless")
    apply(plugin = "net.ltgt.errorprone")
    apply(plugin = "org.zaproxy.common")

    group = "org.zaproxy"

    version = "2.0.0-SNAPSHOT"
    extra["versionBC"] = "1.17.0"

    java {
        if (System.getenv("RELEASE") != null) {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(11))
            }
        } else {
            val javaVersion = JavaVersion.VERSION_11
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
        }
    }

    spotless {
        kotlin {
            ktlint()
        }

        kotlinGradle {
            ktlint()
        }
    }

    dependencies {
        "errorprone"("com.google.errorprone:error_prone_core:2.28.0")
    }

    tasks.withType<JavaCompile> {
        options.errorprone {
            disable("EmptyBlockTag", "InlineMeSuggester")
        }
    }
}

fun Project.java(configure: JavaPluginExtension.() -> Unit): Unit =
    (this as ExtensionAware).extensions.configure("java", configure)
