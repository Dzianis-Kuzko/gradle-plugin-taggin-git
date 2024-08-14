package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GetLastTagTask extends DefaultTask {
    @TaskAction
    void getLastTag() {
        String lastTag = 'git tag --sort=-creatordate --list "v[0-9]*.[0-9]*"'.execute().text.trim().split('\n')[0]
        project.gitInfo.lastTag=lastTag
        println(lastTag)
    }
}
