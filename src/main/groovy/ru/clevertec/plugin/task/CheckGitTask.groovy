package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CheckGitTask extends DefaultTask {

    @TaskAction
    void checkGitRepo() {
        if (isGitRepo()) {
            println "Git is being used in this project."
        } else {
            println "This project is not under Git version control."
        }
    }

    private boolean isGitRepo() {
        project.gitInfo.hasGit = project.file('.git').exists()

        return project.gitInfo.hasGit
    }
}