include("zap-clientapi")
include("zap-clientapi-ant")

rootProject.name = "zap-api-java"

rootProject.children.forEach { project ->
    project.projectDir = File("$settingsDir/subprojects/", project.name)
    project.buildFileName = "${project.name}.gradle"

    if (!project.projectDir.isDirectory) {
        throw AssertionError("Project ${project.name} has no directory: ${project.projectDir}")
    }
    if (!project.buildFile.isFile) {
        throw AssertionError("Project ${project.name} has no build file: ${project.buildFile}")
    }
}
