package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CheckUncommittedChangesTask extends DefaultTask {
    public static final String FILE_NAME = "uncommitted_changes.log"
    public static final String POSTFIX = ".uncommitted"

    @TaskAction
    void hasUncompletedChanges() {
        String result = 'git status -s -uno'.execute().text.trim()

        boolean hasUncommittedChanges = false

        if (result != "") {

            try (FileWriter writer = new FileWriter(FILE_NAME)) {
                writer.write(project.gitInfo.currentVersion + POSTFIX)
            }
            hasUncommittedChanges = true
        }

        project.gitInfo.hasUncommittedChanges = hasUncommittedChanges

        println(hasUncommittedChanges)
    }
}
