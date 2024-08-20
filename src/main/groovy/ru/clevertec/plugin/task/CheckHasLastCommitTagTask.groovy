package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import ru.clevertec.plugin.exception.LastCommitHasTagException
import ru.clevertec.plugin.service.GitService

class CheckHasLastCommitTagTask extends DefaultTask {
    private GitService gitService = new GitService();

    @TaskAction
    void hasTag() {
        String tag = gitService.getLastCommitTag();

        if (!tag.isEmpty()) {
            throw  new LastCommitHasTagException("The last commit has a tag: " + tag)
        }

        println("The last commit does not have a tag")
    }
}
