package ru.clevertec.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class PublishTagInOriginTask extends DefaultTask {
    @TaskAction
    void publishTag() {
        if('git remote'.execute().text.trim() !="") {
            ('git push origin ' + project.gitInfo.currentVersion).execute()
            println('Done')
        }else{
            println("The remote repository is not defined")
        }
    }
}
