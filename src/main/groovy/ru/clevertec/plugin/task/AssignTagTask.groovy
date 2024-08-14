package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class AssignTagTask extends DefaultTask {
    @TaskAction
    void assignTag() {
        ('git tag ' + project.gitInfo.currentVersion).execute()

        project.gitInfo.isTagAssigned==true

        println('The tag has been assigned: ' + project.gitInfo.currentVersion)
    }
}
