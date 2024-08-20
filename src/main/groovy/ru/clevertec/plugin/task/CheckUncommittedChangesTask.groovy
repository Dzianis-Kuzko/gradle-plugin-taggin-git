package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import ru.clevertec.plugin.exception.UncommittedChangesException
import ru.clevertec.plugin.service.FileService
import ru.clevertec.plugin.service.GitService

class CheckUncommittedChangesTask extends DefaultTask {
    public static final String FILE_NAME = "uncommitted_changes.log"
    public static final String POSTFIX = ".uncommitted"

    private GitService gitService = new GitService()
    private FileService fileService = new FileService()

    @TaskAction
    void hasUncommittedChanges() {
        String uncommittedChanges = gitService.getUncommittedChanges()

        if (!uncommittedChanges.isEmpty()) {
            fileService.writeToFile(FILE_NAME, project.gitInfo.currentVersion + POSTFIX)
            throw new UncommittedChangesException("There are uncommitted changes. See " + FILE_NAME)
        }

        println("There are no uncommitted changes")
    }
}
