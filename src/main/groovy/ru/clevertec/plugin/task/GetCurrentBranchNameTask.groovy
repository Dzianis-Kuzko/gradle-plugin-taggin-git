package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import ru.clevertec.plugin.service.GitService

class GetCurrentBranchNameTask extends DefaultTask {
    private GitService gitService = new GitService();

    @TaskAction
    void getBrunchName() {
        String branchName = gitService.getCurrentBranchName()
        project.gitInfo.branchName = branchName
        println("Current branch: " + branchName)
    }
}
