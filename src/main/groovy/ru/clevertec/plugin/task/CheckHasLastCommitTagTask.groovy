package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CheckHasLastCommitTagTask extends DefaultTask {
    @TaskAction
    void hasTag() {
        boolean hasTag = false;
        String tag = 'git describe --tags --exact-match'.execute().text.trim();

        if (tag != "") {
            hasTag = true
        }

        project.gitInfo.hasTag = hasTag
        println(hasTag)
    }
}
