package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import ru.clevertec.plugin.exception.NotUnderGitControlException
import ru.clevertec.plugin.service.GitService

class CheckGitTask extends DefaultTask {
    private GitService gitService = new GitService();

    @TaskAction
    void checkGit() {
        if (gitService.isUnderGitControl()) {
            println "Git is being used in this project."
        } else {
            throw new NotUnderGitControlException("This project is not under Git control.");
        }
    }

}