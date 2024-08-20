package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import ru.clevertec.plugin.service.GitService

class PublishTagInOriginTask extends DefaultTask {
    private GitService gitService = new GitService()

    @TaskAction
    void publishTag() {
        if (!gitService.getRemote().isEmpty()) {
            gitService.publishTag(project.gitInfo.currentVersion)
            println('Done')
        } else {
            println("The remote repository is not defined")
        }
    }
}
