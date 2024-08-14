package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CalculateVersionOfCurrentBuildTask extends DefaultTask {
    @TaskAction
    void getVersion() {

        String branchName = project.gitInfo.branchName
        String lastTag = project.gitInfo.lastTag

        String currentVersion = calculateVersion(lastTag, branchName)

        project.gitInfo.currentVersion = currentVersion
        println(currentVersion)

    }

    private String calculateVersion(String lastTag, String branchName) {
        String currentVersion = null

        int major = 0
        int minor = 0

        if (lastTag != "") {
            lastTag = lastTag.replaceAll("[v\\-rcSNAPSHOT]", "")
            String[] parts = lastTag.split("\\.");
            major = Integer.parseInt(parts[0])
            minor = Integer.parseInt(parts[1])
        }

        switch (branchName) {
            case 'dev':
            case 'qa':
                minor++
                currentVersion = "v" + major + "." + minor
                break
            case 'stage':
                currentVersion = "v" + major + "." + minor + "-rc"
                break
            case 'main':
            case 'master':
                minor = 0
                major++
                currentVersion = "v" + major + "." + minor
                break
            default:
                currentVersion = "v" + major + "." + minor + "-SNAPSHOT"
        }
        return currentVersion

    }

}
