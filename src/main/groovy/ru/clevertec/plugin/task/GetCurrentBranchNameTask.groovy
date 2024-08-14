package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GetCurrentBranchNameTask extends DefaultTask{
    @TaskAction
    void getBrunchName(){
        String branchName = 'git branch --show-current'.execute().text.trim()
        project.gitInfo.branchName = branchName
        println("Current branch: " + branchName)
    }
}
