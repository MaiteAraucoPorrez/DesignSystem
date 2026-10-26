import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    id("maven-publish")
}

// Coordenadas de la librería: edu.ucb.ds:shared:1.0.0-SNAPSHOT
group = "edu.ucb.ds"
version = "1.0.0-SNAPSHOT"

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-opt-in=androidx.compose.material3.ExperimentalMaterial3Api")
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    android {
        namespace = "edu.ucb.ds.shared"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        compilerOptions {
            jvmTarget = JvmTarget.JVM_17
        }
    }

    sourceSets {
        commonMain.dependencies {
            // "api": la app que use el Design System recibe también estos tipos de Compose.
            api(libs.compose.runtime)
            api(libs.compose.foundation)
            api(libs.compose.material3)
            api(libs.compose.ui)
            implementation(libs.compose.uiToolingPreview)
        }
    }
}

// Además de mavenLocal, se publica dentro del repo de la app (carpeta ds-repo),
// así la app compila en cualquier computadora sin ejecutar publishToMavenLocal antes.
// Uso: ./gradlew publishAllPublicationsToAppRepoRepository
publishing {
    repositories {
        maven {
            name = "appRepo"
            url = uri(rootProject.file("../ucbp1_project_modified/ds-repo"))
        }
    }
}
