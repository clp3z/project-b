pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Project-B"
include(":app")
include(":entity")
include(":data")
include(":domain")
include(":feature")
include(":framework")
include(":network")
include(":framework:persistence")
include(":framework:network")
include(":framework:theme")
include(":framework:ui")
