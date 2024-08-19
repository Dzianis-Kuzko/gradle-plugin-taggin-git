package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import ru.clevertec.plugin.service.GitService

class AssignTagTask extends DefaultTask {
    private GitService gitService = new GitService()

    @TaskAction
    void assignTag() {
        String tag = project.gitInfo.currentVersion

        gitService.assignTag(tag)

        println('The tag has been assigned: ' + tag)
    }
}
