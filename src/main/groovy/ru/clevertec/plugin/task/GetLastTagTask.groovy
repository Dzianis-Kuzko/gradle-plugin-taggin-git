package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import ru.clevertec.plugin.service.GitService

class GetLastTagTask extends DefaultTask {
    private GitService gitService = new GitService();

    @TaskAction
    void getLastTag() {
        String lastTag = gitService.getLastTag()
        project.gitInfo.lastTag = lastTag
        println(lastTag)
    }
}
