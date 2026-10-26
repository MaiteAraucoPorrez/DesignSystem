# UCB Design System

Design System multiplataforma desarrollado con Kotlin Multiplatform y Compose.

El proyecto contiene componentes visuales reutilizables, temas, colores y estilos compartidos para aplicaciones Android y otras plataformas compatibles.

## Estructura del proyecto

```text
design-system/
├── shared/
│   └── src/
│       ├── commonMain/
│       ├── androidMain/
│       └── commonTest/
├── gradle/
├── build.gradle.kts
├── gradle.properties
├── settings.gradle.kts
├── gradlew
└── gradlew.bat
```

## Requisitos

- JDK 17 o superior
- Gradle mediante el Gradle Wrapper incluido en el proyecto
- Android Studio actualizado
- Kotlin Multiplatform y Compose Multiplatform

## Compilar el proyecto

En Windows, desde la carpeta raíz del proyecto:

```cmd
gradlew.bat build
```

También se puede ejecutar:

```cmd
gradlew.bat :shared:build
```

En PowerShell:

```powershell
.\gradlew.bat build
```

## Publicar localmente

Para publicar el Design System en el repositorio local de Maven:

```cmd
gradlew.bat :shared:publishToMavenLocal
```

Después de publicar, los artefactos deben encontrarse en:

```text
%USERPROFILE%\.m2\repository\edu\ucb\ds\
```

La estructura esperada es similar a:

```text
edu\ucb\ds\
├── shared\
│   └── 1.0.0-SNAPSHOT\
└── shared-android\
    └── 1.0.0-SNAPSHOT\
```

## Usar el Design System en otra aplicación

Agrega el repositorio local de Maven en el proyecto consumidor:

```kotlin
repositories {
    mavenLocal()
    google()
    mavenCentral()
}
```

Luego agrega la dependencia publicada:

```kotlin
dependencies {
    implementation("edu.ucb.ds:shared:1.0.0-SNAPSHOT")
}
```

Si el proyecto requiere específicamente el artefacto Android, utiliza:

```kotlin
dependencies {
    implementation("edu.ucb.ds:shared-android:1.0.0-SNAPSHOT")
}
```

## Ejemplo de uso

```kotlin
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import edu.ucb.ds.components.buttons.PrimaryButton
import edu.ucb.ds.theme.MyProjectTheme

@Composable
fun ExampleScreen() {
    MyProjectTheme {
        PrimaryButton(
            text = "Entrar",
            onClick = {
                // Acción del botón
            }
        )

        Text(
            text = "Hola",
            color = MyProjectTheme.colors.primary
        )
    }
}
```

El contenido debe utilizarse dentro de una función `@Composable`.

## Limpieza antes de subir a GitHub

No se deben subir archivos generados localmente:

```text
.gradle/
build/
.kotlin/
.idea/
local.properties
*.iml
```

Estos archivos deben estar incluidos en `.gitignore`.

## Licencia

Proyecto académico desarrollado para la materia de Programación de Dispositivos Móviles de la Universidad Católica Boliviana.
```
## Publicar dentro del repo de la app

La app (`ucbp1_project_modified`, carpeta vecina) consume el Design System desde su carpeta `ds-repo/`,
así compila en cualquier computadora sin `publishToMavenLocal`:

```cmd
gradlew.bat :shared:publishAllPublicationsToAppRepoRepository
```

Después hay que hacer commit de `ds-repo/` en el repo de la app.

## Temas: claro, oscuro y alto contraste

```kotlin
MyProjectTheme(
    darkTheme = isSystemInDarkTheme(), // por defecto sigue al sistema
    highContrast = true                // usa HighContrastLightDsColors / HighContrastDarkDsColors
) { /* UI */ }
```

`dsColorsFor(darkTheme, highContrast)` devuelve la paleta correspondiente.
