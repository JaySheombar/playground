import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

buildscript {
    repositories {
        google()
        mavenCentral()

        maven { url = uri("https://plugins.gradle.org/m2/") }
    }
}

plugins {
    id(Build.application) version Build.version apply false
    id(Build.android) version Build.version apply false
    id(Build.kotlin) version Build.kotlinVersion apply false
    id(Build.hilt) version DaggerHilt.version apply false
    id(Build.ktlint) version Build.ktlintVersion
}

subprojects {
    apply(plugin = Build.ktlint)

    configure<KtlintExtension> {
        debug.set(true)
        verbose.set(true)
        android.set(true)
        outputToConsole.set(true)
        ignoreFailures.set(false)
        disabledRules.set(
            setOf(
                "no-wildcard-imports",
                "import-ordering",
                "final-newline",
            )
        )
        reporters {
            reporter(ReporterType.PLAIN)
            reporter(ReporterType.CHECKSTYLE)
        }
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}